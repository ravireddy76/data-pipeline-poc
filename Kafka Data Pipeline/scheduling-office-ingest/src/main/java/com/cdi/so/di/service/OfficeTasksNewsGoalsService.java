package com.cdi.so.di.service;

import com.cdi.domain.model.InsuranceAuthorization;
import com.cdi.domain.model.News;
import com.cdi.domain.model.StudyFlag;
import com.cdi.domain.model.Task;
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
import java.util.Objects;

/**
 * OfficeTasksNewsGoalsService class used to consume message from kafka topics for
 * news,tasks,insurance authorization,study flags, monthly goals to ingest data into
 * target tables in MS SQL server.
 *
 * @author Ravi Reddy
 * @CopyRight (C) All rights reserved to CDI Inc. It's Illegal to reproduce this code.
 */
@Service
@Slf4j
public class OfficeTasksNewsGoalsService {

    @Autowired
    private AbstractDataTransaction dataTransaction;


    /**
     * Method to listen news topic and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_news}") //Working
    public void newsListener(@Payload String messagePayload) throws Exception {
        log.info("OfficeTasksNewsGoalsService:newsListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> newsMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        News news = buildNews(newsMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(news);
        log.info("News is Saved/Updated for the id: {} ", news.getId());
    }


    /**
     * Method to listen news topic and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_tasks}") //Working
    public void tasksListener(@Payload String messagePayload) throws Exception {
        log.info("OfficeTasksNewsGoalsService:tasksListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> tasksMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        Task tasks = buildTask(tasksMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(tasks);
        log.info("Tasks is Saved/Updated for the id: {} ", tasks.getId());
    }


    /**
     * Method to listen news insurance authorization and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_insurance_authorizations}") //Working.
    public void insuranceAuthorizationsListener(@Payload String messagePayload) throws Exception {
        log.info("OfficeTasksNewsGoalsService:insuranceAuthorizationsListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> insuranceAuthorizationsMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        InsuranceAuthorization insuranceAuthorization = buildInsuranceAuthorization(insuranceAuthorizationsMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(insuranceAuthorization);
        log.info("InsuranceAuthorization is Saved/Updated for the id: {} ", insuranceAuthorization.getId());
    }



    /**
     * Method to listen study flags topic and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_study_flags}") //Working
    public void studyFlagsListener(@Payload String messagePayload) throws Exception {
        log.info("OfficeTasksNewsGoalsService:studyFlagsListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> studyFlagsMsg = JsonUtils.deserializeJson(Map.class, messagePayload);
        StudyFlag studyFlags = buildStudyFlags(studyFlagsMsg);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(studyFlags);
        log.info("StudyFlags is Saved/Updated for the id: {} ", studyFlags.getId());
    }


    /**
     * Method to listen monthly goals topic and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
//    @KafkaListener(topics = "${topic.t_monthly_goals}") //TODO this table processing and mapping not required for EXA application
//    public void monthlyGoalsListener(@Payload String messagePayload) throws Exception {
//        log.info("OfficeTasksNewsGoalsService: monthlyGoalsListener::Message: {}", messagePayload);
//
//        /* Translate message payload to map. */
//        Map<String, Object>  monthlyGoalsMsg = JsonUtils.deserializeJson(Map.class, messagePayload);
//        MonthlyGoals monthlyGoals = buildMonthlyGoals(monthlyGoalsMsg);
//
//        /* Save or persist the data into the table. */
//        dataRepository.save(monthlyGoals);
//        log.info("MonthlyGoals is Saved/Updated for the id: {} ", monthlyGoals.getId());
//    }

    /**
     * Method to build news information.
     *
     * @param newsMessage
     * @return News
     */
    private News buildNews(Map<String, Object> newsMessage) {
        News news = new News();
        List<Integer> facilitiesData = (List<Integer>) newsMessage.get("facilities");
        String facilities = AppUtils.convertNumbersToValue(facilitiesData);

        news.setId((Integer) newsMessage.get("id"));
        news.setHasDeleted((Boolean) newsMessage.get("has_deleted"));
        news.setActive((Boolean) newsMessage.get("is_active"));
        news.setCompanyId((Integer) newsMessage.get("company_id"));
        news.setRefPortal((Boolean) newsMessage.get("is_ref_portal"));
        news.setDescription((String) newsMessage.get("description"));
        news.setFacilities(facilities);
        news.setLastAction((String) newsMessage.get("operationType"));
        news.setLastModified(new Timestamp(System.currentTimeMillis()));
        return news;
    }


