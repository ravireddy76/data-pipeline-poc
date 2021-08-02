package com.cdi.so.di.service;

import com.cdi.domain.model.Facility;
import com.cdi.domain.model.Modality;
import com.cdi.domain.model.ModalityRoom;
import com.cdi.domain.util.AppUtils;
import com.cdi.domain.util.JsonUtils;
import com.cdi.so.di.util.AbstractDataTransaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * FacilityModalityService class used to consume message from kafka topics for
 * facilities, modality,modality rooms to ingest data into target tables in MS SQL server.
 *
 * @author Ravi Reddy
 * @CopyRight (C) All rights reserved to CDI Inc. It's Illegal to reproduce this code.
 */
@Service
@Slf4j
public class FacilityModalityService {

    @Autowired
    private AbstractDataTransaction dataTransaction;

    /**
     * Method to listen facilities topic and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_facilities}") //Working
    public void facilitiesListener(@Payload String messagePayload) throws Exception {
        log.info("FacilityModalityService:facilitiesListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> facilitiesMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        Facility facility = buildFacility(facilitiesMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(facility);
        log.info("Facility is Saved/Updated for the id: {} ", facility.getId());
    }


    /**
     * Method to modalities topic and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_modalities}")  //Working
    public void modalityListener(@Payload String messagePayload) throws Exception {
        log.info("FacilityModalityService:modalityListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> modalityMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        Modality modality = buildModality(modalityMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(modality);
        log.info("Modality is Saved/Updated for the id: {} ", modality.getId());
    }


    /**
     * Method to modality rooms topic and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_modality_rooms}") //Working
    public void modalityRoomListener(@Payload String messagePayload) throws Exception {
        log.info("FacilityModalityService:modalityRoomListener::Message: {}", messagePayload);

        /* Translate message payload to map. */
        Map<String, Object> modalityRoomMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        ModalityRoom modalityRoom = buildModalityRoom(modalityRoomMessage);

