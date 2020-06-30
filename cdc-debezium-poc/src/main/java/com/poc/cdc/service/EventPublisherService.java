package com.poc.cdc.service;


import com.poc.cdc.util.JsonUtils;
import com.poc.cdc.util.Operation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * EventPublisher class used to publish events or messages into given kafka topic.
 *
 * @author Ravi Reddy
 * @CopyRight (C) All rights reserved to Ravi POC World Inc. It's Illegal to reproduce this code.
 */
@Service
@Slf4j
public class EventPublisherService {

    @Value("${topic.name}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * Method to publish message into given topic.
     *
     * @param claimData
     * @param operation
     * @throws Exception
     */
    public void publishEvents(Map<String, Object> claimData, Operation operation) {
        System.out.println("Inside read and publish..");
        System.out.println("###### Operation Name ::" + operation.code());
        System.out.println("#### Claims Data ::" + claimData);


        try{

            claimData.put("operationType", operation.name());
            /* Translate message object to json message. */
            String jsonMessage = JsonUtils.serializeJson(claimData);
            kafkaTemplate.send(topic, jsonMessage);
        }catch(Exception ex){
            log.error("Exception publishing message to topic :{}", ExceptionUtils.getStackTrace(ex));
        }
    }
}
