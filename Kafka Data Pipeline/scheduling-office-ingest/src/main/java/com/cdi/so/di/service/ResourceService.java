package com.cdi.so.di.service;

import com.cdi.domain.model.*;
import com.cdi.domain.util.JsonUtils;
import com.cdi.so.di.util.AbstractDataTransaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * ResourceService class used to consume message from kafka topics for peer review facilities and ingest data into
 * target tables in MS SQL server.
 *
 * @author Temam Geletu
 * @CopyRight (C) All rights reserved to CDI Inc. It's Illegal to reproduce this code.
 */
@Service
@Slf4j
public class ResourceService {

    @Autowired
    private AbstractDataTransaction dataTransaction;

    /**
     * Method to listen peer review facilities and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */

    @KafkaListener(topics = "${topic.t_peer_review_facilities}") // Works fine
    public void peerReviewFacilitiesListener(@Payload String messagePayload) throws Exception {
        log.info("ResourceService:peerReviewFacilitiesListener::Message: {}", messagePayload);

        /* Build the peer review facilities from kafka message. */
        Map<String, Object> peerReviewFacilitiesMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        PeerReviewFacilities peerReviewFacilities = buildPeerReviewFacilities(peerReviewFacilitiesMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(peerReviewFacilities);
        log.info("Peer Review Facilities is Saved/Updated for the id: {} ", peerReviewFacilities.getId());
    }

    /**
     * Method to listen peer review cpt codes and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_peer_review_cpt_codes}") // Works fine
    public void peerReviewCptCodesListener(@Payload String messagePayload) throws Exception {
        log.info("ResourceService:peerReviewCptCodesListener::Message: {}", messagePayload);

        /* Build the peer review cpt codes from kafka message. */
        Map<String, Object> peerReviewCptCodesMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        PeerReviewCptCodes peerReviewCptCodes = buildPeerReviewCptCodes(peerReviewCptCodesMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(peerReviewCptCodes);
        log.info("Peer Review Cpt Codes is Saved/Updated for the id: {} ", peerReviewCptCodes.getId());
    }

    /**
     * Method to listen peer review study descriptions and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_peer_review_study_descriptions}") // Works fine
    public void peerReviewStudyDescriptionsListener(@Payload String messagePayload) throws Exception {
        log.info("ResourceService:peerReviewStudyDescriptionsListener::Message: {}", messagePayload);

        /* Build the Peer Review Study Descriptions from kafka message. */
        Map<String, Object> peerReviewStudyDescriptionsMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        PeerReviewStudyDescription peerReviewStudyDescription = buildPeerReviewStudyDescriptions(peerReviewStudyDescriptionsMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(peerReviewStudyDescription);
        log.info("Peer Review Study Description is Saved/Updated for the id: {} ", peerReviewStudyDescription.getId());
    }

    /**
     * Method to listen peer review facilities and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
//    @KafkaListener(topics = "${topic.t_peer_review_modalities}")
//    public void peerReviewModalitiesListener(@Payload String messagePayload) throws Exception {
//        log.info("ResourceService:peerReviewModalitiesListener::Message: {}", messagePayload);
//
//        /* Build the Peer Review Modalities from kafka message. */
//        Map<String, Object> peerReviewModalitiesMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
//        PeerReviewModalities  peerReviewFacilities = buildPeerReviewModalities(peerReviewModalitiesMessage);
//
//        /* Save or persist the data into the table. */
//        dataRepository.save(peerReviewFacilities);
//        log.info("ResourceService Template is Saved/Updated for the id: {} ", peerReviewFacilities.getId());
//    }

    /**
     * Method to listen peer review appointment types and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_peer_review_appointment_types}") // Works fine
    public void peerReviewAppointmentTypesListener(@Payload String messagePayload) throws Exception {
        log.info("ResourceService:peerReviewAppointmentTypesListener::Message: {}", messagePayload);

        /* Build the Peer Review Modalities from kafka message. */
        Map<String, Object> peerReviewAppointmentTypesMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        PeerReviewAppointmentTypes peerReviewAppointmentTypes = buildPeerReviewAppointmentTypes(peerReviewAppointmentTypesMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(peerReviewAppointmentTypes);
        log.info("Peer Review Appointment Types is Saved/Updated for the id: {} ", peerReviewAppointmentTypes.getId());
    }

    /**
     * Method to listen facility fee schedules and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
//    @KafkaListener(topics = "${topic.t_facility_fee_schedules")
//    public void facilityFeeSchedulesListener(@Payload String messagePayload) throws Exception {
//        log.info("ResourceService:facilityFeeSchedulesListener::Message: {}", messagePayload);
//
//        /* Build the peer review facilities from kafka message. */
//        Map<String, Object> facilityFeeSchedulesMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
//        FacilityFeeSchedule  facilityFeeSchedule = buildFacilityFeeSchedule(facilityFeeSchedulesMessage);
//
//        /* Save or persist the data into the table. */
//        dataRepository.save(facilityFeeSchedule);
//        log.info("FacilityFeeSchedule Template is Saved/Updated for the id: {} ", facilityFeeSchedule.getId());
//    }

    /**
     * Method to map and save Peer Review Facilities information.
     *
     * @param peerReviewFacilitiesMessage
     * @return PeerReviewFacilities
     * @throws Exception
     */
    private PeerReviewFacilities buildPeerReviewFacilities(Map<String, Object> peerReviewFacilitiesMessage) {
        PeerReviewFacilities peerReviewFacilities = new PeerReviewFacilities();

        long id = new Long((Integer) peerReviewFacilitiesMessage.get("id")).longValue();

        peerReviewFacilities.setId(id);
        peerReviewFacilities.setCondition((String) peerReviewFacilitiesMessage.get("condition"));
        peerReviewFacilities.setFacilityId((Integer) peerReviewFacilitiesMessage.get("facility_id"));
        peerReviewFacilities.setProviderId((Integer) peerReviewFacilitiesMessage.get("provider_id"));

        return peerReviewFacilities;
    }

    /**
     * Method to map and save Peer Review Cpt Codes information.
     *
     * @param peerReviewCptCodesMessage
     * @return PeerReviewCptCodes
     * @throws Exception
     */
    private PeerReviewCptCodes buildPeerReviewCptCodes(Map<String, Object> peerReviewCptCodesMessage) {
        PeerReviewCptCodes peerReviewCptCodes = new PeerReviewCptCodes();
        long id = new Long((Integer) peerReviewCptCodesMessage.get("id")).longValue();

        peerReviewCptCodes.setId(id);
        peerReviewCptCodes.setCondition((String) peerReviewCptCodesMessage.get("condition"));
        peerReviewCptCodes.setCptCodeId((Integer) peerReviewCptCodesMessage.get("cpt_code_id"));
        peerReviewCptCodes.setProviderId((Integer) peerReviewCptCodesMessage.get("provider_id"));

        return peerReviewCptCodes;
    }

    /**
     * Method to map and save Peer Review Study Descriptions information.
     *
     * @param peerReviewStudyDescriptionsMessage
     * @return PeerReviewStudyDescription
     * @throws Exception
     */
    private PeerReviewStudyDescription buildPeerReviewStudyDescriptions(Map<String, Object> peerReviewStudyDescriptionsMessage) {
        PeerReviewStudyDescription peerReviewStudyDescription = new PeerReviewStudyDescription();
        long id = new Long((Integer) peerReviewStudyDescriptionsMessage.get("id")).longValue();

        peerReviewStudyDescription.setId(id);
        peerReviewStudyDescription.setCondition((String) peerReviewStudyDescriptionsMessage.get("condition"));
        peerReviewStudyDescription.setContains((boolean) peerReviewStudyDescriptionsMessage.get("is_contains"));
        peerReviewStudyDescription.setDescription((String) peerReviewStudyDescriptionsMessage.get("description"));
        peerReviewStudyDescription.setProviderId((Integer) peerReviewStudyDescriptionsMessage.get("provider_id"));

        return peerReviewStudyDescription;
    }

    /**
     * Method to map and save Facility Fee Schedule information.
     *
     * @param facilityFeeSchedulesMessage
     * @return FacilityFeeSchedule
     * @throws Exception
     */
//    private FacilityFeeSchedule buildFacilityFeeSchedule(Map<String, Object> facilityFeeSchedulesMessage) {
//        FacilityFeeSchedule facilityFeeSchedule = new FacilityFeeSchedule();
//        List<String> facilitiesData = (List<String>) facilityFeeSchedulesMessage.get("facilities");
//        List<String> providerData = (List<String>) facilityFeeSchedulesMessage.get("provider");
//        String facilities = AppUtils.convertArrayToValue(facilitiesData);
//        String provider = AppUtils.convertArrayToValue(providerData);
//        long id = new Long((Integer) facilityFeeSchedulesMessage.get("id")).longValue();
//
//        facilityFeeSchedule.setId(id);
////        facilityFeeSchedule.setEndDate((String) facilityFeeSchedulesMessage.get("end_date"));
//        facilityFeeSchedule.setActive((boolean) facilityFeeSchedulesMessage.get("is_active"));
//        facilityFeeSchedule.setCompanyId((Integer) facilityFeeSchedulesMessage.get("company_id"));
//        facilityFeeSchedule.setModalityFees((String) facilityFeeSchedulesMessage.get("modality_fees"));
//        facilityFeeSchedule.setAppointmentTypeFees((String) facilityFeeSchedulesMessage.get("appointment_type_fees"));
//
//        facilityFeeSchedule.setName((String) facilityFeeSchedulesMessage.get("name"));
//        facilityFeeSchedule.setFacilities(facilities);
//        facilityFeeSchedule.setProvider(provider);
////        facilityFeeSchedule.setStartDate((String) facilityFeeSchedulesMessage.get("start_date"));
//
//        return facilityFeeSchedule;
//    }

    /**
     * Method to map and save Peer Review Appointment Types information.
     *
     * @param peerReviewAppointmentTypesMessage
     * @return FacilityFeeSchedule
     * @throws Exception
     */
    private PeerReviewAppointmentTypes buildPeerReviewAppointmentTypes(Map<String, Object> peerReviewAppointmentTypesMessage) {
        PeerReviewAppointmentTypes peerReviewAppointmentTypes = new PeerReviewAppointmentTypes();
        long id = new Long((Integer) peerReviewAppointmentTypesMessage.get("id")).longValue();

        peerReviewAppointmentTypes.setId(id);
        peerReviewAppointmentTypes.setAppointmentTypeId((Integer) peerReviewAppointmentTypesMessage.get("appointment_type_id"));
        peerReviewAppointmentTypes.setCondition((String) peerReviewAppointmentTypesMessage.get("condition"));
        peerReviewAppointmentTypes.setProviderId((Integer) peerReviewAppointmentTypesMessage.get("provider_id"));

        return peerReviewAppointmentTypes;
    }

}
