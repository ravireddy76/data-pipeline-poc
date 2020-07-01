package com.dp.poc.listener;

import com.dp.poc.service.EventPublisher;
import com.dp.poc.util.Operation;
import io.debezium.config.Configuration;
import io.debezium.embedded.EmbeddedEngine;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.kafka.connect.data.Field;
import org.apache.kafka.connect.data.Struct;
import org.apache.kafka.connect.source.SourceRecord;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static io.debezium.data.Envelope.FieldName.*;
import static java.util.stream.Collectors.toMap;

/**
 * This class creates, starts and stops the EmbeddedEngine, which starts the Debezium engine. The engine also
 * loads and launches the connectors setup in the configuration.
 * <p>
 * The class uses @PostConstruct and @PreDestroy functions to perform needed operations.
 *
 * @author Ravi Reddy
 * @CopyRight (C) All rights reserved to Ravi POC World Inc. It's Illegal to reproduce this code.
 */
@Slf4j
@Component
public class CdcListener {

    private final Executor executor = Executors.newSingleThreadExecutor();

    /** The Debezium engine which needs to be loaded with the configurations, Started and Stopped - for the
        CDC to work. */
    private final EmbeddedEngine engine;

    /** Handle to the Service layer, which interacts with kafka to publish cdc events to kafka streams.*/
    private final EventPublisher eventPublisher;

    /**
     * Constructor which loads the configurations and sets a callback method 'handleEvent', which is invoked when
     * a DataBase transactional operation is performed.
     *
     * @param debeziumConnectorConfig
     * @param eventPublisher
     */
    private CdcListener(Configuration debeziumConnectorConfig, EventPublisher eventPublisher) {
        this.engine = EmbeddedEngine
                .create()
                .using(debeziumConnectorConfig)
                .notifying(this::handleEvent).build();

        this.eventPublisher = eventPublisher;
    }

    /** The method is called after the Debezium engine is initialized and started asynchronously using the Executor. */
    @PostConstruct
    private void start() {
        this.executor.execute(engine);
    }

    /** This method is called when the container is being destroyed. This stops the debezium, merging the Executor.*/
    @PreDestroy
    private void stop() {
        if (this.engine != null) {
            this.engine.stop();
        }
    }

    /**
     * This method is invoked when a transactional action is performed on any of the tables that were configured.
     *
     * @param sourceRecord
     */
    private void handleEvent(SourceRecord sourceRecord) {
        Struct sourceRecordValue = (Struct) sourceRecord.value();

        if(sourceRecordValue != null) {
            Operation operation = Operation.forCode((String) sourceRecordValue.get(OPERATION));

            //Only if this is a transactional operation.
            if(operation != Operation.READ) {

                Map<String, Object> message;
                String record = AFTER; //For Update & Insert operations.

                if (operation == Operation.DELETE) {
                    record = BEFORE; //For Delete operations.
                }

                //Build a map with all row data received.
                Struct struct = (Struct) sourceRecordValue.get(record);
                message = struct.schema().fields().stream()
                        .map(Field::name)
                        .filter(fieldName -> struct.get(fieldName) != null)
                        .map(fieldName -> Pair.of(fieldName, struct.get(fieldName)))
                        .collect(toMap(Pair::getKey, Pair::getValue));

                //Call the service to handle the data change.
                this.eventPublisher.cdcPublish(message, operation);
                log.info("Data Changed: {} with Operation: {}", message, operation.name());
            }
        }
    }
}