        /* Save or persist the data into the table. */
        dataTransaction.ingestData(modalityRoom);
        log.info("ModalityRoom is Saved/Updated for the id: {} ", modalityRoom.getId());
    }

    /**
     * Method to build the facility information.
     *
     * @param facilityMessage
     * @return Facility
     * @throws Exception
     */
    private Facility buildFacility(Map<String, Object> facilityMessage) throws Exception {
        Facility facility = new Facility();

        String facilityInfoMessage = (String) facilityMessage.get("facility_info");
        String mrnInfoMsg = (String) facilityMessage.get("mrn_info");
        String studyWorkflowLocationMsg = (String) facilityMessage.get("study_workflow_locations");
        String operationType = (String) facilityMessage.get("operationType");

        Map facilityInfo = JsonUtils.deserializeJson(Map.class, facilityInfoMessage);
        Map mrnInfo = JsonUtils.deserializeJson(Map.class, mrnInfoMsg);

        facility.setId((Integer) facilityMessage.get("id"));
        facility.setCompanyId((Integer) facilityMessage.get("company_id"));
        facility.setFacilityInfo(facilityInfoMessage);
        facility.setFacilityCode((String) facilityMessage.get("facility_code"));
        facility.setFacilityInfoAbbreviatedReceipt((String) facilityInfo.get("abbreviated_receipt"));
        facility.setFacilityInfoAuthRequesterId((String) facilityInfo.get("auth_requester_id"));
        facility.setFacilityInfoBenefitOnDate((String) facilityInfo.get("benefit_on_date"));
        facility.setFacilityInfoCustomReceiptEnabled((String) facilityInfo.get("customReceiptEnabled"));
        facility.setFacilityInfoDisplayDate((String) facilityInfo.get("display_date"));
        facility.setFacilityInfoEligibilityReceiverId((String) facilityInfo.get("eligibility_receiver_id"));
        facility.setFacilityInfoEnableAltAccountNo((String) facilityInfo.get("enable_alt_account_no"));
        facility.setFacilityInfoEnableInsuranceClaims((String) facilityInfo.get("enable_insurance_claims"));
        facility.setFacilityInfoEnableInsuranceEligibility((String) facilityInfo.get("enable_insurance_eligibility"));
        facility.setFacilityInfoEnableManualCheckout((String) facilityInfo.get("enable_manual_checkout"));
        facility.setFacilityInfoExamPrepRequired((String) facilityInfo.get("exam_prep_required"));
        facility.setFacilityInfoFacilityAddress1((String) facilityInfo.get("facility_address1"));
        facility.setFacilityInfoFacilityAddress2((String) facilityInfo.get("facility_address2"));
        facility.setFacilityInfoFacilityAutofax((String) facilityInfo.get("facility_autoFax"));
        facility.setFacilityInfoFacilityCity((String) facilityInfo.get("facility_city"));
        facility.setFacilityInfoFacilityContactNo((String) facilityInfo.get("facility_contactNo"));
        facility.setFacilityInfoFacilityCountry((String) facilityInfo.get("facility_country"));
        facility.setFacilityInfoFacilityEmail((String) facilityInfo.get("facility_email"));
        facility.setFacilityInfoFacilityEmailAttachment((String) facilityInfo.get("facility_emailAttachment"));
        facility.setFacilityInfoFacilityEmailLink((String) facilityInfo.get("facility_emailLink"));
        facility.setFacilityInfoFacilityEmailPassword((String) facilityInfo.get("facility_emailPassword"));
        facility.setFacilityInfoFacilityFaxNo((String) facilityInfo.get("facility_faxNo"));
        facility.setFacilityInfoFacilityInherit((String) facilityInfo.get("facility_inherit"));
        facility.setFacilityInfoFacilityMammoLicenseId((String) facilityInfo.get("facility_mammoLicenseId"));
        facility.setFacilityInfoFacilityState((String) facilityInfo.get("facility_state"));
        facility.setFacilityInfoFacilityWebsite((String) facilityInfo.get("facility_website"));
        facility.setFacilityInfoFacilityZip((String) facilityInfo.get("facility_zip"));
        facility.setFacilityInfoFederalTaxId((String) facilityInfo.get("federal_tax_id"));
        facility.setFacilityInfoGlobalAutoPrint((String) facilityInfo.get("global_auto_print"));
        facility.setFacilityInfoGlobalAutoPrinter((String) facilityInfo.get("global_auto_printer"));
        facility.setFacilityInfoImportDocsIntoDicoms((String) facilityInfo.get("import_docs_into_dicoms"));
        facility.setFacilityInfoMobileDispatchingAddress((String) facilityInfo.get("mobileDispatchingAddress"));
        facility.setFacilityInfoModalityDisplayWidth((String) facilityInfo.get("modality_display_width"));
        facility.setFacilityInfoNpiNo((String) facilityInfo.get("npino"));
        facility.setFacilityInfoPayToProviderId((String) facilityInfo.get("pay_to_provider_id"));
        facility.setFacilityInfoPokitdokResponse((String) facilityInfo.get("pokitdok_response"));
        facility.setFacilityInfoPosonalways((String) facilityInfo.get("posOnAlways"));
        facility.setFacilityInfoPrimaryPhysRequired((String) facilityInfo.get("primary_phys_required"));
        facility.setFacilityInfoReceiptAddress1((String) facilityInfo.get("receiptAddress1"));
        facility.setFacilityInfoReceiptAddress2((String) facilityInfo.get("receiptAddress2"));
        facility.setFacilityInfoReceiptCity((String) facilityInfo.get("receiptCity"));
        facility.setFacilityInfoReceiptContactNo((String) facilityInfo.get("receiptContactNo"));
        facility.setFacilityInfoReceiptCountry((String) facilityInfo.get("receiptCountry"));
        facility.setFacilityInfoReceiptFax((String) facilityInfo.get("receiptFax"));
        facility.setFacilityInfoReceiptName((String) facilityInfo.get("receiptName"));
        facility.setFacilityInfoReceiptCity((String) facilityInfo.get("receiptCity"));
        facility.setFacilityInfoReceiptState((String) facilityInfo.get("receiptState"));
        facility.setFacilityInfoReceiptZip((String) facilityInfo.get("receiptZip"));
        facility.setFacilityInfoRenderingProviderId((String) facilityInfo.get("rendering_provider_id"));
        facility.setFacilityInfoRestrictDoubleBooking((String) facilityInfo.get("restrictDoubleBooking"));
        facility.setFacilityInfoServiceFacilityId((String) facilityInfo.get("service_facility_id"));
        facility.setFacilityInfoServiceFacilityName((String) facilityInfo.get("service_facility_name"));
        facility.setFacilityInfoShowPatientAlerts((String) facilityInfo.get("show_patient_alerts"));
        facility.setFacilityInfoShowRecentSchedules((String) facilityInfo.get("show_recent_schedules"));
        facility.setFacilityInfoShowSchedulesDays((String) facilityInfo.get("show_schedules_days"));
        facility.setFacilityInfoShowStudies((String) facilityInfo.get("show_studies"));
        facility.setFacilityInfoSsnRequired((String) facilityInfo.get("ssn_required"));
        facility.setFacilityInfoSubmitterId((String) facilityInfo.get("submitter_id"));
        facility.setFacilityInfoUpdoxAccount((String) facilityInfo.get("updox_account"));
        facility.setFacilityInfoUpdoxSendFax((String) facilityInfo.get("updox_send_fax"));
        facility.setFacilityName((String) facilityMessage.get("facility_name"));
        facility.setFeeScheduleId(new Long(0));
        facility.setFileStoreId((Integer) facilityMessage.get("file_store_id"));
        facility.setMrnInfo(mrnInfoMsg); //Need to increase the length or size of the column
        facility.setMrnInfoAllowDuplicates((String) mrnInfo.get("allow_duplicates"));
        facility.setMrnInfoCanEdit((String) mrnInfo.get("can_edit"));
        facility.setMrnInfoCurrentIndex((String) mrnInfo.get("current_index"));
        facility.setMrnInfoFieldLength((String) mrnInfo.get("field_length"));
        facility.setMrnInfoIsFixedLength((String) mrnInfo.get("is_fixed_length"));
        facility.setMrnInfoMrnType((String) mrnInfo.get("mrn_type"));
        facility.setMrnInfoPrefix((String) mrnInfo.get("prefix"));
        facility.setMrnInfoPreview((String) mrnInfo.get("preview"));
        facility.setMrnInfoStartFrom((String) mrnInfo.get("start_from"));
        facility.setMrnInfoSuffix((String) mrnInfo.get("suffix"));
        facility.setMuValidationFields("");
        facility.setPlaceOfServiceId(new Long(0));
        facility.setStudyWorkflowLocations(studyWorkflowLocationMsg); // Need to increase the length or size of the column
        facility.setTimeZone((String) facilityMessage.get("time_zone"));
        facility.setInRoomStatusCode((String) facilityMessage.get("in_room_status_code"));
        facility.setActiveStatus((Boolean) facilityMessage.get("is_active"));
        facility.setLastAction(operationType);
        facility.setLastModified(new Timestamp(System.currentTimeMillis()));
        facility.setMaxTat(new Short("0"));
        return facility;
    }


    /**
     * Method to build modality information.
     *
     * @param modalityMessage
     * @return Modality
     */
    private Modality buildModality(Map<String, Object> modalityMessage) {
        Modality modality = new Modality();

        modality.setId((Integer) modalityMessage.get("id"));
        modality.setModalityCode((String) modalityMessage.get("modality_code"));
        modality.setActive((Boolean) modalityMessage.get("is_active"));
        modality.setCompanyId((Integer) modalityMessage.get("company_id"));
        modality.setHiddenOnPhysicianPortal((Boolean) modalityMessage.get("hidden_on_physician_portal"));
        modality.setModalityName((String) modalityMessage.get("modality_name"));
        modality.setLastaction((String) modalityMessage.get("operationType"));
        modality.setLastmodified(new Timestamp(System.currentTimeMillis()));
        return modality;
    }


    /**
     * Method to build modality room information.
     *
     * @param modalityRoomMessage
     * @return Modality
     */
    @SuppressWarnings("unchecked")
    private ModalityRoom buildModalityRoom(Map<String, Object> modalityRoomMessage) {
        ModalityRoom modalityRoom = new ModalityRoom();
        List<Integer> modalitiesData = (List<Integer>) modalityRoomMessage.get("modalities");
        String modalities = AppUtils.convertNumbersToValue(modalitiesData);
        long id = new Long((Integer) modalityRoomMessage.get("id")).longValue();
        String moreInfoMsg = (String) modalityRoomMessage.get("more_info");

        modalityRoom.setId(id);
        modalityRoom.setActive((Boolean) modalityRoomMessage.get("is_active"));
        modalityRoom.setHasDeleted((Boolean) modalityRoomMessage.get("has_deleted"));
        modalityRoom.setFromDate(new Date()); //(Date) modalityRoomMessage.get("from_date") //TODO Need to FIX 5 digit value to Date value.
        modalityRoom.setToDate(new Date()); //(Date) modalityRoomMessage.get("to_date")
        modalityRoom.setDisplayOrder((Integer) modalityRoomMessage.get("display_order"));
        modalityRoom.setMoreInfo(moreInfoMsg);
        modalityRoom.setModalityRoomName((String) modalityRoomMessage.get("modality_room_name"));
        modalityRoom.setModalityRoomCode((String) modalityRoomMessage.get("modality_room_code"));
        modalityRoom.setModalities(modalities);
        modalityRoom.setFacilityId((Integer) modalityRoomMessage.get("facility_id"));
        modalityRoom.setColorCode((String) modalityRoomMessage.get("color_code"));
        modalityRoom.setAllowScheduling((Boolean) modalityRoomMessage.get("allow_scheduling"));
        modalityRoom.setLastaction((String) modalityRoomMessage.get("operationType"));
        modalityRoom.setLastmodified(new Timestamp(System.currentTimeMillis()));
        return modalityRoom;
    }

}
