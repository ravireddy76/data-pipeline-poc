package com.dp.poc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DebeziumConfig class used to configure debezium configuration.
 *
 * @author Ravi Reddy
 * @CopyRight (C) All rights reserved to Ravi POC Inc. It's Illegal to reproduce this code.
 */
@Configuration
public class DebeziumConfig {

    private final String dbHost = "localhost";
    private final String dbName = "datapipeline";
    private final String dbPort = "5432";

    @Value("${spring.datasource.username}")
    private String dbUserName;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    /**
     * Student database connector.
     *
     * @return Configuration.
     */
    @Bean
    public io.debezium.config.Configuration debeziumConnectorConfig() {
        return io.debezium.config.Configuration.create()
                .with("connector.class", "io.debezium.connector.postgresql.PostgresConnector")
                .with("offset.storage",  "org.apache.kafka.connect.storage.FileOffsetBackingStore")
                .with("offset.storage.file.filename", "C:/Tools/Z-DataFile/pg-debezium-poc-data.dat")
                .with("offset.flush.interval.ms", 60000)
                .with("name", "db-postgres-connector")
                .with("database.server.name", dbHost+"-"+dbName)
                .with("database.hostname", dbHost)
                .with("database.port", dbPort)
                .with("database.user", dbUserName)
                .with("database.password", dbPassword)
                .with("database.dbname", dbName)
                .with("wal_level", "logical")
                .with("table.whitelist", "poc_catalog.orders")
                .build();
    }

}
