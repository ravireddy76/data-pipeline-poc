package com.di.poc.listener;

import com.di.poc.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * DataProcessListener class used to consume message from kafka topic,Compute claims and ingest data results into MS SQL server.
 *
 * @author Ravi Reddy
 * @CopyRight (C) All rights reserved to Ravi POC World Inc. It's Illegal to reproduce this code.
 */
@Service
@Slf4j
public class DataProcessListener {

    @KafkaListener(topics = "${topic.name}")
    public void messageListener(@Payload String messagePayload) throws Exception {
        log.info("Message: {}", messagePayload);

        //TODO consume message and process and ingest data into defined database.
        Map<String, String> data = JsonUtils.deserializeJson(Map.class, messagePayload);

        log.info("Message Data: {}", data);

//        claimIdentifyService.searchAndComputeClaims(claimEvent.getClaimInstCode());
//        log.info("Member claims search, computed and ingested into mongodb database for claims instruction code: {}", claimEvent.getClaimInstCode());
    }
}
