package com.cdi.so.di.service;

import com.cdi.domain.model.AppointmentType;
import com.cdi.domain.model.BodyPart;
import com.cdi.domain.model.IcdCode;
import com.cdi.domain.util.AppUtils;
import com.cdi.domain.util.JsonUtils;
import com.cdi.so.di.util.AbstractDataTransaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * CodesService class used to consume message from kafka topics and ingest data into
 * target tables in MS SQL server.
 *
 * @author Ravi Reddy
 * @CopyRight (C) All rights reserved to CDI Inc. It's Illegal to reproduce this code.
 */
@Service
@Slf4j
public class CodesService {

    @Autowired
    private AbstractDataTransaction dataTransaction;


    /**
     * Method to listen body part and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_body_parts}")  //Working
    public void bodyPartsListener(@Payload String messagePayload) throws Exception {
        log.info("CodesService:bodyPartsListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> bodyPartsMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        BodyPart bodyPart = buildBodyPart(bodyPartsMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(bodyPart);
        log.info("BodyPart is Saved/Updated for cpt code id: {} ", bodyPart.getId());
    }


    /**
     * Method to listen icd code and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_icd_codes}") //Working
    public void diagnosticCodesListener(@Payload String messagePayload) throws Exception {
        log.info("CodesService:diagnosticCodesListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> diagnosticCodesMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        IcdCode icdCode = buildIcdCode(diagnosticCodesMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(icdCode);
        log.info("IcdCodes is Saved/Updated for cpt code id: {} ", icdCode.getId());
    }


    /**
     * Method to listen appointment types and save information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_appointment_types}") //Working
    public void appointmentTypesListener(@Payload String messagePayload) throws Exception {
        log.info("CodesService:appointmentTypesListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> appointmentTypesMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        AppointmentType appointmentType = buildAppointmentType(appointmentTypesMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(appointmentType);
        log.info("IcdCodes is Saved/Updated for cpt code id: {} ", appointmentType.getId());
    }


    /**
     * Method to build body part information.
     *
     * @param bodyPartsMessage
     * @return BodyPart
     */
    private BodyPart buildBodyPart(Map<String, Object> bodyPartsMessage) {
        /* Map and build the body part entity to save data into the table. */
        List<String> altNamesData = (List<String>) bodyPartsMessage.get("alt_names");
        String altNames = String.join(",", altNamesData);

        BodyPart bodyPart = new BodyPart();
        bodyPart.setId((Integer) bodyPartsMessage.get("id"));
        bodyPart.setCompanyId((Integer) bodyPartsMessage.get("company_id"));
        bodyPart.setHasDeleted((Boolean) bodyPartsMessage.get("has_deleted"));
        bodyPart.setActive((Boolean) bodyPartsMessage.get("is_active"));
        bodyPart.setName((String) bodyPartsMessage.get("name"));
        bodyPart.setAltNames(altNames);
        bodyPart.setLastAction((String) bodyPartsMessage.get("operationType"));
        bodyPart.setLastModified(new Timestamp(System.currentTimeMillis()));
        return bodyPart;
    }


    /**
     * Method to build icd code information.
     *
     * @param diagnosticCodesMessage
     * @return IcdCode
     * @throws Exception
     */
    private IcdCode buildIcdCode(Map<String, Object> diagnosticCodesMessage) throws Exception {
        Timestamp createdDate = AppUtils.convertToTimeStamp((String) diagnosticCodesMessage.get("created_dt"));

        /* Map and build the icd code entity. */
        IcdCode icdCode = new IcdCode();
        icdCode.setId((Integer) diagnosticCodesMessage.get("id"));
        icdCode.setCompanyId((Integer) diagnosticCodesMessage.get("company_id"));
        icdCode.setCode((String) diagnosticCodesMessage.get("code"));
        icdCode.setHasDeleted((Boolean) diagnosticCodesMessage.get("has_deleted"));
        icdCode.setActive((Boolean) diagnosticCodesMessage.get("is_active"));
        icdCode.setDescription((String) diagnosticCodesMessage.get("description"));
        icdCode.setLastAction((String) diagnosticCodesMessage.get("operationType"));
        icdCode.setCodeType((String) diagnosticCodesMessage.get("code_type"));
        icdCode.setCreatedDt(createdDate);
        icdCode.setLastModified(new Timestamp(System.currentTimeMillis()));
        return icdCode;
    }


    /**
     * Method to build appointment type.
     *
     * @return AppointmentType
     * @throws Exception
     */
    private AppointmentType buildAppointmentType(Map<String, Object> appointmentTypesMessage) throws Exception {
        List<Integer> modalityIdsData = (List<Integer>) appointmentTypesMessage.get("modality_ids");
        String modalityIds = AppUtils.convertNumbersToValue(modalityIdsData);

        /* Map and build the icd code entity. */
        AppointmentType appointmentType = new AppointmentType();
        appointmentType.setId((Integer) appointmentTypesMessage.get("id"));
        appointmentType.setActive((Boolean) appointmentTypesMessage.get("is_active"));
        appointmentType.setCode((String) appointmentTypesMessage.get("code"));
        appointmentType.setKeywords((String) appointmentTypesMessage.get("keywords"));
        appointmentType.setName((String) appointmentTypesMessage.get("name"));
        appointmentType.setExamCount((Integer) appointmentTypesMessage.get("exam_count"));
        appointmentType.setDescription((String) appointmentTypesMessage.get("description"));
        appointmentType.setRefCode((String) appointmentTypesMessage.get("ref_code"));
        appointmentType.setRefCode((String) appointmentTypesMessage.get("ref_code"));
        appointmentType.setDuration((Integer) appointmentTypesMessage.get("duration"));
        appointmentType.setGroupAppt((Boolean) appointmentTypesMessage.get("is_group_appt"));
        appointmentType.setExamPrepInstructions((String) appointmentTypesMessage.get("exam_prep_instructions"));
        appointmentType.setModalityIds(modalityIds);
        appointmentType.setLastaction((String) appointmentTypesMessage.get("operationType"));
        appointmentType.setLastmodified(new Timestamp(System.currentTimeMillis()));
        return appointmentType;
    }

}
