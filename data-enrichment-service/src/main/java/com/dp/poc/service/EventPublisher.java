package com.dp.poc.service;

import com.dp.poc.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
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
public class EventPublisher {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${topic.name}")
    private String topic;

    /**
     * Method to publish message into given topic.
     *
     * @param messageEvent
     * @throws Exception
     */
    public void publish(Map<String, String> messageEvent) throws Exception {
        log.info("sending message='{}' to topic='{}'", messageEvent.toString(), topic);

        /* Translate message object to json message. */
        String jsonMessage = JsonUtils.serializeJson(messageEvent);
        kafkaTemplate.send(topic, jsonMessage);
    }
}
