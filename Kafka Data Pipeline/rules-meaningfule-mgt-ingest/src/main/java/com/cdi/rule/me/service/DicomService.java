package com.cdi.rule.me.service;


import com.cdi.domain.model.ApplicationEntity;
import com.cdi.domain.model.FileStore;
import com.cdi.domain.model.RoutingRules;
import com.cdi.domain.repository.DataRepository;
import com.cdi.domain.util.AppUtils;
import com.cdi.domain.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
/**
 * DicomService class used to consume message from kafka topics and ingest data into
 * target tables in MS SQL server.
 *
 * @author Temam G.
 * @CopyRight (C) All rights reserved to CDI Inc. It's Illegal to reproduce this code.
 */
@Service
@Slf4j
public class DicomService {

    @Autowired
    private DataRepository dataRepository;

    /**
     * Method to listen application entities and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
//    @KafkaListener(topics = "${topic.t_application_entities}")
//    public void applicationEntityListener(@Payload String messagePayload) throws Exception {
//        log.info("DicomService:applicationEntitiesListener::Message: {}", messagePayload);
//
//        /* Build the application entities from kafka message. */
//        Map<String, Object> applicationEntitiesMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
//        ApplicationEntity applicationEntity = buildApplicationEntities(applicationEntitiesMessage);
//
//        /* Save or persist the data into the table. */
//        dataRepository.save(applicationEntity);
//        log.info("ApplicationEntities is Saved/Updated for the id: {} ", applicationEntity.getId());
//    }

    /**
     * Method to listen file stores and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
//    @KafkaListener(topics = "${topic.t_file_stores}")
//    public void fileStoreStatusListener(@Payload String messagePayload) throws Exception {
//        log.info("DicomService:fileStoreListener::Message: {}", messagePayload);
//
//        /* Build the file stores from kafka message. */
//        Map<String, Object> fileStoreMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
//        FileStore fileStore = buildFileStore(fileStoreMessage);
//
//        /* Save or persist the data into the table. */
//        dataRepository.save(fileStore);
//        log.info("FileStore is Saved/Updated for the id: {} ", fileStore.getId());
//    }

    /**
     * Method to listen routing rules and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
//    @KafkaListener(topics = "${topic.t_routing_rules}")
//    public void routingRulesListener(@Payload String messagePayload) throws Exception {
//        log.info("DicomService:routingRulesListener::Message: {}", messagePayload);
//
//        /* Build the routing rules from kafka message. */
//        Map<String, Object> routingRulesMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
//        RoutingRules routingRules = buildRoutingRules(routingRulesMessage);
//
//        /* Save or persist the data into the table. */
//        dataRepository.save(routingRules);
//        log.info("RoutingRules is Saved/Updated for the id: {} ", routingRules.getId());
//    }

    /**
     * Method to build application entities
     * @param applicationEntitiesMessage
     * @return applicationEntity
     */
    private ApplicationEntity buildApplicationEntities(Map<String, Object> applicationEntitiesMessage) throws Exception{
//        Timestamp createdDate = AppUtils.convertToTimeStamp((String) applicationEntitiesMessage.get("LastModified"));
        List<String> cipherSuitesData = (List<String>) applicationEntitiesMessage.get("cipher_suites");
        List<String> mwlModalitiesData = (List<String>) applicationEntitiesMessage.get("mwl_modalities");
        List<String> aeTypesData = (List<String>) applicationEntitiesMessage.get("ae_types");
        String aeTypes = AppUtils.convertArrayToValue(aeTypesData);
        String cipherSuites = AppUtils.convertArrayToValue(cipherSuitesData);
        String mwlModalities = AppUtils.convertArrayToValue(mwlModalitiesData);

        ApplicationEntity applicationEntity =  new ApplicationEntity();
        long id = new Long((Integer) applicationEntitiesMessage.get("id")).longValue();

        applicationEntity.setId(id);
        applicationEntity.setHasDeleted((boolean) applicationEntitiesMessage.get("has_deleted"));
        applicationEntity.setAeTypes(aeTypes);
        applicationEntity.setAeType2((String) applicationEntitiesMessage.get("ae_type2"));
        applicationEntity.setActive((boolean) applicationEntitiesMessage.get("is_active"));
        applicationEntity.setCompanyId((Integer) applicationEntitiesMessage.get("company_id"));

        applicationEntity.setAeInfo((String) applicationEntitiesMessage.get("ae_info"));
        applicationEntity.setCipherSuites(cipherSuites);
        applicationEntity.setMwlModalities(mwlModalities);
        applicationEntity.setSrcAeTitle((String) applicationEntitiesMessage.get("src_ae_title"));
        applicationEntity.setSendUniqueImageUid((boolean) applicationEntitiesMessage.get("send_unique_image_uid"));
        applicationEntity.setHasRegistered((boolean) applicationEntitiesMessage.get("has_registered"));
        applicationEntity.setHasInstalled((boolean) applicationEntitiesMessage.get("has_installed"));
        applicationEntity.setFacilityId((Integer) applicationEntitiesMessage.get("facility_id"));
        applicationEntity.setFileStoreId((Integer) applicationEntitiesMessage.get("file_store_id"));
//        applicationEntity.setFacilities(facilities);
        applicationEntity.setHostName((String) applicationEntitiesMessage.get("host_name"));
        applicationEntity.setRequiresSsl((boolean) applicationEntitiesMessage.get("requires_ssl"));
        applicationEntity.setLastAction((String) applicationEntitiesMessage.get("operationType"));
        applicationEntity.setLastModified(new Timestamp(System.currentTimeMillis()));

        /* Populate the Ae Info and Ae info data information. */
        buildApplicationEntitiesAeInfo(applicationEntity, applicationEntitiesMessage);

        return applicationEntity;
    }

