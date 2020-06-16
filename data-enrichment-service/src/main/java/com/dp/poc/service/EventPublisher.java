package com.dp.poc.service;

import com.dp.poc.model.Order;
import com.dp.poc.repository.OrderRepo;
import com.dp.poc.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
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
    private OrderRepo orderRepo;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${topic.name}")
    private String topic;

    /**
     * Method to publish message into given topic.
     *
     * @throws Exception
     */
    public void readAndPublish() throws Exception {
        /* Read the orders data by querying order table.*/
        List<Order> searchedOrders = orderRepo.findOrders();
        log.info("Number of searched orders: {} to topic: {}", searchedOrders.size(), topic);

        /* Publish orders information as a events. */
        for (Order order : searchedOrders) {
            /* Translate message object to json message. */
            String jsonMessage = JsonUtils.serializeJson(order);
            kafkaTemplate.send(topic, jsonMessage);
        }
    }
}
