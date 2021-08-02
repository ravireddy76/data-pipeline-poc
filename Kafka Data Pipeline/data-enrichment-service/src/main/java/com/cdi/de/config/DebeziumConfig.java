package com.cdi.de.config;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.InputStream;

/**
 * DebeziumConfig class used to configure debezium configuration.
 *
 * @author Ravi Reddy
 * @CopyRight (C) All rights reserved to Ravi POC Inc. It's Illegal to reproduce this code.
 */
@Configuration
public class DebeziumConfig {

    @Autowired
    ResourceLoader resourceLoader;

    @Value("${dbinfo.host}")
    private String dbHost;

    @Value("${dbinfo.dbname}")
    private String dbName;

    @Value("${dbinfo.port}")
    private String dbPort;

    @Value("${spring.datasource.username}")
    private String dbUserName;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Value("${cdcevent.tables}")
    private String cdcEventTables;

    @Value("${dbinfo.offsetfile}")
    private String offsetStorageFile;


    /**
     * Student database connector.
     *
     * @return Configuration.
     */
    @Bean
    public io.debezium.config.Configuration debeziumConnectorConfig() throws Exception {
        /* Get the *.dat file from resource folder for kafka data backup file.*/
        Resource resource = resourceLoader.getResource(offsetStorageFile);
        File file = resource.getFile();

        return io.debezium.config.Configuration.create()
                .with("connector.class", "io.debezium.connector.postgresql.PostgresConnector")
                .with("offset.storage",  "org.apache.kafka.connect.storage.FileOffsetBackingStore")
                .with("offset.storage.file.filename", file.getName())
                .with("offset.flush.interval.ms", 60000)
                .with("name", "db-postgres-connector")
                .with("database.server.name", dbHost+"-"+dbName)
                .with("database.hostname", dbHost)
                .with("database.port", dbPort)
                .with("database.user", dbUserName)
                .with("database.password", dbPassword)
                .with("database.dbname", dbName)
                .with("wal_level", "logical")
                .with("plugin.name", "pgoutput")
                .with("table.whitelist", cdcEventTables)
                //.with("slot.name", "ravi_n")
                .build();
    }

}