    /**
     * Method to build or populate Ae Info data.
     *
     * @param applicationEntity
     * @param applicationEntitiesMessage
     * @throws Exception
     */
    private void buildApplicationEntitiesAeInfo(ApplicationEntity applicationEntity, Map<String, Object> applicationEntitiesMessage) throws IOException {
        String applicationEntityAeInfoDataMessage = (String) applicationEntitiesMessage.get("ae_info");
        Map applicationEntityAeInfoData = JsonUtils.deserializeJson(Map.class, applicationEntityAeInfoDataMessage);

        applicationEntity.setAeInfoAeGroup(applicationEntityAeInfoData.get("ae_group").toString());
        applicationEntity.setAeInfoStationName(applicationEntityAeInfoData.get("station_name").toString());
        applicationEntity.setAeInfoInstitution(applicationEntityAeInfoData.get("institution").toString());
        applicationEntity.setAeInfoPatientIdIssuer(applicationEntityAeInfoData.get("patient_id_issuer").toString());
        applicationEntity.setAeInfoAccNoIssuer(applicationEntityAeInfoData.get("acc_no_issuer").toString());
        applicationEntity.setAeInfoWadourl(applicationEntityAeInfoData.get("WADOURL").toString());
        applicationEntity.setAeInfoTransferSyntaxSend(applicationEntityAeInfoData.get("transfer_syntax_send").toString());
        applicationEntity.setAeInfoDepartment(applicationEntityAeInfoData.get("department").toString());
        applicationEntity.setAeInfoAeDescription(applicationEntityAeInfoData.get("ae_description").toString());
        applicationEntity.setAeInfoTransferSyntaxReceive(applicationEntityAeInfoData.get("transfer_syntax_receive").toString());

    }

    /**
     * Method to build FileStore
     * @param fileStoreMessage
     * @return fileStore
     */
    private FileStore buildFileStore(Map<String, Object> fileStoreMessage) throws Exception {
        long id = new Long((Integer) fileStoreMessage.get("id")).longValue();

        FileStore fileStore = new FileStore();

        fileStore.setId(id);
        fileStore.setHasDeleted((boolean) fileStoreMessage.get("has_deleted"));
        fileStore.setHasRegistered((boolean) fileStoreMessage.get("has_registered"));
        fileStore.setNotes((String) fileStoreMessage.get("notes"));
        fileStore.setFileStoreName((String) fileStoreMessage.get("file_store_name"));
        fileStore.setCompanyId((Integer) fileStoreMessage.get("company_id"));
        fileStore.setServerStatus((String) fileStoreMessage.get("server_status"));
        fileStore.setRootDirectory((String) fileStoreMessage.get("root_directory"));
        fileStore.setLastAction((String) fileStoreMessage.get("operationType"));
        fileStore.setLastModified(new Timestamp(System.currentTimeMillis()));

        return fileStore;
    }

    /**
     * Method to build RoutingRules
     * @param routingRulesMessage
     * @return routingRules
     */
    private RoutingRules buildRoutingRules(Map<String, Object> routingRulesMessage) throws Exception {
//        Timestamp deletedDt = (Timestamp) routingRulesMessage.get("has_deleted");
        long id = new Long((Integer) routingRulesMessage.get("id")).longValue();
        RoutingRules routingRules = new RoutingRules();

        routingRules.setId(id);
        routingRules.setHasDeleted((boolean) routingRulesMessage.get("has_deleted"));
//        routingRules.setActive((boolean) routingRulesMessage.get("isActive"));
        routingRules.setCompanyId((Integer) routingRulesMessage.get("company_id"));
        routingRules.setRuleName((String) routingRulesMessage.get("rule_name"));
//        routingRules.setH17InterfaceId((Integer) routingRulesMessage.get("h17_interface_id"));
        routingRules.setPriority(String.valueOf(routingRulesMessage.get("priority")));
        routingRules.setRuleType((String) routingRulesMessage.get("rule_type"));
        routingRules.setRuleInfo((String) routingRulesMessage.get("rule_info"));
        routingRules.setApplicationEntityId((Integer) routingRulesMessage.get("application_entity_id"));
//        routingRules.setH17MessageId((Integer) routingRulesMessage.get("h17_message_id"));
        routingRules.setApplicationEntityId((Integer) routingRulesMessage.get("application_entity_id"));
        routingRules.setAttempts(String.valueOf(routingRulesMessage.get("attempts")));

//        routingRules.setLastAction((String) routingRulesMessage.get("operationType"));
//        routingRules.setLastModified(new Timestamp(System.currentTimeMillis()));

        /* Populate the Rule Info and Rule info data information. */
        buildRoutingRulesRuleInfo(routingRules, routingRulesMessage);

        return routingRules;
    }

    /**
     * Method to build or populate Rule Info data.
     *
     * @param routingRules
     * @param routingRulesMessage
     * @throws Exception
     */
    private void buildRoutingRulesRuleInfo(RoutingRules routingRules, Map<String, Object> routingRulesMessage) throws IOException {
        String routingRulesRuleInfoDataMessage = (String) routingRulesMessage.get("rule_info");
        Map routingRulesRuleInfoData = JsonUtils.deserializeJson(Map.class, routingRulesRuleInfoDataMessage);

//        routingRules.setRelevantPriors(routingRulesRuleInfoData.get("relevantPriors").toString());
    }
}
