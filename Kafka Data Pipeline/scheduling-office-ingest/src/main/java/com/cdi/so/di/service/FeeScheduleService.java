package com.cdi.so.di.service;

import com.cdi.domain.model.CptCode;
import com.cdi.domain.model.FeeSchedule;
import com.cdi.domain.model.FeeScheduleCpt;
import com.cdi.domain.util.AppUtils;
import com.cdi.domain.util.JsonUtils;
import com.cdi.so.di.util.AbstractDataTransaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * FeeScheduleService class used to consume message from kafka topics and ingest data into
 * target tables in MS SQL server.
 *
 * @author Ravi Reddy
 * @CopyRight (C) All rights reserved to CDI Inc. It's Illegal to reproduce this code.
 */
@Service
@Slf4j
public class FeeScheduleService {

    @Autowired
    private AbstractDataTransaction dataTransaction;


    /**
     * Method to listen fee schedule and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_fee_schedule}")
    public void feeScheduleListener(@Payload String messagePayload) throws Exception {
        log.info("FeeScheduleService:feeScheduleListener::Message: {}", messagePayload);
        Map<String, Object> feeScheduleMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        FeeSchedule feeSchedule = buildFeeSchedule(feeScheduleMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(feeSchedule);
        log.info("FeeSchedule is Saved/Updated for  fee schedule id: {} ", feeSchedule.getId());
    }


    /**
     * Method to listen fee schedule cpts and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_fee_schedule_cpts}")
    public void feeScheduleCptsListener(@Payload String messagePayload) throws Exception {
        log.info("FeeScheduleService:feeScheduleCptsListener::Message: {}", messagePayload);

        Map<String, Object> feeScheduleCptMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        FeeScheduleCpt feeScheduleCpt = buildFeeScheduleCpt(feeScheduleCptMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(feeScheduleCpt);
        log.info("FeeScheduleCpt is Saved/Updated for  fee schedule cpt id: {} ", feeScheduleCpt.getId());
    }

    /**
     * Method to listen cpt codes and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_cpt_codes}")  //Working
    public void cptCodesListener(@Payload String messagePayload) throws Exception {
        log.info("FeeScheduleService:cptCodesListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> cptCodesMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        CptCode cptCode = buildCptCodes(cptCodesMessage);

        /* Save the cpt codes information.  */
        dataTransaction.ingestData(cptCode);
        log.info("CptCode is Saved/Updated for cpt code id: {} ", cptCode.getId());
    }


    /**
     * Method to map and save cpt code information.
     *
     * @param cptCodesMessage
     * @return CptCode
     * @throws Exception
     */
    private CptCode buildCptCodes(Map<String, Object> cptCodesMessage) throws Exception {
        Timestamp convertedCreatedDate = AppUtils.convertToTimeStamp((String) cptCodesMessage.get("created_dt"));
        BigDecimal rvuValue = new BigDecimal((Double) cptCodesMessage.get("rvu"));

        List<Integer> modalityIdsData = (List<Integer>) cptCodesMessage.get("modalities");
        List<Integer> facilitiesData = (List<Integer>) cptCodesMessage.get("facilities");
        String modalityIds = AppUtils.convertNumbersToValue(modalityIdsData);
        String facilities = AppUtils.convertNumbersToValue(facilitiesData);

        /* Map and build the cpt code entity. */
        CptCode cptCode = new CptCode();
        cptCode.setId((Integer) cptCodesMessage.get("id"));
        cptCode.setActive((Boolean) cptCodesMessage.get("is_active"));
        cptCode.setHasDeleted((Boolean) cptCodesMessage.get("has_deleted"));
        cptCode.setShortDescription((String) cptCodesMessage.get("short_description"));
        cptCode.setCreatedDt(convertedCreatedDate);
        cptCode.setCompanyId((Integer) cptCodesMessage.get("company_id"));
        cptCode.setRefCode((String) cptCodesMessage.get("ref_code"));
        cptCode.setDefault((Boolean) cptCodesMessage.get("is_default"));
        cptCode.setRvu(rvuValue);
        cptCode.setDuration((Integer) cptCodesMessage.get("duration"));
        cptCode.setBatch((Boolean) cptCodesMessage.get("is_batch"));
        cptCode.setDisplayDescription((String) cptCodesMessage.get("display_description"));
        cptCode.setAdditionalInfo((String) cptCodesMessage.get("additional_info"));
        cptCode.setDisplayCode((String) cptCodesMessage.get("display_code"));
        cptCode.setLastAction((String) cptCodesMessage.get("operationType"));
        cptCode.setModalities(modalityIds);
        cptCode.setFacilities(facilities);
        cptCode.setLastModified(new Timestamp(System.currentTimeMillis()));
        return cptCode;
    }


    /**
     * Method to build fee schedule information.
     *
     * @param feeScheduleMessage
     * @return FeeSchedule
     * @throws Exception
     */
    private FeeSchedule buildFeeSchedule(Map<String, Object> feeScheduleMessage) throws Exception {
        FeeSchedule feeSchedule = new FeeSchedule();
        feeSchedule.setId((Integer) feeScheduleMessage.get("id"));
        feeSchedule.setName((String) feeScheduleMessage.get("name"));
        feeSchedule.setCategory((String) feeScheduleMessage.get("category"));
        feeSchedule.setLastaction((String) feeScheduleMessage.get("operationType"));

        //TODO Need to convert Integer value to dates
        feeSchedule.setFromDate(new Date());
        feeSchedule.setToDate(new Date());
        feeSchedule.setLastmodified(new Timestamp(System.currentTimeMillis()));
        return feeSchedule;
    }


    /**
     * Method to build fee schedule cpt information.
     *
     * @param feeScheduleCptMessage
     * @return FeeScheduleCpt
     * @throws Exception
     */
    private FeeScheduleCpt buildFeeScheduleCpt(Map<String, Object> feeScheduleCptMessage) throws Exception {
        FeeScheduleCpt feeScheduleCpt = new FeeScheduleCpt();
        feeScheduleCpt.setId((Integer) feeScheduleCptMessage.get("id"));
        feeScheduleCpt.setCptCodeId((Integer) feeScheduleCptMessage.get("cpt_code_id"));
        feeScheduleCpt.setFeeScheduleId((Integer) feeScheduleCptMessage.get("fee_schedule_id"));
        feeScheduleCpt.setProfessionalFee((Double) feeScheduleCptMessage.get("professional_fee"));
        feeScheduleCpt.setTechnicalFee((Double) feeScheduleCptMessage.get("technical_fee"));
        feeScheduleCpt.setGlobalFee((Double) feeScheduleCptMessage.get("global_fee"));
        feeScheduleCpt.setLastaction((String) feeScheduleCptMessage.get("operationType"));
        feeScheduleCpt.setLastmodified(new Timestamp(System.currentTimeMillis()));
        return feeScheduleCpt;
    }

}