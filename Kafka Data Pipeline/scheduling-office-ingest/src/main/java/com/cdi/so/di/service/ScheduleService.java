package com.cdi.so.di.service;

import com.cdi.domain.model.*;
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
public class ScheduleService {

    @Autowired
    private AbstractDataTransaction dataTransaction;

    /**
     * Method to listen schedule block and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_schedule_blocks}")
    public void scheduleBlocksListener(@Payload String messagePayload) throws Exception {
        log.info("ScheduleService:scheduleBlocksListener::Message: {}", messagePayload);

        /* Build the transcription template from kafka message. */
        Map<String, Object> scheduleBlockMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        ScheduleBlock scheduleBlock = buildScheduleBlock(scheduleBlockMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(scheduleBlock);
        log.info("ScheduleBlock Template is Saved/Updated for the id: {} ", scheduleBlock.getId());
    }


    /**
     * Method to listen schedule filters and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_schedule_filters}") //Working
    public void scheduleFiltersListener(@Payload String messagePayload) throws Exception {
        log.info("ScheduleService:scheduleFiltersListener::Message: {}", messagePayload);

        /* Build the transcription template from kafka message. */
        Map<String, Object> scheduleFilterMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        ScheduleFilter scheduleFilter = buildScheduleFilter(scheduleFilterMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(scheduleFilter);
        log.info("ScheduleFilters is Saved/Updated for the id: {} ", scheduleFilter.getId());
    }

    /**
     * Method to listen study status and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_study_status}") //Working
    public void studyStatusListener(@Payload String messagePayload) throws Exception {
        log.info("ScheduleService:studyStatusListener::Message: {}", messagePayload);

        /* Build the transcription template from kafka message. */
        Map<String, Object> studyStatusMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        StudyStatus studyStatus = buildStudyStatus(studyStatusMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(studyStatus);
        log.info("StudyStatus is Saved/Updated for the id: {} ", studyStatus.getId());
    }


    /**
     * Method to build schedule filter information.
     *
     * @param scheduleFilterMessage
     * @return ScheduleFilter
     */
    private ScheduleFilter buildScheduleFilter(Map<String, Object> scheduleFilterMessage) {
        ScheduleFilter scheduleFilter = new ScheduleFilter();
        List<Integer> modalityRoomsData = (List<Integer>) scheduleFilterMessage.get("modality_rooms");
        String modalityRooms = AppUtils.convertNumbersToValue(modalityRoomsData);

        scheduleFilter.setId((Integer) scheduleFilterMessage.get("id"));
        scheduleFilter.setLastAction((String) scheduleFilterMessage.get("operationType"));
        scheduleFilter.setFilterName((String) scheduleFilterMessage.get("filter_name"));
        scheduleFilter.setCompanyId((Integer) scheduleFilterMessage.get("company_id"));
        scheduleFilter.setNoOfDays((Integer) scheduleFilterMessage.get("no_of_days"));
        scheduleFilter.setModalityDisplayWidth((Integer) scheduleFilterMessage.get("modality_display_width"));
        scheduleFilter.setLastModified(new Timestamp(System.currentTimeMillis()));
        scheduleFilter.setModalityRooms(modalityRooms);
        return scheduleFilter;
    }

    /**
     * Method to build study status information.
     *
     * @param studyStatusMessage
     * @return StudyStatus
     */
    private StudyStatus buildStudyStatus(Map<String, Object> studyStatusMessage) {
        StudyStatus studyStatus = new StudyStatus();

        studyStatus.setId((Integer) studyStatusMessage.get("id"));
        studyStatus.setLastAction((String) studyStatusMessage.get("operationType"));
        studyStatus.setLastModified(new Timestamp(System.currentTimeMillis()));
        return studyStatus;
    }

    /**
     * Method to build schedule block information.
     *
     * @param scheduleBlockMessage
     * @return ScheduleBlock
     */
    private ScheduleBlock buildScheduleBlock(Map<String, Object> scheduleBlockMessage) {
        ScheduleBlock scheduleBlock = new ScheduleBlock();

        scheduleBlock.setId((Integer) scheduleBlockMessage.get("id"));
        scheduleBlock.setLastAction((String) scheduleBlockMessage.get("operationType"));
        scheduleBlock.setLastModified(new Timestamp(System.currentTimeMillis()));
        return scheduleBlock;
    }

}
