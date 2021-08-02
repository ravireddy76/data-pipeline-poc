package com.cdi.so.di.service;

import com.cdi.domain.model.*;
import com.cdi.domain.repository.DataRepository;
import com.cdi.domain.util.AppUtils;
import com.cdi.domain.util.JsonUtils;
import com.cdi.so.di.util.AbstractDataTransaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Array;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * ProviderGroupService class used to consume message from kafka topics for
 * providers,provider contacts,provider groups,provider alt names, provider schedule templates
 * to ingest data into target tables in MS SQL server.
 *
 * @author Temam Geletu
 * @CopyRight (C) All rights reserved to CDI Inc. It's Illegal to reproduce this code.
 */
@Service
@Slf4j
public class ProviderGroupService {

    @Autowired
    private AbstractDataTransaction dataTransaction;

    /**
     * Method to listen provider topic and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_providers}") // Cool
    public void providersListener(@Payload String messagePayload) throws Exception {
        log.info("ProviderGroupService:providersListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> providersMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        Provider provider = buildProviders(providersMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(provider);
        log.info("Provider is Saved/Updated for the id: {} ", provider.getId());
    }

    /**
     * Method to listen provider contacts topic and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_provider_contacts}") // Works fine
    public void providerContactsListener(@Payload String messagePayload) throws Exception {
        log.info("ProviderGroupService:providerContactsListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> providerContactsMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        ProviderContact providerContact = buildProviderContacts(providerContactsMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(providerContact);
        log.info("Provider is Saved/Updated for the id: {} ", providerContact.getId());
    }

    /**
     * Method to listen provider groups topic and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_provider_groups}") // Cool
    public void providerGroupsListener(@Payload String messagePayload) throws Exception {
        log.info("ProviderGroupService:providerGroupsListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> providerGroupsMsg = JsonUtils.deserializeJson(Map.class, messagePayload);
        ProviderGroup providerGroup = buildProviderGroup(providerGroupsMsg);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(providerGroup);
        log.info("ProviderGroup is Saved/Updated for the id: {} ", providerGroup.getId());
    }

    /**
     * Method to listen provider alt names topic and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_provider_alt_names}") // Cool
    public void providerAltNamesListener(@Payload String messagePayload) throws Exception {
        log.info("ProviderGroupService:providerAltNamesListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> providerAltNamesMsg = JsonUtils.deserializeJson(Map.class, messagePayload);
        ProviderAltName providerAltName = buildProviderAltName(providerAltNamesMsg);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(providerAltName);
        log.info("ProviderAltName is Saved/Updated for the id: {} ", providerAltName.getId());
    }

    /**
     * Method to listen provider schedule templates topic and save the information.
     *
//     * @param messagePayload
     * @throws Exception
     */
//    @KafkaListener(topics = "${topic.t_provider_schedule_templates}")
//    public void providerScheduleTemplatesListener(@Payload String messagePayload) throws Exception {
//        log.info("ProviderGroupService:providerScheduleTemplatesListener::Message: {}", messagePayload);
//
//        /* Translate message payload to map. */
//        Map<String, Object> providerScheduleTemplateMsg = JsonUtils.deserializeJson(Map.class, messagePayload);
//        ProviderScheduleTemplate providerScheduleTemplate = buildProviderScheduleTemplate(providerScheduleTemplateMsg);
//
//        /* Save or persist the data into the table. */
//        dataRepository.save(providerScheduleTemplate);
//        log.info("ProviderScheduleTemplate is Saved/Updated for the id: {} ", providerScheduleTemplate.getId());
//    }

