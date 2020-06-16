package com.di.poc.listener;

import com.di.poc.model.Order;
import com.di.poc.repository.OrderRepo;
import com.di.poc.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * DataProcessListener class used to consume message from kafka topic,Compute claims and ingest data results into MS SQL server.
 *
 * @author Ravi Reddy
 * @CopyRight (C) All rights reserved to Ravi POC World Inc. It's Illegal to reproduce this code.
 */
@Service
@Slf4j
public class DataProcessListener {

    @Autowired
    private OrderRepo orderRepo;

    @KafkaListener(topics = "${topic.ordert}")
    public void messageListener(@Payload String messagePayload) throws Exception {
        log.info("Message: {}", messagePayload);

        /* Map and build order data and ingest. */
        Map<String, Object> messageData = JsonUtils.deserializeJson(Map.class, messagePayload);
        Order order = buildOrder(messageData);
        Order savedOrder = orderRepo.saveAndFlush(order);
        log.info("Order data ingested for order id: {}", savedOrder.getId());
    }


    @SuppressWarnings("unchecked")
    private Order buildOrder(Map<String, Object> messageData) throws Exception {
        Order order = new Order();

        Map<String, String> orderInfo =(Map<String, String>)messageData.get("orderInfo");
        Map<String, Object> muValidationData =(Map<String, Object>)messageData.get("muValidationData");


        order.setId(new Long((Integer)messageData.get("id")));
        order.setAa(orderInfo.get("aa"));
        order.setOa(orderInfo.get("oa"));
        order.setAppontmentReminder(orderInfo.get("appontmentReminder"));
        //order.setCognitiveStatus();
        order.setCompanyId((Integer)messageData.get("companyId"));

        List<Integer> cptCodesData = (List<Integer>)messageData.get("cptCodes");
        order.setCptCodes(StringUtils.join(cptCodesData,","));
        order.setCreatedby(orderInfo.get("createdby"));
       // order.setCurrentDate(orderInfo.get("currentDate"));
        //order.setCurrentDate(new Date().toString());

        //TODO there is no information in message.
        //order.setDeletedDt();
        order.setDischargeInstructions("No Data");

        order.setDispatchAddress(orderInfo.get("dispatch_address"));
        order.setDispatchContactName(orderInfo.get("dispatch_contact_name"));
        order.setDispatchContactNumber(orderInfo.get("dispatch_contact_number"));
        order.setDuration((Integer)messageData.get("duration"));
        order.setEmp(orderInfo.get("emp"));
        //order.setFacilityId(Integer.parseInt(orderInfo.get("ordering_facility_id")));
        int facilityIdVal = StringUtils.isNotBlank(orderInfo.get("ordering_facility_id")) ? Integer.parseInt(orderInfo.get("ordering_facility_id")) : 0;
        order.setFacilityId(facilityIdVal);

//        String fStatusApplied = ((Map<String, String>)muValidationData.get("functional_status")).get("applied");
//        order.setFunctionalStatus(fStatusApplied);
        order.setGoogleJobId(orderInfo.get("google_job_id"));

        //TODO no data for below fields in incoming message.
        order.setHasApproved(false);
        order.setHasRescheduled(false);
        order.setInHold(false);
        order.setHistoryInfo("No DATA");
        order.setLastMuUpdatedBy("NO DATA");
       // order.setMuLastUpdated(new Timestamp(Instant.now().toEpochMilli()));
        order.setMuPassed(false);
        order.setPhyOrderStatus("No DATA");


        List<Integer> icdCodesData = (List<Integer>)messageData.get("icdCodes");
        order.setIcdCodes(StringUtils.join(icdCodesData,","));
        order.setQuickAppt((Boolean) messageData.get("isQuickAppt"));
        order.setIsRejected(orderInfo.get("is_rejected"));
        order.setIsMedicationReconciliation(orderInfo.get("isMedicationReconciliation"));
        order.setIsPreOrder(orderInfo.get("isPreOrder"));
        order.setIsquickapptFrom(orderInfo.get("isquickappt_from"));
        order.setJos(orderInfo.get("jos"));

        List<Integer> linkedRadOrders = (List<Integer>)messageData.get("linkedRadOrders");
        order.setLinkedRadOrders(StringUtils.join(linkedRadOrders,","));
        order.setModalityId((Integer) messageData.get("modalityId"));
        //order.setModalityRoomId((Integer) messageData.get("modalityRoomId"));
        order.setModalityRoomId(0);
        String muValidationDataValue = JsonUtils.serializeJson(muValidationData);
        order.setMuValidationData(muValidationDataValue);
        order.setOrderGuid(orderInfo.get("referralNo"));
        order.setOrderSource(orderInfo.get("source"));
        order.setOrderStatus((String)messageData.get("orderStatus"));
        order.setOrderStatusDesc((String)messageData.get("orderStatusDesc"));

        int orderStatusLastChangedByValue = StringUtils.isNotBlank(orderInfo.get("orderStatusLastChangedBy")) ? Integer.parseInt(orderInfo.get("orderStatusLastChangedBy")) : 0;
        order.setOrderStatusLastChangedBy(orderStatusLastChangedByValue);

        //order.setOrderStatusLastChangedDt( new Timestamp((Long)messageData.get("orderStatusLastChangedDt")));
        //order.setOrderStatusLastChangedDt(new Timestamp(Instant.now().toEpochMilli()));
        order.setOrderType((String)messageData.get("orderType"));
        order.setOrderContact(orderInfo.get("orderContact"));

        int orderedByValue = StringUtils.isNotBlank(orderInfo.get("orderedBy")) ? Integer.parseInt(orderInfo.get("orderedBy")) : 0;
        order.setOrderedBy(orderedByValue);

        //order.setOrderedDt(new Timestamp((Long)messageData.get("orderedDt")));
        order.setOrderingFacility(orderInfo.get("ordering_facility"));
        order.setOrderingFacilityId(orderInfo.get("ordering_facility_id"));

        List<Integer> orderingProviders = (List<Integer>)messageData.get("orderingProviders");
        order.setOrderingProviders(StringUtils.join(orderingProviders,","));
        order.setPatientAge(orderInfo.get("patient_age"));
        order.setPatientId(new Long((Integer)messageData.get("patientId")));
        order.setPatientCondition(orderInfo.get("patientCondition"));
        order.setPatientEmail(orderInfo.get("patientEmail"));
        order.setPatientLocation(orderInfo.get("patientLocation"));
        order.setPatientRoom(orderInfo.get("patientRoom"));
        order.setPos(orderInfo.get("pos"));
        order.setPosMapCode(orderInfo.get("pos_map_code"));
        order.setPosTypeCode(orderInfo.get("pos_type_code"));


        List<Integer> readingProviders = (List<Integer>)messageData.get("readingProviders");
        List<Integer> referringProviderIds = (List<Integer>)messageData.get("referringProviderIds");
        List<Integer> referringProviders = (List<Integer>)messageData.get("referringProviderIds");

       // order.setPrimaryPatientInsuranceId(new Long((Integer)messageData.get("primaryPatientInsuranceId")));
        order.setPrimaryPatientInsuranceId(new Long("111"));
        order.setProviderId(0);
        order.setReadingProviders(StringUtils.join(readingProviders,","));
        order.setReferralNo(orderInfo.get("referralNo"));
        order.setReferringProviderIds(StringUtils.join(referringProviderIds,","));
        order.setReferringProviderLoginID(orderInfo.get("referring_providerloginID"));
        order.setReferringProviders(StringUtils.join(referringProviders,","));
       // order.setRequestingDate("No DATA");
       // order.setScheduledDate("No DATA");
        //order.setScheduledDt(new Timestamp(Instant.now().toEpochMilli()));
        order.setSecondaryPatientInsuranceId(new Long(000));
        order.setSource(orderInfo.get("source"));
        order.setStat(orderInfo.get("stat"));
        order.setTechnologistId(0);
        order.setTechnologistName("No DATA");
        order.setTertiaryPatientInsuranceId(new Long(000));
        order.setTransactionCareIn("No DATA");
        order.setTransport(orderInfo.get("transport"));
        order.setVehicleId(000);
        order.setVehicleName("No DATA");
        order.setVisitNo("No DATA");
        return order;
    }
}
