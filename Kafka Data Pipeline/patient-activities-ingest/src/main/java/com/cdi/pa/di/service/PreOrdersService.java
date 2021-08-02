package com.cdi.pa.di.service;

import com.cdi.domain.model.InsuranceAuthorization;
import com.cdi.domain.repository.DataRepository;
import com.cdi.domain.util.AppUtils;
import com.cdi.domain.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * PreOrdersService class used to consume message from kafka topics and ingest data into
 * target tables in MS SQL server.
 *
 * @author Ravi Reddy
 * @CopyRight (C) All rights reserved to CDI Inc. It's Illegal to reproduce this code.
 */
@Service
@Slf4j
public class PreOrdersService {

    @Autowired
    private DataRepository dataRepository;


    /**
     * Method to listen order and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_insurance_authorizations}")  //Working
    public void insuranceAuthorizationsListener(@Payload String messagePayload) throws Exception {
        log.info("QCService:orderListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> insuranceAuthorizationMsg = JsonUtils.deserializeJson(Map.class, messagePayload);
        InsuranceAuthorization insuranceAuthorization = buildInsuranceAuthorization(insuranceAuthorizationMsg);

        /* Save or persist the data into the table. */
        dataRepository.save(insuranceAuthorization);
        log.info("InsuranceAuthorization is Saved/Updated for insurance authorization id: {} ", insuranceAuthorization.getId());
    }


    /**
     * Method to build/populate insurance authorization information.
     *
     * @param insuranceAuthorizationMsg
     * @return InsuranceAuthorization
     */
    private InsuranceAuthorization buildInsuranceAuthorization(Map<String, Object> insuranceAuthorizationMsg) {
        InsuranceAuthorization insuranceAuthorization = new InsuranceAuthorization();

        List<String> cptCodesData = (List<String>) insuranceAuthorizationMsg.get("cpt_codes");
        List<Integer> insuranceProvidersData = (List<Integer>) insuranceAuthorizationMsg.get("insurance_providers");
        String cptCodes = CollectionUtils.isEmpty(cptCodesData) ? "" : String.join(",", cptCodesData);
        String insuranceProviders = CollectionUtils.isEmpty(insuranceProvidersData) ? "" : AppUtils.convertNumbersToValue(insuranceProvidersData);
        int isActiveValue = ((Boolean) insuranceAuthorizationMsg.get("is_active")) ? 1 : 0;

        insuranceAuthorization.setId((Integer) insuranceAuthorizationMsg.get("id"));
        insuranceAuthorization.setModalityId((Integer) insuranceAuthorizationMsg.get("modality_id"));
        insuranceAuthorization.setFacilityId((Integer) insuranceAuthorizationMsg.get("facility_id"));
        insuranceAuthorization.setDays((Integer) insuranceAuthorizationMsg.get("days"));
        insuranceAuthorization.setApplyAllCodes((Boolean) insuranceAuthorizationMsg.get("apply_all_codes"));
        insuranceAuthorization.setCptCodes(cptCodes);
        insuranceAuthorization.setApplyAllInsurances((Boolean) insuranceAuthorizationMsg.get("apply_all_insurances"));
        insuranceAuthorization.setCptCodes(cptCodes);
        insuranceAuthorization.setInsuranceProviders(insuranceProviders);
        insuranceAuthorization.setApplyAllModalities((Boolean) insuranceAuthorizationMsg.get("apply_all_modalities"));
        insuranceAuthorization.setHasDeleted((Boolean) insuranceAuthorizationMsg.get("has_deleted"));
        insuranceAuthorization.setIsActive(isActiveValue);
        insuranceAuthorization.setDeletedDt((String) insuranceAuthorizationMsg.get("deleted_dt"));
        insuranceAuthorization.setAllowScheduling((Boolean) insuranceAuthorizationMsg.get("allow_scheduling"));
        insuranceAuthorization.setLastAction((String) insuranceAuthorizationMsg.get("operationType"));
        insuranceAuthorization.setLastModified(new Timestamp(System.currentTimeMillis()));
        return insuranceAuthorization;
    }

}