    /**
     * Method to listen marketing rep tasks topic and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_marketing_rep_tasks}")
    public void marketingRepTasksListener(@Payload String messagePayload) throws Exception {
        log.info("ProviderGroupService:marketingRepTasksListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> marketingRepTasksMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        MarketingRepTask marketingRepTask = buildmarketingRepTasks(marketingRepTasksMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(marketingRepTask);
        log.info("Marketing Rep Task is Saved/Updated for the id: {} ", marketingRepTask.getId());
    }

    /**
     * Method to listen provider_contact_notifications topic and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_provider_contact_notifications}") // Works fine
    public void providerContactNotificationsListener(@Payload String messagePayload) throws Exception {
        log.info("ProviderGroupService:providerContactNotificationsListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> providerContactNotificationsMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        ProviderContactNotification providerContactNotification = buildProviderContactNotification(providerContactNotificationsMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(providerContactNotification);
        log.info("ProviderContactNotification is Saved/Updated for the id: {} ", providerContactNotification.getId());
    }

    /**
     * Method to listen Provider Schedule Types topic and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_provider_schedule_types}") // Works fine
    public void providerScheduleTypesListener(@Payload String messagePayload) throws Exception {
        log.info("ProviderGroupService:providerScheduleTypesListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> providerScheduleTypesMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        ProviderScheduleType providerScheduleType = buildProviderScheduleType(providerScheduleTypesMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(providerScheduleType);
        log.info("ProviderScheduleType is Saved/Updated for the id: {} ", providerScheduleType.getId());
    }

    /**
     * Method to build provider schedule template information.
     *
     * @param providerContactsMessage
     * @return ProviderContact
     */
    private ProviderContact buildProviderContacts(Map<String, Object> providerContactsMessage) throws IOException {
        ProviderContact providerContact = new ProviderContact();
        long id = new Long((Integer) providerContactsMessage.get("id")).longValue();

        providerContact.setId(id);
        providerContact.setHasDeleted((boolean) providerContactsMessage.get("has_deleted"));
        providerContact.setProviderContactCode((String) providerContactsMessage.get("provider_contact_code"));
        providerContact.setActive((boolean) providerContactsMessage.get("is_active"));
        providerContact.setPrimary((boolean) providerContactsMessage.get("is_primary"));
        providerContact.setProviderId((Integer) providerContactsMessage.get("provider_id"));
        providerContact.setContactInfo((String) providerContactsMessage.get("contact_info"));
        providerContact.setCcNotifications((boolean) providerContactsMessage.get("cc_notifications"));
        providerContact.setLastmodified(new Timestamp(System.currentTimeMillis()));
//        providerContact.setLastAction((String) providerContactsMessage.get("operationType"));

        /* Populate the Contact Info and contact info data information. */
        buildProviderContactInfo(providerContact, providerContactsMessage);

        return providerContact;
    }

    /**
     * Method to build provider schedule template information.
     *
     * @param providerScheduleTemplateMsg
     * @return ProviderScheduleTemplate
     */
    private ProviderScheduleTemplate buildProviderScheduleTemplate(Map<String, Object> providerScheduleTemplateMsg) {
        ProviderScheduleTemplate providerScheduleTemplate = new ProviderScheduleTemplate();

        providerScheduleTemplate.setId((Integer) providerScheduleTemplateMsg.get("id"));
        providerScheduleTemplate.setLastaction((String) providerScheduleTemplateMsg.get("operationType"));
        providerScheduleTemplate.setLastmodified(new Timestamp(System.currentTimeMillis()));
//        providerScheduleTemplate.setLastAction((String) providerScheduleTemplateMsg.get("operationType"));


        return providerScheduleTemplate;
    }

    /**
     * Method to build provider alt name.
     *
     * @param providerAltNamesMsg
     * @return ProviderAltName
     */
    private ProviderAltName buildProviderAltName(Map<String, Object> providerAltNamesMsg) {
        ProviderAltName providerAltName = new ProviderAltName();
        long id = new Long((Integer) providerAltNamesMsg.get("id")).longValue();

        providerAltName.setId(id);
        providerAltName.setHasDeleted((boolean) providerAltNamesMsg.get("has_deleted"));
        providerAltName.setDicomName((String) providerAltNamesMsg.get("dicom_name"));
        providerAltName.setLastName((String) providerAltNamesMsg.get("last_name"));
        providerAltName.setMiddleInitial((String) providerAltNamesMsg.get("middle_initial"));
        providerAltName.setProviderId((Integer) providerAltNamesMsg.get("provider_id"));
        providerAltName.setSuffix((String) providerAltNamesMsg.get("suffix"));
        providerAltName.setFirstName((String) providerAltNamesMsg.get("first_name"));
//        providerAltName.setLastAction((String) providerAltNamesMsg.get("operationType"));
//        providerAltName.setLastModified(new Timestamp(System.currentTimeMillis()));

        return providerAltName;
    }

