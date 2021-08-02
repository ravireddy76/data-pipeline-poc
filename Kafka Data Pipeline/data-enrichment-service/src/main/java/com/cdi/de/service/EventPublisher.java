package com.cdi.de.service;


import com.cdi.de.util.JsonUtils;
import com.cdi.de.util.Operation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
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

//    @Autowired
//    private OrderRepo orderRepo;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${topic.order}")
    private String orderTopic;

    @Value("${topic.cdc}")
    private String cdcTopic;

    @Value("${topic.t_alerts}")
    private String alertsTopic;

    /**
     * Method to publish message into given topic.
     *
     * @throws Exception
     */
//    public void readAndPublish() throws Exception {
//        /* Read the orders data by querying order table.*/
//        List<Order> searchedOrders = orderRepo.findOrders();
//        log.info("Number of searched orders: {} to topic: {}", searchedOrders.size(), orderTopic);
//
//        /* Publish orders information as a events. */
//        for (Order order : searchedOrders) {
//            /* Translate message object to json message. */
//            String jsonMessage = JsonUtils.serializeJson(order);
//            kafkaTemplate.send(orderTopic, jsonMessage);
//        }
//    }

    /**
     * Method to publish cdc events.
     *
     * @param changeData
     * @param operation
     */
    public void cdcPublish(String topicName, Map<String, Object> changeData, Operation operation) {
        log.info("Operation: {}, Change Data: {}", operation.name(), changeData);
        try {
            /* Translate message object to json message. */
            changeData.put("operationType", operation.name());
            String jsonMessage = JsonUtils.serializeJson(changeData);
            kafkaTemplate.send(topicName, jsonMessage);
        } catch (Exception ex) {
            log.error("Exception publishing message to topic :{}", ExceptionUtils.getStackTrace(ex));
        }
    }

}
