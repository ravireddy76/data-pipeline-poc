package com.cdi.rule.me.service;


import com.cdi.domain.model.AuditLog;
import com.cdi.domain.model.UserRole;
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
import java.util.Map;

/**
 * LogService class used to consume message from kafka topics and ingest data into
 * target tables in MS SQL server.
 *
 * @author Temam G.
 * @CopyRight (C) All rights reserved to CDI Inc. It's Illegal to reproduce this code.
 */
@Service
@Slf4j
public class LogService {

    @Autowired
    private DataRepository dataRepository;

    @KafkaListener(topics = "${topic.t_audit_log}")
    public void auditLogListener(@Payload String messagePayload) throws Exception {
        log.info("LogService:auditLogListener::Message: {}", messagePayload);

        /* Build the audit log from kafka message. */
        Map<String, Object> auditLogMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        AuditLog auditLog = buildAuditLog(auditLogMessage);

        /* Save or persist the data into the table. */
        dataRepository.save(auditLog);
        log.info("AuditLog is Saved/Updated for the id: {} ", auditLog.getId());
    }

    /**
     * Method to build Audit Log
     * @param auditLogMessage
     * @return
     */
    private AuditLog buildAuditLog(Map<String, Object> auditLogMessage) throws Exception{
//        Timestamp createdDate = AppUtils.convertToTimeStamp((String) auditLogMessage.get("LastModified"));
        long id = new Long((Integer) auditLogMessage.get("id")).longValue();

        AuditLog auditLog =  new AuditLog();
        auditLog.setId(id);
        auditLog.setCompanyId((Integer) auditLogMessage.get("company_id"));
        auditLog.setLoggedDt((String) auditLogMessage.get("logged_dt"));
        auditLog.setStudyId((Integer) auditLogMessage.get("study_id"));
        auditLog.setDetailedInfo((String) auditLogMessage.get("detailed_info"));
        auditLog.setAuditInfo((String) auditLogMessage.get("audit_info"));
        auditLog.setLogDescription((String) auditLogMessage.get("log_description"));
        auditLog.setScreenName((String) auditLogMessage.get("screen_name"));
        auditLog.setUserId((Integer) auditLogMessage.get("user_id"));
        auditLog.setPatientId((Integer) auditLogMessage.get("patient_id"));
        auditLog.setClientIp((String) auditLogMessage.get("client_ip"));
        auditLog.setModuleName((String) auditLogMessage.get("patient"));
        auditLog.setHashValue((String) auditLogMessage.get("hash_value"));
        auditLog.setOrderId((Integer) auditLogMessage.get("order_id"));

        /* Populate the Detailed Info and Detailed Infodata information. */
        buildDetailedInfo(auditLog, auditLogMessage);
        /* Populate the Audit Info and Audit Info data information. */
        buildAuditInfo(auditLog, auditLogMessage);
        return auditLog;
    }

    private void buildDetailedInfo(AuditLog auditLog, Map<String, Object> auditLogMessage) throws IOException {
        String auditLogDataMessage = (String) auditLogMessage.get("detailed_info");
        Map auditLogData = JsonUtils.deserializeJson(Map.class, auditLogDataMessage);

        auditLog.setDetailedInfoOldValues(auditLogData.get("oldValues").toString());
        auditLog.setDetailedInfoSessionId(auditLogData.get("session_id").toString());
        auditLog.setDetailedInfoClientIp(auditLogData.get("client_ip").toString());
        auditLog.setDetailedInfoBrowser(auditLogData.get("browser").toString());
        auditLog.setDetailedInfoBrowswerversion(auditLogData.get("browserversion").toString());
        auditLog.setDetailedInfoOs(auditLogData.get("os").toString());

    }

    private void buildAuditInfo(AuditLog auditLog, Map<String, Object> auditLogMessage) throws IOException {
        String auditLogDataMessage = (String) auditLogMessage.get("audit_info");
        Map auditLogData = JsonUtils.deserializeJson(Map.class, auditLogDataMessage);

        auditLog.setAuditInfoNotesNumber(auditLogData.get("notes_number").toString());
        auditLog.setAuditInfoLoginType(auditLogData.get("login_type").toString());
        auditLog.setAuditInfoUserName(auditLogData.get("user_name").toString());
        auditLog.setAuditInfoUserLevel(auditLogData.get("user_level").toString());
        auditLog.setAuditInfoUserName(auditLogData.get("username").toString());
    }
}