    /**
     * Method to build provider group information.
     *
     * @param providerGroupsMsg
     * @return ProviderGroup
     */
    private ProviderGroup buildProviderGroup(Map<String, Object> providerGroupsMsg) throws IOException{
        ProviderGroup providerGroup = new ProviderGroup();
        long id = new Long((Integer) providerGroupsMsg.get("id")).longValue();

        providerGroup.setId(id);
        providerGroup.setHasDeleted((boolean) providerGroupsMsg.get("has_deleted"));
        providerGroup.setGroupInfo((String) providerGroupsMsg.get("group_info"));
        providerGroup.setActive((boolean) providerGroupsMsg.get("is_active"));
        providerGroup.setCompanyId((Integer) providerGroupsMsg.get("company_id"));
        providerGroup.setGroupCode((String) providerGroupsMsg.get("group_code"));
        providerGroup.setGroupName((String) providerGroupsMsg.get("group_name"));
        providerGroup.setGroupType((String) providerGroupsMsg.get("group_type"));
//        providerGroup.setLastAction((String) providerGroupsMsg.get("operationType"));
//        providerGroup.setLastModified(new Timestamp(System.currentTimeMillis()));

        /* Populate the Provider Info and provider info data information. */
        buildProviderGroupInfo(providerGroup, providerGroupsMsg);

        return providerGroup;
    }

    /**
     * Method to build provider information.
     *
     * @param providerMessage
     * @return Provider
     */
    private Provider buildProviders(Map<String, Object> providerMessage) throws IOException {

        List<Integer> facilitiesData = (List<Integer>) providerMessage.get("facilities");
        List<Integer> technologistModalitiesData = (List<Integer>) providerMessage.get("technologist_modalities");
        List<String> specialitiesData = (List<String>) providerMessage.get("specialities");
        String facilities = AppUtils.convertNumbersToValue(facilitiesData);
        String technologistModalities = AppUtils.convertNumbersToValue(technologistModalitiesData);
        String specialities = AppUtils.convertArrayToValue(specialitiesData);
        long id = new Long((Integer) providerMessage.get("id")).longValue();

        Provider provider = new Provider();

        provider.setId(id);

        provider.setProviderType((String) providerMessage.get("provider_type"));
        provider.setActive((boolean) providerMessage.get("is_active"));
        provider.setCompanyId((Integer) providerMessage.get("company_id"));
        provider.setMarketingRep((String) providerMessage.get("marketing_rep"));
        provider.setTechnologistModalities(technologistModalities);
        provider.setLastName((String) providerMessage.get("last_name"));
        provider.setMiddleInitial((String) providerMessage.get("middle_initial"));
        provider.setSuffix((String) providerMessage.get("suffix"));
        provider.setSysProvider((boolean) providerMessage.get("sys_provider"));
        provider.setFullName((String) providerMessage.get("full_name"));
        provider.setDicomName((String) providerMessage.get("dicom_name"));
        provider.setMaxTat((Short) providerMessage.get("max_tat"));
        provider.setProviderCode((String) providerMessage.get("provider_code"));
        provider.setFacilities(facilities);
        provider.setFirstName((String) providerMessage.get("first_name"));
        provider.setSpecialities(specialities);
        provider.setProviderInfo((String) providerMessage.get("provider_info"));
//        provider.setLastAction((String) providerMessage.get("operationType"));
//        provider.setLastModified(new Timestamp(System.currentTimeMillis()));

        /* Populate the Provider Info and provider info data information. */
        buildProviderInfo(provider, providerMessage);
        return provider;
    }

