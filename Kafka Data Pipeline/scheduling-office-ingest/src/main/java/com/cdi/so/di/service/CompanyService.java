package com.cdi.so.di.service;

import com.cdi.domain.model.Company;
import com.cdi.domain.model.CriticalFinding;
import com.cdi.domain.util.AppUtils;
import com.cdi.domain.util.JsonUtils;

import com.cdi.domain.model.Alerts;
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
 * CompanyFacilityService class used to consume message from kafka topics for company, alerts, critical findings
 * and ingest data into target tables in MS SQL server.
 *
 * @author Ravi Reddy
 * @CopyRight (C) All rights reserved to CDI Inc. It's Illegal to reproduce this code.
 */
@Service
@Slf4j
public class CompanyService {

    @Autowired
    private AbstractDataTransaction dataTransaction;

    /**
     * Method to listen companies topic and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_companies}") //Working
    public void companiesListener(@Payload String messagePayload) throws Exception {
        log.info("CompanyService:companiesListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> companyMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        Company company = buildCompany(companyMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(company);
        log.info("Company is Saved/Updated for the id: {} ", company.getId());
    }


    /**
     * Method to listen alerts topic and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_alerts}") // working
    public void alertsListener(@Payload String messagePayload) throws Exception {
        log.info("CompanyService:alertsListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> alertMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        Alerts alerts = buildAlerts(alertMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(alerts);
        log.info("Alerts is Saved/Updated for the id: {} ", alerts.getId());
    }

    /**
     * Method to listen critical findings topic and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
//    @KafkaListener(topics = "${topic.t_critical_findings}") //TODO Need to talk to business how to see in EXA application.
//    public void criticalFindingsListener(@Payload String messagePayload) throws Exception {
//        log.info("CompanyService:criticalFindingsListener::Message: {}", messagePayload);
//
//        /* Translate message payload to map. */
//        Map<String, Object> criticalFindingsMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
//        CriticalFinding criticalFindings = buildCriticalFindingsMessage(criticalFindingsMessage);
//
//        /* Save or persist the data into the table. */
//        dataRepository.save(criticalFindings);
//        log.info("CriticalFindings is Saved/Updated for the id: {} ", criticalFindings.getId());
//    }

    /**
     * Method to build company information.
     *
     * @param companyMessage
     * @return Company
     */
    @SuppressWarnings("unchecked")
    private Company buildCompany(Map<String, Object> companyMessage) {
        Company company = new Company();

        List<String> appStatesData = (List<String>) companyMessage.get("app_states");
        List<String> appCancelReasonsData = (List<String>)companyMessage.get("app_cancel_reasons");
        String appStates = AppUtils.convertArrayToValue(appStatesData);
        String appCancelReasons = AppUtils.convertArrayToValue(appCancelReasonsData);

        company.setMrnInfo((String) companyMessage.get("mrn_info"));
        company.setId((Integer) companyMessage.get("id"));
        company.setDocumentReviewConfig((String) companyMessage.get("document_review_config"));
        company.setAppStates(appStates); //TODO Need to increase column size (nvarchar(MAX))
        company.setEnableRcopia((Boolean) companyMessage.get("enable_rcopia"));
        company.setEnablePaymentGateway((Boolean) companyMessage.get("enable_payment_gateway"));
        company.setCompanyInfo((String) companyMessage.get("company_info"));
        company.setTimeZone((String) companyMessage.get("time_zone"));
        company.setRcopiaInfo((String) companyMessage.get("rcopia_info"));
        company.setEmailConfig((String) companyMessage.get("email_config"));
        company.setScanDocumentTypes((String) companyMessage.get("scan_document_types"));
        company.setEnableLdap((Boolean) companyMessage.get("enable_ldap"));
        company.setEnableFlagRoutingTrigger((Boolean) companyMessage.get("enable_flag_routing_trigger"));
        company.setAppCancelReasons(appCancelReasons); //TODO Need to increase column size (nvarchar(MAX))
        company.setBillingInfo((String) companyMessage.get("billing_info"));
        company.setLdapConfig((String) companyMessage.get("ldap_config"));
        company.setPeerReviewConfig((String) companyMessage.get("peer_review_config"));
        company.setCompanyName((String) companyMessage.get("company_name"));
        company.setSysConfig((String) companyMessage.get("sys_config"));
        company.setFileStoreId((Integer) companyMessage.get("file_store_id"));
        company.setCompanyCode((String) companyMessage.get("company_code"));
        company.setAppFollowupReasons((String) companyMessage.get("app_followup_reasons"));
        company.setLastAction((String) companyMessage.get("operationType"));
        company.setLastModified(new Timestamp(System.currentTimeMillis()));
        return company;
    }


    /**
     * Method to build alerts information.
     *
     * @param alertMessage
     * @return Alerts
     */
    private Alerts buildAlerts(Map<String, Object> alertMessage) {
        Alerts alerts = new Alerts();

        //TODO Need to update data type for column id in the alerts table.
        alerts.setId((Integer) alertMessage.get("id"));
        alerts.setCompanyId((Integer) alertMessage.get("company_id"));
        alerts.setDescription((String) alertMessage.get("description"));
        alerts.setLastAction((String) alertMessage.get("operationType"));
        alerts.setLastModified(new Timestamp(System.currentTimeMillis()));
        return alerts;
    }

    /**
     * Method to build critical findings information.
     *
     * @param criticalFindingsMessage
     * @return CriticalFinding
     */
    private CriticalFinding buildCriticalFindingsMessage(Map<String, Object> criticalFindingsMessage) {
        CriticalFinding criticalFinding = new CriticalFinding();

        criticalFinding.setId((Integer) criticalFindingsMessage.get("id"));
        criticalFinding.setLastAction((String) criticalFindingsMessage.get("operationType"));
        criticalFinding.setLastModified(new Timestamp(System.currentTimeMillis()));
        return criticalFinding;
    }

}
