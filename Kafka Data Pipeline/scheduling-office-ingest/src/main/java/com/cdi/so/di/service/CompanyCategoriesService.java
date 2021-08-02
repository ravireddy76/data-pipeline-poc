package com.cdi.so.di.service;

import com.cdi.domain.model.CallCategory;
import com.cdi.domain.model.HieConsent;
import com.cdi.domain.model.PatientAccessReason;
import com.cdi.domain.util.JsonUtils;
import com.cdi.so.di.util.AbstractDataTransaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Map;

/**
 * CompanyCategoriesService class used to consume message from kafka topics for
 * hie consents, call categories,patient access reasons
 * and ingest data into target tables in MS SQL server.
 *
 * @author Ravi Reddy
 * @CopyRight (C) All rights reserved to CDI Inc. It's Illegal to reproduce this code.
 */
@Service
@Slf4j
public class CompanyCategoriesService {

    @Autowired
    private AbstractDataTransaction dataTransaction;

    /**
     * Method to listen hie consents topic and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_hie_consents}")
    public void hieConsentsListener(@Payload String messagePayload) throws Exception {
        log.info("CompanyCategoriesService:hieConsentsListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> hieConsentsMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        HieConsent hieConsent = buildHieConsents(hieConsentsMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(hieConsent);
        log.info("HieConsent is Saved/Updated for the id: {} ", hieConsent.getId());
    }

    /**
     * Method to listen hie consents topic and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_call_categories}")
    public void callCategoriesListener(@Payload String messagePayload) throws Exception {
        log.info("CompanyCategoriesService:callCategoriesListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> callCategoriesMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        CallCategory callCategory = buildCallCategories(callCategoriesMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(callCategory);
        log.info("CallCategory is Saved/Updated for the id: {} ", callCategory.getId());
    }

    /**
     * Method to listen hie consents topic and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_patient_access_reasons}") //Working
    public void patientAccessReasonsListener(@Payload String messagePayload) throws Exception {
        log.info("CompanyCategoriesService:patientAccessReasonsListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> patientAccessReasonsMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        PatientAccessReason patientAccessReason = buildPatientAccessReason(patientAccessReasonsMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(patientAccessReason);
        log.info("PatientAccessReasons is Saved/Updated for the id: {} ", patientAccessReason.getId());
    }

    /**
     * Method to build hie consents information.
     *
     * @param hieConsentsMessage
     * @return HieConsent
     */
    private HieConsent buildHieConsents(Map<String, Object> hieConsentsMessage) {
        HieConsent hieConsent = new HieConsent();

        hieConsent.setId((Integer) hieConsentsMessage.get("id"));
        hieConsent.setLastAction((String) hieConsentsMessage.get("operationType"));
        hieConsent.setLastModified(new Timestamp(System.currentTimeMillis()));
        return hieConsent;
    }

    /**
     * Method to build call categories information.
     *
     * @param callCategoriesMessage
     * @return CallCategory
     */
    private CallCategory buildCallCategories(Map<String, Object> callCategoriesMessage) {
        CallCategory callCategory = new CallCategory();

        callCategory.setId((Integer) callCategoriesMessage.get("id"));
        callCategory.setLastAction((String) callCategoriesMessage.get("operationType"));
        callCategory.setLastModified(new Timestamp(System.currentTimeMillis()));
        return callCategory;
    }

    /**
     * Method to build the patient access reasons.
     *
     * @param patientAccessReasonsMessage
     * @return PatientAccessReasons
     */
    private PatientAccessReason buildPatientAccessReason(Map<String, Object> patientAccessReasonsMessage) {
        PatientAccessReason patientAccessReasons = new PatientAccessReason();
        long id = new Long((Integer) patientAccessReasonsMessage.get("id")).longValue();

        patientAccessReasons.setId(id);
        patientAccessReasons.setCompanyId((Integer) patientAccessReasonsMessage.get("company_id"));
        patientAccessReasons.setDescription((String) patientAccessReasonsMessage.get("description"));
        patientAccessReasons.setLastAction((String) patientAccessReasonsMessage.get("operationType"));
        patientAccessReasons.setLastModified(new Timestamp(System.currentTimeMillis()));
        return  patientAccessReasons;
    }

}
