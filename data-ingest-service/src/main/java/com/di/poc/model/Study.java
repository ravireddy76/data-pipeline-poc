//package com.di.poc.model;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//import java.sql.Timestamp;
//
//
///**
// * Study entity is used to map the data of
// * <p>
// * <i> <b>Table = studies </b> under <br/>
// * <b>Schema = trans_data </b> with in the enterprise application. </i>
// * </p>
// *
// * @author Ravi
// * @CopyRight (C) All rights reserved to Ravi POC World Inc. It's Illegal to reproduce this code.
// */
//@Entity
//@Table(name = "studies", schema = "trans_data")
//@Data
//@NoArgsConstructor
//public class Study {
//
//    @Id
//    @Column(name = "id")
//    private long id;
//
//    @Column(name = "accession_no")
//    private Object accessionNo;
//
//    @Column(name = "application_entity_id")
//    private int applicationEntityId;
//
//    @Column(name = "appointment_type_id")
//    private int appointmentTypeId;
//
//    @Column(name = "approved_dt")
//    private Timestamp approvedDt;
//
//    @Column(name = "arrival_dt")
//    private Timestamp arrivalDt;
//
//    @Column(name = "attorney_provider_id")
//    private int attorneyProviderId;
//
//    @Column(name = "body_part")
//    private Object bodyPart;
//
//    @Column(name = "company_id")
//    private int companyId;
//
//    @Column(name = "cpt_code_id")
//    private int cptCodeId;
//
//    @Column(name = "cpt_codes")
//    private Object cptCodes;
//
//    @Column(name = "createdby")
//    private Object createdby;
//
//    @Column(name = "critical_finding_id")
//    private int criticalFindingId;
//
//    @Column(name = "current_status_waiting_time")
//    private Object currentStatusWaitingTime;
//
//    @Column(name = "dcm_patient_id")
//    private Object dcmPatientId;
//
//    @Column(name = "deleted_dt")
//    private Timestamp deletedDt;
//
//    @Column(name = "department")
//    private Object department;
//
//    @Column(name = "dicom_status")
//    private Timestamp dicomStatus;
//
//    @Column(name = "dicom_study_id")
//    private Object dicomStudyId;
//
//    @Column(name = "dictation_started")
//    private boolean dictationStarted;
//
//    @Column(name = "duration")
//    private int duration;
//
//    @Column(name = "facility_id")
//    private int facilityId;
//
//    @Column(name = "has_locked")
//    private boolean hasLocked;
//
//    @Column(name = "has_unread_dicoms")
//    private boolean hasUnreadDicoms;
//
//    @Column(name = "in_room_dt")
//    private Timestamp inRoomDt;
//
//    @Column(name = "institution")
//    private Object institution;
//
//    @Column(name = "institution_id")
//    private int institutionId;
//
//    @Column(name = "is_mammo_study")
//    private boolean isMammoStudy;
//
//    @Column(name = "is_qc_study")
//    private boolean isQcStudy;
//
//    @Column(name = "isPreOrder")
//    private Object isPreOrder;
//
//    @Column(name = "last_edited_by")
//    private int lastEditedBy;
//
//    @Column(name = "last_edited_dt")
//    private Timestamp lastEditedDt;
//
//    @Column(name = "linked_study_id")
//    private long linkedStudyId;
//
//    @Column(name = "locked_by")
//    private Object lockedBy;
//
//    @Column(name = "locked_dt")
//    private Timestamp lockedDt;
//
//    @Column(name = "marketing_rep")
//    private Object marketingRep;
//
//    @Column(name = "modalities")
//    private Object modalities;
//
//    @Column(name = "Modality")
//    private Object modality;
//
//    @Column(name = "modality_id")
//    private int modalityId;
//
//    @Column(name = "ModalityRooms")
//    private Object modalityRooms;
//
//    @Column(name = "name_phys_reading_study")
//    private Object namePhysReadingStudy;
//
//    @Column(name = "no_of_instances")
//    private int noOfInstances;
//
//    @Column(name = "no_of_series")
//    private int noOfSeries;
//
//    @Column(name = "office")
//    private Object office;
//
//    @Column(name = "order_id")
//    private long orderId;
//
//    @Column(name = "orderingDesc")
//    private Object orderingDesc;
//
//    @Column(name = "orientation")
//    private Object orientation;
//
//    @Column(name = "patient_age")
//    private int patientAge;
//
//    @Column(name = "patient_id")
//    private long patientId;
//
//    @Column(name = "preOrderDays")
//    private Object preOrderDays;
//
//    @Column(name = "priority")
//    private Object priority;
//
//    @Column(name = "procedure_id")
//    private int procedureId;
//
//    @Column(name = "provider_group_id")
//    private int providerGroupId;
//
//    @Column(name = "readDescription")
//    private Object readDescription;
//
//    @Column(name = "reading_physician_id")
//    private int readingPhysicianId;
//
//    @Column(name = "reason_for_study")
//    private Object reasonForStudy;
//
//    @Column(name = "ref_phy_name")
//    private Object refPhyName;
//
//    @Column(name = "refDescription")
//    private Object refDescription;
//
//    @Column(name = "referring_physician_id")
//    private int referringPhysicianId;
//
//    @Column(name = "report_count")
//    private BigDecimal reportCount;
//
//    @Column(name = "row_version")
//    private int rowVersion;
//
//    @Column(name = "rule_id")
//    private long ruleId;
//
//    @Column(name = "schedule_dt")
//    private Timestamp scheduleDt;
//
//    @Column(name = "schedule_hold")
//    private boolean scheduleHold;
//
//    @Column(name = "sde_study")
//    private boolean sdeStudy;
//
//    @Column(name = "signed_ref_doctor_dt")
//    private Timestamp signedRefDoctorDt;
//
//    @Column(name = "stat_level")
//    private int statLevel;
//
//    @Column(name = "station")
//    private Object station;
//
//    @Column(name = "status_last_changed_by")
//    private int statusLastChangedBy;
//
//    @Column(name = "status_last_changed_dt")
//    private Timestamp statusLastChangedDt;
//
//    @Column(name = "study_attributes")
//    private Object studyAttributes;
//
//    @Column(name = "study_created_dt")
//    private Timestamp studyCreatedDt;
//
//    @Column(name = "study_desc")
//    private Object studyDesc;
//
//    @Column(name = "study_description")
//    private Object studyDescription;
//
//    @Column(name = "study_dt")
//    private Timestamp studyDt;
//
//    @Column(name = "study_guid")
//    private Object studyGuid;
//
//    @Column(name = "study_received_dt")
//    private Timestamp studyReceivedDt;
//
//    @Column(name = "study_started")
//    private boolean studyStarted;
//
//    @Column(name = "study_status")
//    private Object studyStatus;
//
//    @Column(name = "study_time")
//    private Object studyTime;
//
//    @Column(name = "study_uid")
//    private Object studyUid;
//
//    @Column(name = "study_uid_received")
//    private Object studyUidReceived;
//
//    @Column(name = "study_unread_dt")
//    private Timestamp studyUnreadDt;
//
//    @Column(name = "tat_level")
//    private int tatLevel;
//
//    @Column(name = "units")
//    private Object units;
//
//    @Column(name = "unlocked_dt")
//    private Timestamp unlockedDt;
//
//}