    /**
     * Method to build task information.
     *
     * @param tasksMessage
     * @return Task
     */
    private Task buildTask(Map<String, Object> tasksMessage) {
        Task task = new Task();
        long id = new Long((Integer) tasksMessage.get("id")).longValue();

        task.setId(id);
        task.setUserId((Integer) tasksMessage.get("user_id"));
        task.setDescription((String) tasksMessage.get("description"));
        task.setTitle((String) tasksMessage.get("title"));
        task.setHasCompleted((Boolean) tasksMessage.get("has_completed"));
        task.setLastAction((String) tasksMessage.get("operationType"));
        task.setLastModified(new Timestamp(System.currentTimeMillis()));
        return task;
    }

    /**
     * Method to build insurance authorization information.
     *
     * @param insAuthorizationsMsg
     * @return InsuranceAuthorization
     */
    private InsuranceAuthorization buildInsuranceAuthorization(Map<String, Object> insAuthorizationsMsg) {
        InsuranceAuthorization insuranceAuthorization = new InsuranceAuthorization();

        List<Integer> insuranceProvidersData = (List<Integer>) insAuthorizationsMsg.get("insurance_providers");
        List<String> cptCodesData = (List<String>) insAuthorizationsMsg.get("cpt_codes");

        /* Convert comma separated values if data is available.*/
        String insuranceProviders = Objects.nonNull(insuranceProvidersData)? AppUtils.convertNumbersToValue(insuranceProvidersData) : "";
        String cptCodes = Objects.nonNull(cptCodesData)? AppUtils.convertArrayToValue(cptCodesData) : "";
        int isActive = ((Boolean) insAuthorizationsMsg.get("is_active")) ? 1 : 0;
        long id = new Long((Integer) insAuthorizationsMsg.get("id")).longValue();

        insuranceAuthorization.setId(id);
        insuranceAuthorization.setIsActive(isActive);
        insuranceAuthorization.setDays((Integer) insAuthorizationsMsg.get("days"));
        insuranceAuthorization.setFacilityId((Integer) insAuthorizationsMsg.get("facility_id"));
        insuranceAuthorization.setApplyAllModalities((Boolean) insAuthorizationsMsg.get("apply_all_modalities"));
        insuranceAuthorization.setApplyAllInsurances((Boolean) insAuthorizationsMsg.get("apply_all_insurances"));
        insuranceAuthorization.setAllowScheduling((Boolean) insAuthorizationsMsg.get("allow_scheduling"));
        insuranceAuthorization.setInsuranceProviders(insuranceProviders); //TODO Need to change column type to String
        insuranceAuthorization.setCptCodes(cptCodes);
        insuranceAuthorization.setLastAction((String) insAuthorizationsMsg.get("operationType"));
        insuranceAuthorization.setLastModified(new Timestamp(System.currentTimeMillis()));
        return  insuranceAuthorization;
    }

    /**
     * Method to build the study flag information.
     *
     * @param studyFlagsMsg
     * @return StudyFlag
     */
    private StudyFlag buildStudyFlags(Map<String, Object> studyFlagsMsg) {
        StudyFlag studyFlag = new StudyFlag();
        long id = new Long((Integer) studyFlagsMsg.get("id")).longValue();

        List<String> institutionsData = (List<String>) studyFlagsMsg.get("institutions");
        List<Integer> modalitiesData = (List<Integer>) studyFlagsMsg.get("modalities");
        List<Integer> facilitiesData = (List<Integer>) studyFlagsMsg.get("facilities");

        /* Convert comma separated values if data is available.*/
        String institutions = Objects.nonNull(institutionsData)? AppUtils.convertArrayToValue(institutionsData) : "";
        String modalities = Objects.nonNull(modalitiesData)? AppUtils.convertNumbersToValue(modalitiesData) : "";
        String facilities = Objects.nonNull(facilitiesData)? AppUtils.convertNumbersToValue(facilitiesData) : "";

        studyFlag.setId(id);
        studyFlag.setHasDeleted((Boolean) studyFlagsMsg.get("has_deleted"));
        studyFlag.setAvailableInPortal((Boolean) studyFlagsMsg.get("available_in_portal"));
        studyFlag.setActive((Boolean) studyFlagsMsg.get("is_active"));
        studyFlag.setCompanyId((Integer) studyFlagsMsg.get("company_id"));
        studyFlag.setDescription((String) studyFlagsMsg.get("description"));
        studyFlag.setColorCode((String) studyFlagsMsg.get("color_code"));
        studyFlag.setInstitutions(institutions);
        studyFlag.setModalities(modalities);
        studyFlag.setFacilities(facilities);
        studyFlag.setLastaction((String) studyFlagsMsg.get("operationType"));
        studyFlag.setLastmodified(new Timestamp(System.currentTimeMillis()));
        return studyFlag;
    }

}