     /**
     * Method to build Marketing Rep Tasks information.
     *
     * @param marketingRepTasksMessage
     * @return MarketingRepTask
     */
    private MarketingRepTask buildmarketingRepTasks(Map<String, Object> marketingRepTasksMessage) throws Exception {
        String createdDt = ((String) marketingRepTasksMessage.get("created_dt"));
        Long dueDate = ((Long) marketingRepTasksMessage.get("due_date"));

        OffsetDateTime created = AppUtils.convertToOffSetDateTime(createdDt);
//        OffsetDateTime due = AppUtils.convertToOffsetTimeStamp(String.valueOf(dueDate));

        long id = new Long((Integer) marketingRepTasksMessage.get("id")).longValue();
        MarketingRepTask marketingRepTask = new MarketingRepTask();

        marketingRepTask.setId(id);
        marketingRepTask.setHasDeleted((boolean) marketingRepTasksMessage.get("has_deleted"));
        marketingRepTask.setProviderGroupId((Integer) marketingRepTasksMessage.get("provider_group_id"));
        marketingRepTask.setNotes((String) marketingRepTasksMessage.get("notes"));
        marketingRepTask.setCreatedDt(created);
        marketingRepTask.setTaskFlag((String) marketingRepTasksMessage.get("task_flag"));
        marketingRepTask.setSubject((String) marketingRepTasksMessage.get("subject"));
//        marketingRepTask.setDueDate(due);
        marketingRepTask.setTaskInfo((String) marketingRepTasksMessage.get("task_info"));
        marketingRepTask.setHasCompleted((boolean) marketingRepTasksMessage.get("has_completed"));
        marketingRepTask.setProviderFlag((String) marketingRepTasksMessage.get("provider_flag"));
        marketingRepTask.setTaskType((String) marketingRepTasksMessage.get("task_type"));
        marketingRepTask.setLastAction((String) marketingRepTasksMessage.get("operationType"));
        marketingRepTask.setLastModified(new Timestamp(System.currentTimeMillis()));

        return marketingRepTask;
    }

    /**
     * Method to build Provider Contact Notification information.
     *
     * @param providerContactNotificationsMessage
     * @return ProviderContactNotification
     */
    private ProviderContactNotification buildProviderContactNotification(Map<String, Object> providerContactNotificationsMessage) {
        ProviderContactNotification providerContactNotification = new ProviderContactNotification();
        long id = new Long((Integer) providerContactNotificationsMessage.get("id")).longValue();

        providerContactNotification.setId(id);
        providerContactNotification.setProviderContactId((Integer) providerContactNotificationsMessage.get("provider_contact_id"));
        providerContactNotification.setDestination((String) providerContactNotificationsMessage.get("destination"));
        providerContactNotification.setType((String) providerContactNotificationsMessage.get("type"));
//        providerContactNotification.setLastAction((String) providerContactNotificationsMessage.get("operationType"));
//        providerContactNotification.setLastModified(new Timestamp(System.currentTimeMillis()));

        return providerContactNotification;
    }

    /**
     * Method to build Provider Schedule Types information.
     *
     * @param providerScheduleTypesMessage
     * @return ProviderScheduleType
     */
    private ProviderScheduleType buildProviderScheduleType(Map<String, Object> providerScheduleTypesMessage) {
        ProviderScheduleType providerScheduleType = new ProviderScheduleType();

//        providerScheduleType.setLastAction((String) providerScheduleTypesMessage.get("operationType"));
//        providerScheduleType.setLastModified(new Timestamp(System.currentTimeMillis()));

        return providerScheduleType;
    }

    /**
     * Method to build or populate provider data.
     *
     * @param provider
     * @param providerMessage
     * @throws Exception
     */
    private void buildProviderInfo(Provider provider, Map<String, Object> providerMessage) throws IOException {
        String providerInfoDataMsg = (String) providerMessage.get("provider_info");
        Map providerInfoData = JsonUtils.deserializeJson(Map.class, providerInfoDataMsg);

        provider.setProviderInfoMedicaidproviderno(providerInfoData.get("MedicaidProviderNo").toString());
        provider.setProviderInfoFederaltaxid(providerInfoData.get("FederalTAXID").toString());
        provider.setProviderInfoNpi(providerInfoData.get("NPI").toString());
        provider.setProviderInfoDegree(providerInfoData.get("degree").toString());
        provider.setProviderInfoSsncode(providerInfoData.get("SSNCode").toString());
        provider.setProviderInfoEin(providerInfoData.get("EIN").toString());
        provider.setProviderInfoMedicareproviderno(providerInfoData.get("MedicareProviderNo").toString());
        provider.setProviderInfoSsn(providerInfoData.get("SSN").toString());
        provider.setProviderInfoLicenseno(providerInfoData.get("LicenseNo").toString());
        provider.setProviderInfoProvideragreementcode(providerInfoData.get("ProviderAgreementCode").toString());
        provider.setProviderInfoEtin(providerInfoData.get("ETIN").toString());
        provider.setProviderInfoMedicareupin(providerInfoData.get("MedicareUPIN").toString());
        provider.setProviderInfoEincode(providerInfoData.get("EINCode").toString());
        provider.setProviderInfoSignprint(providerInfoData.get("signPrint").toString());
        provider.setProviderInfoDrofficename(providerInfoData.get("DROfficeName").toString());
        provider.setProviderInfoTxc(providerInfoData.get("TXC").toString());
    }

