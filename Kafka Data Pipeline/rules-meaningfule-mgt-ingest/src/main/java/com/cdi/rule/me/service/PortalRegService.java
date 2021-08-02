package com.cdi.rule.me.service;

import com.cdi.domain.model.PpPatient;
import com.cdi.domain.repository.DataRepository;
import com.cdi.domain.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * PortalRegService class used to consume message from kafka topics and ingest data into
 * target tables in MS SQL server.
 *
 * @author Temam G.
 * @CopyRight (C) All rights reserved to CDI Inc. It's Illegal to reproduce this code.
 */
@Service
@Slf4j
public class PortalRegService {

    @Autowired
    private DataRepository dataRepository;

    /**
     * Method to listen application entities and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_pp_patients}")
    public void ppPatientsListener(@Payload String messagePayload) throws Exception {
        log.info("PortalRegService:ppPatientsListener::Message: {}", messagePayload);

        /* Build the pp patients from kafka message. */
        Map<String, Object> ppPatientsMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        PpPatient ppPatient = buildPpPatients(ppPatientsMessage);

        /* Save or persist the data into the table. */
        dataRepository.save(ppPatient);
        log.info("PpPatient is Saved/Updated for the id: {} ", ppPatient.getId());
    }

    /**
     * Method to build pp patients
     * @param ppPatientsMessage
     * @return
     */
    private PpPatient buildPpPatients(Map<String, Object> ppPatientsMessage) {
        PpPatient ppPatient = new PpPatient();

        return ppPatient;
    }
}
