package com.cdi.pa.di.service;


import com.cdi.domain.model.Order;
import com.cdi.domain.model.OrderNotes;
import com.cdi.domain.model.PatientAltNames;
import com.cdi.domain.model.Study;
import com.cdi.domain.repository.DataRepository;
import com.cdi.domain.util.AppUtils;
import com.cdi.domain.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/**
 * ClinicalActivityService class used to consume message from kafka topics and ingest data into
 * target tables in MS SQL server.
 *
 * @author Temam G.
 * @CopyRight (C) All rights reserved to CDI Inc. It's Illegal to reproduce this code.
 */
@Service
@Slf4j
public class ClinicalActivityService {


    @Autowired
    private DataRepository dataRepository;

    /**
     * Method to listen studies and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_studies}") //Works fine
    public void studiesListener(@Payload String messagePayload) throws Exception {
        log.info("ClinicalActivityService:studiesListener::Message: {}", messagePayload);

        /* Build the studies from kafka message. */
        Map<String, Object> studiesMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        Study study = buildStudy(studiesMessage);

        /* Save or persist the data into the table. */
        dataRepository.save(study);
        log.info("Study is Saved/Updated for the id: {} ", study.getId());
    }

    /**
     * Method to listen order notes and save the information.
     *
     * @param messagePayload
     * @throws Exception
     */
    @KafkaListener(topics = "${topic.t_order_notes}") // Works fine
    public void orderNotesListener(@Payload String messagePayload) throws Exception {
        log.info("ClinicalActivityService:orderNotesListener::Message: {}", messagePayload);

        /* Build the order notes from kafka message. */
        Map<String, Object> orderNotesMessage = JsonUtils.deserializeJson(Map.class, messagePayload);
        OrderNotes orderNotes = buildOrderNotes(orderNotesMessage);

        /* Save or persist the data into the table. */
        dataRepository.save(orderNotes);
        log.info("Order Notes is Saved/Updated for the id: {} ", orderNotes.getId());
    }

    /**
     * Method to map and save Study information.
     *
     * @param studiesMessage
     * @return Order
     * @throws Exception
     */
    private Study buildStudy(Map<String, Object> studiesMessage) throws Exception {
        Study study = new Study();
        OffsetDateTime lastEditedDt = AppUtils.convertToOffSetDateTime((String) studiesMessage.get("last_edited_dt"));
        OffsetDateTime scheduleDt = AppUtils.convertToOffSetDateTime((String) studiesMessage.get("schedule_dt"));
        OffsetDateTime studyCreatedDt = AppUtils.convertToOffSetDateTime((String) studiesMessage.get("study_created_dt"));
        OffsetDateTime studyDt = AppUtils.convertToOffSetDateTime((String) studiesMessage.get("study_dt"));
        OffsetDateTime approvedDt = AppUtils.convertToOffSetDateTime((String) studiesMessage.get("approved_dt"));
        OffsetDateTime statusLastChangedDt = AppUtils.convertToOffSetDateTime((String) studiesMessage.get("status_last_changed_dt"));
        long orderId = new Long((Integer) studiesMessage.get("order_id")).longValue();
        long patientId = new Long((Integer) studiesMessage.get("patient_id")).longValue();
        long id = new Long((Integer) studiesMessage.get("id")).longValue();

        study.setId(id);
//        study.setLastEditedDt(lastEditedDt);
        study.setScheduleDt(scheduleDt);
        study.setProcedureId((Integer) studiesMessage.get("procedure_id"));
        study.setTatLevel((Integer) studiesMessage.get("tat_level"));
        study.setStudyCreatedDt(studyCreatedDt);
        study.setAccessionNo((String) studiesMessage.get("accession_no"));
        study.setStudyStatus((String) studiesMessage.get("study_status"));
        study.setDuration((Integer) studiesMessage.get("duration"));
        study.setInstitution((String) studiesMessage.get("institution"));
        study.setModalities((String) studiesMessage.get("modalities"));
        study.setReasonForStudy((String) studiesMessage.get("reason_for_study"));
        study.setDicomStudyId((String) studiesMessage.get("dicom_study_id"));
        study.setDicomStatus((String) studiesMessage.get("dicom_status"));
        study.setModalityId((Integer) studiesMessage.get("modality_id"));
        study.setFacilityId((Integer) studiesMessage.get("facility_id"));

//        study.setScheduleHold((boolean) studiesMessage.get("schedule_hold"));
        study.setStudyInfo((String) studiesMessage.get("study_info"));
        study.setPatientAge((Integer) studiesMessage.get("patient_age"));
        study.setStudyDt(studyDt);
        study.setStudyDetails((String) studiesMessage.get("study_details"));
        study.setBodyPart((String) studiesMessage.get("body_part"));
        study.setHasUnreadDicoms((boolean) studiesMessage.get("has_unread_dicoms"));
//        study.setCptCodes((String) studiesMessage.get("cpt_codes"));
        study.setNoOfInstances((Integer) studiesMessage.get("no_of_instances"));
        study.setAppointmentTypeId((Integer) studiesMessage.get("appointment_type_id"));
        study.setProviderGroupId((Integer) studiesMessage.get("provider_group_id"));
        study.setOrientation((String) studiesMessage.get("orientation"));
        study.setStudyUid((String) studiesMessage.get("study_uid"));
        study.setCompanyId((Integer) studiesMessage.get("company_id"));

        study.setStudyDescription((String) studiesMessage.get("study_description"));
        study.setPriority((String) studiesMessage.get("priority"));
        study.setStudyStarted((boolean) studiesMessage.get("study_started"));
        study.setReadingPhysicianId((Integer) studiesMessage.get("reading_physician_id"));
        study.setStatusLastChangedBy((Integer) studiesMessage.get("status_last_changed_by"));
        study.setDictationStarted((boolean) studiesMessage.get("dictation_started"));
//        study.setApprovedDt(approvedDt);
        study.setPatientId(patientId);
        study.setStatusLastChangedDt(statusLastChangedDt);
        study.setStatLevel((Integer) studiesMessage.get("stat_level"));
//        study.setLastEditedBy((Integer) studiesMessage.get("last_edited_by"));
        study.setOrderId(orderId);
        study.setBodyPart((String) studiesMessage.get("body_part"));
        study.setLastAction((String) studiesMessage.get("operationType"));
        study.setLastModified(new Timestamp(System.currentTimeMillis()));


        /* Populate the study Info and study info data information. */
        buildStudyInfo(study, studiesMessage);
        buildStudyDetails(study, studiesMessage);

        return study;
    }

    /**
     * Method to map and save Order Notes information.
     *
     * @param orderNotesMessage
     * @return Order
     * @throws Exception
     */
    private OrderNotes buildOrderNotes(Map<String, Object> orderNotesMessage) throws Exception {
        OrderNotes orderNotes = new OrderNotes();
        String createdDtData = (String) orderNotesMessage.get("created_dt");
        Integer createdIdData = (Integer) orderNotesMessage.get("order_id");
        Integer createdByData = (Integer) orderNotesMessage.get("created_by");
        OffsetDateTime createdDt = AppUtils.convertToOffSetDateTime(createdDtData);
        long id = new Long((Integer) orderNotesMessage.get("id")).longValue();

        orderNotes.setId(id);
        orderNotes.setNote((String) orderNotesMessage.get("note"));
        orderNotes.setCreatedDt(createdDt);
        orderNotes.setCreatedBy(BigInteger.valueOf(createdByData));
        orderNotes.setOrderId(BigInteger.valueOf(createdIdData));
        orderNotes.setCreatedByPatient((boolean) orderNotesMessage.get("is_created_by_patient"));

        return orderNotes;
    }



    /**
     * Method to build or populate the study info information.
     *
     * @param study
     * @param studiesMessage
     * @throws Exception
     */
    private void buildStudyInfo(Study study, Map<String, Object> studiesMessage) throws IOException {
        String studyInfoMessage = (String) studiesMessage.get("study_info");
        Map studyInfoData = JsonUtils.deserializeJson(Map.class, studyInfoMessage);

        study.setStudy_info_Office(studyInfoData.get("Office").toString());
//        study.setStudy_info_PausedBy(studyInfoData.get("PausedBy").toString());
        study.setStudyInfoApprovingDoctorId(studyInfoData.get("approving_doctor_id").toString());
//        study.setStudyInfoPauseReason(studyInfoData.get("PauseReason").toString());
        study.setStudy_info_IncompleteDt(studyInfoData.get("IncompleteDt").toString());
        study.setStudy_info_orderingDesc(studyInfoData.get("orderingDesc").toString());
        study.setStudy_info_UnreadDt(studyInfoData.get("UnreadDt").toString());

//        study.setStudyInfoDictatedDt(studyInfoData.get("DictatedDt").toString());
        study.setStudy_info_Tech_StartDt(studyInfoData.get("Tech StartDt").toString());
        study.setStudyInfoUnits(studyInfoData.get("units").toString());
        study.setStudyInfoAccessionNo(studyInfoData.get("accession_no").toString());
//        study.setStudy_Info_DictatedBy(studyInfoData.get("DictatedBy").toString());
        study.setStudy_info_Tech_StartBy(studyInfoData.get("Tech StartB").toString());
        study.setStudyInfoSdeStudy(studyInfoData.get("sde_study").toString());
//        study.setStudyInfoConfirmedBy(studyInfoData.get("ConfirmedBy").toString());
//        study.setStudyInfoTranscribedBy(studyInfoData.get("TranscribedBy").toString());
        study.setStudyInfoSignedRefPhyId(studyInfoData.get("signed_ref_phy_id").toString());
        study.setStudyInfoInstitution(studyInfoData.get("institution").toString());

        study.setStudyInfoCreatedby(studyInfoData.get("createdby").toString());
//        study.setStudyInfoConfirmedDt(studyInfoData.get("ConfirmedDt").toString());
        study.setStudyInfoStation(studyInfoData.get("study_info_station").toString());
        study.setStudy_info_Check_InBy(studyInfoData.get("Check-InBy").toString());

        study.setStudy_info_readDescription(studyInfoData.get("readDescription").toString());
//        study.setStudyInfoScheduledDt(studyInfoData.get("ScheduledDt").toString());
        study.setStudyInfoDepartment(studyInfoData.get("department").toString());
        study.setStudy_info_isPreOrder(studyInfoData.get("isPreOrder").toString());
        study.setStudy_info_IncompleteBy(studyInfoData.get("IncompleteBy").toString());
        study.setStudyInfoApprovingDoctor(studyInfoData.get("approving_doctor").toString());
        study.setStudy_info_Check_InDt(studyInfoData.get("Check-InDt").toString());
//        study.setStudyInfoScheduledBy(studyInfoData.get("ScheduledBy").toString());
        study.setStudyInfoMarketingRep(studyInfoData.get("marketing_rep").toString());
        study.setStudyInfoCurrentStatusWaitingTime(studyInfoData.get("current_status_waiting_time").toString());

//        study.setStudyInfoRescheduledDt(studyInfoData.get("RescheduledDt").toString());
        study.setStudyInfoStudyDescription(studyInfoData.get("study_description").toString());
        study.setStudy_info_ModalityRooms(studyInfoData.get("ModalityRooms").toString());
        study.setStudy_info_UnreadBy(studyInfoData.get("UnreadBy").toString());
        study.setStudy_info_refDescription(studyInfoData.get("refDescription").toString());
        study.setStudy_info_ApprovedBy(studyInfoData.get("ApprovedBy").toString());
//        study.setStudyInfoTranscribedDt(studyInfoData.get("TranscribedDt").toString());
        study.setStudyInfoIsSignedByDoctor(studyInfoData.get("is_signed_by_doctor").toString());
//        study.setStudyInfoPausedDt(studyInfoData.get("PausedDt").toString());
        study.setStudyInfoPhyOrderStatus(studyInfoData.get("phy_order_status").toString());
        study.setStudyInfoWasStat(studyInfoData.get("was_stat").toString());
        study.setStudy_info_Modality(studyInfoData.get("Modality").toString());
//        study.setStudyInfoRescheduledBy(studyInfoData.get("RescheduledBy").toString());
        study.setStudy_info_ApprovedDt(studyInfoData.get("ApprovedDt").toString());
        study.setStudy_info_preOrderDays(studyInfoData.get("preOrderDays").toString());

    }

    private void buildStudyDetails(Study study, Map<String, Object> studiesMessage) throws Exception {
        String studyDetailsMessage = (String) studiesMessage.get("study_details");
        Map studyDetailsData = JsonUtils.deserializeJson(Map.class, studyDetailsMessage);
        OffsetDateTime studyDt = AppUtils.convertToOffSetDateTime((String) studiesMessage.get("study_dt"));

        study.setStudy_details_isPreOrder(studyDetailsData.get("isPreOrder").toString());
        study.setStudyDetailsAccessionNo(studyDetailsData.get("accession_no").toString());
        study.setStudyDetailsRefPhyName(studyDetailsData.get("ref_phy_name").toString());
        study.setStudyDetailsModality(studyDetailsData.get("modality").toString());
        study.setStudyDetailsStudyDesc(studyDetailsData.get("study_desc").toString());
        study.setStudyDetailsStudyDt(studyDt);
        study.setStudyDetailsStudyTime(studyDetailsData.get("study_time").toString());
        study.setStudyDetailsNamePhysReadingStudy(studyDetailsData.get("name_phys_reading_study").toString());
        study.setStudyDetailsPatientsAge(studyDetailsData.get("patients_age").toString());

    }
}
