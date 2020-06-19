package com.dp.poc;

import com.dp.poc.service.EventPublisher;
import io.debezium.config.Configuration;
import io.debezium.embedded.EmbeddedEngine;
import io.debezium.engine.DebeziumEngine;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.connect.connector.ConnectRecord;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.kafka.connect.source.SourceRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan(basePackages = {"com.dp.poc"})
@Slf4j
public class DataEnrichmentApplication {

    private static ApplicationContext localContext = null;

    public static void main(String[] args) {
        //SpringApplication.run(DataEnrichmentApplication.class, args);
        ApplicationContext context = SpringApplication.run(DataEnrichmentApplication.class, args);

        /* Assign application context to local context.*/
        localContext = context;

        /* Execute the postgres debezium postgres connector as a cdc plugin.*/
        DataEnrichmentApplication dataEnrichmentApplication = new DataEnrichmentApplication();
        dataEnrichmentApplication.runPGCdc(context);
    }


    /**
     * Method to run postgres cdc process to poll continuously database activity changes.
     *
     * @param context
     */
    private void runPGCdc(ApplicationContext context) {
        /* Build the pg connector configuration.*/
        Configuration pgConfig = pgConnectorConfig();

        /* Create the engine with this configuration */
        EmbeddedEngine engine = EmbeddedEngine.create()
                .using(pgConfig).notifying(this::handleEvent).build();

        /* Run the engine asynchronously */
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(engine);
    }

    /**
     * Method to handle cdc events.
     *
     * @param connectRecord
     */
    private void handleEvent(ConnectRecord connectRecord) {
        EventPublisher eventPublisher = (EventPublisher) localContext.getBean("eventPublisher");

        try {
            eventPublisher.readAndPublish();
        } catch (Exception ex) {
            System.out.println("Exception: " + ExceptionUtils.getStackTrace(ex));
        }
    }


    /**
     * Method to build postgres debezium connector configuration.
     *
     * @return Configuration
     */
    private Configuration pgConnectorConfig() {
        return Configuration.create()
                .with("connector.class", "io.debezium.connector.postgresql.PostgresConnector")
                .with("offset.storage", "org.apache.kafka.connect.storage.FileOffsetBackingStore")
                .with("offset.storage.file.filename", "/datalogs/offsetdata.dat")
                .with("offset.flush.interval.ms", 60000)
                .with("name", "postgres-connector")
                .with("database.server.name", "jdbc:postgresql://localhost:5432/datapipeline")
                .with("database.hostname", "localhost")
                .with("database.port", "5432")
                .with("database.user", "test")
                .with("database.password", "test9988")
                .with("database.dbname", "datapipeline")
                .with("table.whitelist", "poc_catalog.orders")
                .with("database.history", "io.debezium.relational.history.FileDatabaseHistory")
                .with("database.history.file.filename", "/datalogs/dbhistorydata.dat")
                .with("rds.logical_replication", 1)
                .with("wal_level", "logical")
                .with("max_wal_senders", 1)
                .with("max_replication_slots", 1)
                .with("plugin.name", "wal2json")
                .with("errors.log.enable", true)
                .with("errors.logs.include.messages", true)
                .with("connect.keep.alive", "true")
                .build();
    }


//    private void backupCode(){
//        try {
//            EventPublisher eventPublisher = (EventPublisher) context.getBean("eventPublisher");
//            eventPublisher.readAndPublish();
//        } catch (Exception ex) {
//            log.error("Process failed due to exception: " + ExceptionUtils.getStackTrace(ex));
//        } finally {
//            ((ConfigurableApplicationContext) context).close();
//        }
//    }

}
