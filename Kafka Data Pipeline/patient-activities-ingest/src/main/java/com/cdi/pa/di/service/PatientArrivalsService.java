package com.cdi.pa.di.service;

import com.cdi.domain.model.Order;
import com.cdi.domain.model.PatientAltNames;
import com.cdi.domain.model.StudyCpt;
import com.cdi.domain.repository.DataRepository;
import com.cdi.domain.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Map;

/**
 * PatientArrivalsService class used to consume message from kafka topics and ingest data into
 * target tables in MS SQL server.
 *
 * @author Temam G.
 * @CopyRight (C) All rights reserved to CDI Inc. It's Illegal to reproduce this code.
 */
@Service
@Slf4j
public class PatientArrivalsService {

    @Autowired
    private DataRepository dataRepository;

    /**
     * Method to listen Patient Alt Names and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
//    @KafkaListener(topics = "${topic.t_patient_alt_names}") // Works fine
//    public void patientAltNamesListener(@Payload String messagePayload) throws Exception {
//        log.info("ClinicalActivityService:patientAltNamesListener::Message: {}", messagePayload);
//
//        /* Build the PatientAltNames from kafka message. */
//        Map<String, Object> patientAltNamesMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
//        PatientAltNames patientAltNames = buildPatientAltNames(patientAltNamesMessage);
//
//        /* Save or persist the data into the table. */
//        dataRepository.save(patientAltNames);
//        log.info("PatientAltNames is Saved/Updated for the id: {} ", patientAltNames.getId());
//    }

    /**
     * Method to listen study cpt and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
//    @KafkaListener(topics = "${topic.t_study_cpt}")
//    public void studyCptListener(@Payload String messagePayload) throws Exception {
//        log.info("PaymentsService:studyCptListener::Message: {}", messagePayload);
//
//        /* Build the study cpt from kafka message. */
//        Map<String, Object> studyCptMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
//        StudyCpt studyCpt = buildStudyCpt(studyCptMessage);
//
//        /* Save or persist the data into the table. */
//        dataRepository.save(studyCpt);
//        log.info("Order is Saved/Updated for the id: {} ", studyCpt.getId());
//    }
    /**
     * Method to map and save StudyCpt information.
     *
     * @param studyCptMessage
     * @return StudyCpt
     * @throws Exception
     */

    private StudyCpt buildStudyCpt(Map<String, Object> studyCptMessage) throws IOException {
        StudyCpt studyCpt = new StudyCpt();

        long id = new Long((Integer) studyCptMessage.get("id")).longValue();
        long studyId = new Long((Integer) studyCptMessage.get("study_id")).longValue();
//        Double billFee = new Double((Double) studyCptMessage.get("bill_fee")).doubleValue();
        long orderId = new Long((Integer) studyCptMessage.get("order_id")).longValue();

        studyCpt.setId(id);
        studyCpt.setCustomBillFee((boolean) studyCptMessage.get("is_custom_bill_fee"));
        studyCpt.setHasDeleted((boolean) studyCptMessage.get("has_deleted"));
        studyCpt.setCptCodeId((Integer) studyCptMessage.get("cpt_code_id"));
//        studyCpt.setBillFee(BigDecimal.valueOf(units));
//        studyCpt.setUnits((BigDecimal) studyCptMessage.get("units"));
        studyCpt.setStudyId(studyId);
        studyCpt.setAuthorizationInfo((String) studyCptMessage.get("authorization_info"));
        studyCpt.setAuthorizationInfo((String) studyCptMessage.get("cpt_code"));
        studyCpt.setOrderId(BigInteger.valueOf(orderId));
        studyCpt.setLastModified(new Timestamp(System.currentTimeMillis()));
        studyCpt.setLastAction((String) studyCptMessage.get("operationType"));

        /* Populate the study cpt info and study cpt info information. */
        buildStudyCptInfo(studyCpt, studyCptMessage);
        /* Populate the authorization info and authorization info data information. */
        buildAuthorizationInfo(studyCpt, studyCptMessage);

        return studyCpt;
    }

    /**
     * Method to map and save Patient Alt Names information.
     *
     * @param patientAltNamesMessage
     * @return Order
     * @throws Exception
     */
    private PatientAltNames buildPatientAltNames(Map<String, Object> patientAltNamesMessage) {
        PatientAltNames patientAltNames = new PatientAltNames();
        long id = new Long((Integer) patientAltNamesMessage.get("id")).longValue();
        Integer patientId = (Integer) patientAltNamesMessage.get("patient_id");

        patientAltNames.setId(id);
        patientAltNames.setNameType((String) patientAltNamesMessage.get("name_type"));
        patientAltNames.setPatientId(BigInteger.valueOf(patientId));
        patientAltNames.setLastName((String) patientAltNamesMessage.get("last_name"));
        patientAltNames.setFirstName((String) patientAltNamesMessage.get("first_name"));
        patientAltNames.setLastModified(new Timestamp(System.currentTimeMillis()));
        patientAltNames.setLastAction((String) patientAltNamesMessage.get("operationType"));

        return patientAltNames;
    }


    private void buildAuthorizationInfo(StudyCpt studyCpt, Map<String, Object> studyCptMessage) throws IOException {
        String studyInfoMessage = (String) studyCptMessage.get("study_info");
        Map studyInfoData = JsonUtils.deserializeJson(Map.class, studyInfoMessage);

        studyCpt.setStudyCptInfoSecondary(studyInfoData.get("Secondary").toString());
        studyCpt.setStudyCptInfoTertiary(studyInfoData.get("Tertiary").toString());
//        studyCpt.setStudyCptInfoPrimary((Integer) studyInfoData.get("cpt_code_id"));
    }

    private void buildStudyCptInfo(StudyCpt studyCpt, Map<String, Object> studyCptMessage) throws IOException {
        String studyCptInfoMessage = (String) studyCptMessage.get("study_info");
        Map studyInfoData = JsonUtils.deserializeJson(Map.class, studyCptInfoMessage);

        studyCpt.setStudyCptInfoDuration(studyInfoData.get("duration").toString());
        studyCpt.setStudyCptInfoReorder(studyInfoData.get("reOrder").toString());
        studyCpt.setStudyCptInfoCptDescription(studyInfoData.get("cpt_description").toString());

    }
}
