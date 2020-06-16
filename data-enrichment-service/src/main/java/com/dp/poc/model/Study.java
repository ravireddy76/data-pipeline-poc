//package com.dp.poc.model;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//import java.sql.Timestamp;
//import java.sql.Array;
//
///**
// * Study entity is used to map the data of
// * <p>
// * <i> <b>Table = studies </b> under <br/>
// * <b>Schema = poc_catalog </b> with in the enterprise application. </i>
// * </p>
// *
// * @author Ravi
// * @CopyRight (C) All rights reserved to Ravi POC World Inc. It's Illegal to reproduce this code.
// */
//@Entity
//@Table(name = "studies", schema = "poc_catalog")
//@Data
//@NoArgsConstructor
//public class Study {
//
//    @Id
//    @Column(name = "id")
//    private Integer id;
//
//    @Column(name = "accession_no")
//    private String accessionNo;
//
//    @Column(name = "annotations")
//    private Object annotations;
//
//    @Column(name = "application_entity_id")
//    private Integer applicationEntityId;
//
//    @Column(name = "appointment_type_id")
//    private Integer appointmentTypeId;
//
//    @Column(name = "approved_dt")
//    private Timestamp approvedDt;
//
//    @Column(name = "arrival_dt")
//    private Timestamp arrivalDt;
//
//    @Column(name = "attorney_provider_id")
//    private Integer attorneyProviderId;
//
//    @Column(name = "body_part")
//    private String bodyPart;
//
//    @Column(name = "company_id")
//    private Integer companyId;
//
//    @Column(name = "cpt_code_id")
//    private Integer cptCodeId;
//
//    @Column(name = "cpt_codes")
//    private Array cptCodes;
//
//    @Column(name = "critical_finding_id")
//    private Integer criticalFindingId;
//
//    @Column(name = "dcm_patient_id")
//    private String dcmPatientId;
//
//    @Column(name = "deleted_dt")
//    private Timestamp deletedDt;
//
//    @Column(name = "department")
//    private String department;
//
//    @Column(name = "dicom_status")
//    private String dicomStatus;
//
//    @Column(name = "dicom_study_id")
//    private String dicomStudyId;
//
//    @Column(name = "dictation_started")
//    private Boolean dictationStarted;
//
//    @Column(name = "duration")
//    private Integer duration;
//
//    @Column(name = "facility_id")
//    private Integer facilityId;
//
//    @Column(name = "has_locked")
//    private Boolean hasLocked;
//
//    @Column(name = "has_unread_dicoms")
//    private Boolean hasUnreadDicoms;
//
//    @Column(name = "in_room_dt")
//    private Timestamp inRoomDt;
//
//    @Column(name = "institution")
//    private String institution;
//
//    @Column(name = "institution_id")
//    private Integer institutionId;
//
//    @Column(name = "is_mammo_study")
//    private Boolean isMammoStudy;
//
//    @Column(name = "is_qc_study")
//    private Boolean isQcStudy;
//
//    @Column(name = "last_edited_by")
//    private Integer lastEditedBy;
//
//    @Column(name = "last_edited_dt")
//    private Timestamp lastEditedDt;
//
//    @Column(name = "linked_study_id")
//    private Long linkedStudyId;
//
//    @Column(name = "locked_by")
//    private String lockedBy;
//
//    @Column(name = "locked_dt")
//    private Timestamp lockedDt;
//
//    @Column(name = "modalities")
//    private String modalities;
//
//    @Column(name = "modality_id")
//    private Integer modalityId;
//
//    @Column(name = "no_of_instances")
//    private Integer noOfInstances;
//
//    @Column(name = "no_of_series")
//    private Integer noOfSeries;
//
//    @Column(name = "order_id")
//    private Long orderId;
//
//    @Column(name = "orientation")
//    private String orientation;
//
//    @Column(name = "patient_age")
//    private Integer patientAge;
//
//    @Column(name = "patient_id")
//    private Long patientId;
//
//    @Column(name = "priority")
//    private String priority;
//
//    @Column(name = "procedure_id")
//    private Integer procedureId;
//
//    @Column(name = "provider_group_id")
//    private Integer providerGroupId;
//
//    @Column(name = "reading_physician_id")
//    private Integer readingPhysicianId;
//
//    @Column(name = "reason_for_study")
//    private String reasonForStudy;
//
//    @Column(name = "referring_physician_id")
//    private Integer referringPhysicianId;
//
//    @Column(name = "report_count")
//    private BigDecimal reportCount;
//
//    @Column(name = "row_version")
//    private Integer rowVersion;
//
//    @Column(name = "rule_id")
//    private Long ruleId;
//
//    @Column(name = "schedule_dt")
//    private Timestamp scheduleDt;
//
//    @Column(name = "schedule_hold")
//    private Boolean scheduleHold;
//
//    @Column(name = "sde_study")
//    private Boolean sdeStudy;
//
//    @Column(name = "signed_ref_doctor_dt")
//    private Timestamp signedRefDoctorDt;
//
//    @Column(name = "stat_level")
//    private Integer statLevel;
//
//    @Column(name = "status_last_changed_by")
//    private Integer statusLastChangedBy;
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
//    @Column(name = "study_description")
//    private String studyDescription;
//
//    @Column(name = "study_details")
//    private Object studyDetails;
//
//    @Column(name = "study_dt")
//    private Timestamp studyDt;
//
//    @Column(name = "study_guid")
//    private String studyGuid;
//
//    @Column(name = "study_info")
//    private Object studyInfo;
//
//    @Column(name = "study_received_dt")
//    private Timestamp studyReceivedDt;
//
//    @Column(name = "study_started")
//    private Boolean studyStarted;
//
//    @Column(name = "study_status")
//    private String studyStatus;
//
//    @Column(name = "study_uid")
//    private String studyUid;
//
//    @Column(name = "study_uid_received")
//    private String studyUidReceived;
//
//    @Column(name = "study_unread_dt")
//    private Timestamp studyUnreadDt;
//
//    @Column(name = "tat_level")
//    private Integer tatLevel;
//
//    @Column(name = "unlocked_dt")
//    private Timestamp unlockedDt;
//
//    @Column(name = "viewer_series_link_info")
//    private Object viewerSeriesLinkInfo;
//
//    @Column(name = "viewer_stack_link_info")
//    private Object viewerStackLinkInfo;
//
//}