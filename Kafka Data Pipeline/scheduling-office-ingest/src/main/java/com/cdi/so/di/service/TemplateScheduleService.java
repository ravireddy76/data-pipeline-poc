package com.cdi.so.di.service;

import com.cdi.domain.model.ScheduleTemplate;
import com.cdi.domain.model.TranscriptionTemplate;
import com.cdi.domain.model.TranscriptionUserTemplate;
import com.cdi.domain.repository.DataRepository;
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
 * TemplateScheduleService class used to consume message from kafka topics and ingest data into
 * target tables in MS SQL server.
 *
 * @author Ravi Reddy
 * @CopyRight (C) All rights reserved to CDI Inc. It's Illegal to reproduce this code.
 */
@Service
@Slf4j
public class TemplateScheduleService {

    @Autowired
    private AbstractDataTransaction dataTransaction;

    /**
     * Method to listen transcription user templates and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_transcription_user_templates}")
    public void transcriptionUserTemplateListener(@Payload String messagePayload) throws Exception {
        log.info("TemplateScheduleService:transcriptionUserTemplateListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> tUserTemplateMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        TranscriptionUserTemplate transcriptionUserTemplate = buildTranscriptionUserTemplate(tUserTemplateMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(transcriptionUserTemplate);
        log.info("Transcription User Template is Saved/Updated for the id: {} ", transcriptionUserTemplate.getId());
    }

    /**
     * Method to listen transcription templates and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_transcription_templates}")
    public void transcriptionTemplateListener(@Payload String messagePayload) throws Exception {
        log.info("TemplateScheduleService:transcriptionTemplateListener::Message: {}", messagePayload);

        /* Build the transcription template from kafka message. */
        Map<String, Object> transTemplateMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        TranscriptionTemplate transcriptionTemplate = buildTranscriptionTemplate(transTemplateMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(transcriptionTemplate);
        log.info("Transcription Template is Saved/Updated for the id: {} ", transcriptionTemplate.getId());
    }

    /**
     * Method to listen schedule templates and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_schedule_templates}")
    public void scheduleTemplateListener(@Payload String messagePayload) throws Exception {
        log.info("TemplateScheduleService:scheduleTemplateListener::Message: {}", messagePayload);

        /* Build the transcription template from kafka message. */
        Map<String, Object> scheduleTemplateMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        ScheduleTemplate scheduleTemplate = buildScheduleTemplate(scheduleTemplateMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(scheduleTemplate);
        log.info("Schedule Template is Saved/Updated for the id: {} ", scheduleTemplate.getId());
    }


    /**
     * Method to build transcription user template.
     *
     * @param tUserTemplateMessage
     * @return TranscriptionUserTemplate
     */
    private TranscriptionUserTemplate buildTranscriptionUserTemplate(Map<String, Object> tUserTemplateMessage) {
        TranscriptionUserTemplate transUserTemplate = new TranscriptionUserTemplate();
        transUserTemplate.setId((Integer) tUserTemplateMessage.get("id"));
        transUserTemplate.setLastAction((String) tUserTemplateMessage.get("operationType"));
        transUserTemplate.setLastModified(new Timestamp(System.currentTimeMillis()));
        return transUserTemplate;
    }

    /**
     * Method to build transcription template.
     *
     * @param transTemplateMessage
     * @return TranscriptionTemplate
     */
    @SuppressWarnings("unchecked")
    private TranscriptionTemplate buildTranscriptionTemplate(Map<String, Object> transTemplateMessage) {
        List<String> institutionData = (List<String>) transTemplateMessage.get("institutions");
        List<Integer> modalityIdsData = (List<Integer>) transTemplateMessage.get("modalities");
        List<Integer> facilitiesData = (List<Integer>) transTemplateMessage.get("facilities");
        List<String> reportOptionsData = (List<String>) transTemplateMessage.get("report_options");

        /* Convert list of values to comma separated value. */
        String institutions = AppUtils.convertArrayToValue(institutionData);
        String modalities = AppUtils.convertNumbersToValue(modalityIdsData);
        String facilities = AppUtils.convertNumbersToValue(facilitiesData);
        String reportOptions = AppUtils.convertArrayToValue(reportOptionsData);

        TranscriptionTemplate transcriptionTemplate = new TranscriptionTemplate();
        transcriptionTemplate.setId((Integer) transTemplateMessage.get("id"));
        transcriptionTemplate.setHasDeleted((Boolean) transTemplateMessage.get("has_deleted"));
        transcriptionTemplate.setActive((Boolean) transTemplateMessage.get("is_active"));
        transcriptionTemplate.setTextType((String) transTemplateMessage.get("text_type"));
        transcriptionTemplate.setReportHeader((String) transTemplateMessage.get("report_header"));
        transcriptionTemplate.setCompanyId((Integer) transTemplateMessage.get("company_id"));
        transcriptionTemplate.setReportBody((String) transTemplateMessage.get("report_body"));
        transcriptionTemplate.setInstitutions(institutions);
        transcriptionTemplate.setTemplateName((String) transTemplateMessage.get("template_name"));
        transcriptionTemplate.setUserId((Integer) transTemplateMessage.get("user_id"));
        transcriptionTemplate.setLastAction((String) transTemplateMessage.get("operationType"));
        transcriptionTemplate.setPageFooter((String) transTemplateMessage.get("page_footer"));
        transcriptionTemplate.setPageHeader((String) transTemplateMessage.get("page_header"));
        transcriptionTemplate.setModalities(modalities);
        transcriptionTemplate.setFacilities(facilities);
        transcriptionTemplate.setReportOptions(reportOptions);
        transcriptionTemplate.setLastModified(new Timestamp(System.currentTimeMillis()));

        return transcriptionTemplate;
    }


    /**
     * Method to build schedule template.
     *
     * @param scheduleTemplateMessage
     * @return ScheduleTemplate
     */
    @SuppressWarnings("unchecked")
    private ScheduleTemplate buildScheduleTemplate(Map<String, Object> scheduleTemplateMessage) {
        List<Integer> appointmentTypesData = (List<Integer>) scheduleTemplateMessage.get("appointment_types");
        List<Integer> modalityRoomsData = (List<Integer>) scheduleTemplateMessage.get("modality_rooms");
        List<Integer> providersData = (List<Integer>) scheduleTemplateMessage.get("providers");

        /* Convert list of values to comma separated value. */
        String appointmentTypes = AppUtils.convertNumbersToValue(appointmentTypesData);
        String modalityRooms = AppUtils.convertNumbersToValue(modalityRoomsData);
        String providers = AppUtils.convertNumbersToValue(providersData);

        ScheduleTemplate scheduleTemplate = new ScheduleTemplate();
        scheduleTemplate.setId((Integer) scheduleTemplateMessage.get("id"));
        scheduleTemplate.setName((String) scheduleTemplateMessage.get("name"));
        scheduleTemplate.setDescription((String) scheduleTemplateMessage.get("description"));
        scheduleTemplate.setLastAction((String) scheduleTemplateMessage.get("operationType"));
        scheduleTemplate.setActive((Boolean) scheduleTemplateMessage.get("is_active"));
        scheduleTemplate.setAppointmentTypes(appointmentTypes);
        scheduleTemplate.setModalityRooms(modalityRooms);
        scheduleTemplate.setProviders(providers);
        scheduleTemplate.setLastModified(new Timestamp(System.currentTimeMillis()));
        return scheduleTemplate;
    }

}