    /**
     * Method to build or populate provider data.
     *
     * @param providerGroup
     * @param providerGroupsMsg
     * @throws Exception
     */
    private void buildProviderGroupInfo(ProviderGroup providerGroup, Map<String, Object> providerGroupsMsg) throws IOException {
        String providerInfoDataMsg = (String) providerGroupsMsg.get("provider_info");
        Map providerInfoData = JsonUtils.deserializeJson(Map.class, providerInfoDataMsg);

        providerGroup.setGroupInfoMedicaidProviderNumber(providerInfoData.get("MedicaidProviderNo").toString());
        providerGroup.setGroupInfoFederalTaxId(providerInfoData.get("FederalTAXID").toString());
        providerGroup.setGroupInfoNpiNo(providerInfoData.get("NPI").toString());
        providerGroup.setGroupInfoEin(providerInfoData.get("EIN").toString());
        providerGroup.setGroupInfoMedicareProviderNumber(providerInfoData.get("MedicareProviderNo").toString());
        providerGroup.setGroupInfoSsn(providerInfoData.get("SSN").toString());
        providerGroup.setGroupInfoEtin(providerInfoData.get("ETIN").toString());
        providerGroup.setGroupInfoMadicareupin(providerInfoData.get("MedicareUPIN").toString());

    }

    private void buildProviderContactInfo(ProviderContact providerContact, Map<String, Object> providerContactsMessage) throws IOException {
        String providerContactInfoDataMsg = (String) providerContactsMessage.get("contact_info");
        Map providerContactInfoData = JsonUtils.deserializeJson(Map.class, providerContactInfoDataMsg);

        providerContact.setContactInfoZip(providerContactInfoData.get("ZIP").toString());
        providerContact.setContactInfoMobno(providerContactInfoData.get("MOBNO").toString());
        providerContact.setContactInfoStateName(providerContactInfoData.get("STATE_NAME").toString());
        providerContact.setContactInfoDeliveryFilm(providerContactInfoData.get("delivery_film").toString());
        providerContact.setContactInfoFaxno(providerContactInfoData.get("FAXNO").toString());
        providerContact.setContactInfoState(providerContactInfoData.get("STATE").toString());
        providerContact.setContactInfoEmail(providerContactInfoData.get("EMAIL").toString());
        providerContact.setContactInfoDeliveryCd(providerContactInfoData.get("delivery_cd").toString());
        providerContact.setContactInfoAddr2(providerContactInfoData.get("ADDR2").toString());
        providerContact.setContactInfoMeprinter(providerContactInfoData.get("mePrinter").toString());
        providerContact.setContactInfoAddr1(providerContactInfoData.get("ADDR1").toString());
        providerContact.setContactInfoCountry(providerContactInfoData.get("COUNTRY").toString());
        providerContact.setContactInfoZipplus(providerContactInfoData.get("ZIPPLUS").toString());
        providerContact.setContactInfoFaxMe(providerContactInfoData.get("Fax_me").toString());
        providerContact.setContactInfoReportPassword(providerContactInfoData.get("report_password").toString());
        providerContact.setContactInfoPhno(providerContactInfoData.get("PHNO").toString());
        providerContact.setContactInfoOfphno(providerContactInfoData.get("OFPHNO").toString());
        providerContact.setContactInfoPagrno(providerContactInfoData.get("PAGRNO").toString());
        providerContact.setContactInfoName(providerContactInfoData.get("NAME").toString());
        providerContact.setContactInfoCity(providerContactInfoData.get("CITY").toString());
        providerContact.setContactInfoDeliveryPaper(providerContactInfoData.get("delivery_paper").toString());
        providerContact.setContactInfoProvideralerts(providerContactInfoData.get("providerAlerts").toString());
        providerContact.setContactInfoOffaxno(providerContactInfoData.get("OFFAXNO").toString());
    }

}
