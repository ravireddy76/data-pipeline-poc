package com.cdi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.OffsetDateTime;

/**
 * Study entity is used to map the data of
 * <p>
 * <i> <b>Table = studies </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "studies", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Study extends BaseEntity {

    @Nationalized
    @Column(name = "accession_no")
    private String accessionNo;

    @Nationalized
    @Column(name = "annotations")
    private String annotations;

    @Column(name = "application_entity_id")
    private int applicationEntityId;

    @Column(name = "appointment_type_id")
    private int appointmentTypeId;

    @Column(name = "approved_dt")
    private OffsetDateTime approvedDt;

    @Column(name = "arrival_dt")
    private OffsetDateTime arrivalDt;

    @Column(name = "attorney_provider_id")
    private int attorneyProviderId;

    @Nationalized
    @Column(name = "body_part")
    private String bodyPart;

    @Column(name = "company_id")
    private int companyId;

    @Column(name = "cpt_code_id")
    private int cptCodeId;

    @Nationalized
    @Column(name = "cpt_codes")
    private String cptCodes;

    @Column(name = "critical_finding_id")
    private int criticalFindingId;

    @Nationalized
    @Column(name = "dcm_patient_id")
    private String dcmPatientId;

    @Column(name = "deleted_dt")
    private OffsetDateTime deletedDt;

    @Nationalized
    @Column(name = "department")
    private String department;

    @Nationalized
    @Column(name = "dicom_status")
    private String dicomStatus;

    @Nationalized
    @Column(name = "dicom_study_id")
    private String dicomStudyId;

    @Column(name = "dictation_started")
    private boolean dictationStarted;

    @Column(name = "duration")
    private int duration;

    @Column(name = "facility_id")
    private int facilityId;

    @Column(name = "has_locked")
    private boolean hasLocked;

    @Column(name = "has_unread_dicoms")
    private boolean hasUnreadDicoms;

    @Column(name = "in_room_dt")
    private OffsetDateTime inRoomDt;

    private String institution;

    @Column(name = "institution_id")
    private int institutionId;

    @Column(name = "is_mammo_study")
    private boolean isMammoStudy;

    @Column(name = "is_qc_study")
    private boolean isQcStudy;

    @Column(name = "last_edited_by")
    private int lastEditedBy;

    @Column(name = "last_edited_dt")
    private OffsetDateTime lastEditedDt;

    @Column(name = "lastaction")
    private String lastAction;

    @Column(name = "lastmodified")
    private Timestamp lastModified;

    @Column(name = "linked_study_id")
    private long linkedStudyId;

    @Nationalized
    @Column(name = "locked_by")
    private String lockedBy;

    @Column(name = "locked_dt")
    private OffsetDateTime lockedDt;

    @Nationalized
    @Column(name = "modalities")
    private String modalities;

    @Column(name = "modality_id")
    private int modalityId;

    @Column(name = "no_of_instances")
    private int noOfInstances;

    @Column(name = "no_of_series")
    private int noOfSeries;

    @Column(name = "order_id")
    private long orderId;

    @Nationalized
    @Column(name = "orientation")
    private String orientation;

    @Column(name = "patient_age")
    private int patientAge;

    @Column(name = "patient_id")
    private long patientId;

    @Nationalized
    @Column(name = "priority")
    private String priority;

    @Column(name = "procedure_id")
    private int procedureId;

    @Column(name = "provider_group_id")
    private int providerGroupId;

    @Column(name = "reading_physician_id")
    private int readingPhysicianId;

    @Nationalized
    @Column(name = "reason_for_study")
    private String reasonForStudy;

    @Column(name = "referring_physician_id")
    private int referringPhysicianId;

    @Column(name = "report_count")
    private BigDecimal reportCount;

    @Column(name = "row_version")
    private int rowVersion;

    @Column(name = "rule_id")
    private long ruleId;

    @Column(name = "schedule_dt")
    private OffsetDateTime scheduleDt;

    @Column(name = "schedule_hold")
    private boolean scheduleHold;

    @Column(name = "sde_study")
    private boolean sdeStudy;

    @Column(name = "signed_ref_doctor_dt")
    private OffsetDateTime signedRefDoctorDt;

    @Column(name = "stat_level")
    private int statLevel;

    @Column(name = "status_last_changed_by")
    private int statusLastChangedBy;

    @Column(name = "status_last_changed_dt")
    private OffsetDateTime statusLastChangedDt;

    @Nationalized
    @Column(name = "study_attributes")
    private String studyAttributes;

    @Column(name = "study_created_dt")
    private OffsetDateTime studyCreatedDt;

    @Nationalized
    @Column(name = "study_description")
    private String studyDescription;

    @Nationalized
    @Column(name = "study_details")
    private String studyDetails;

    @Nationalized
    @Column(name = "study_details_accession_no")
    private String studyDetailsAccessionNo;

    @Nationalized
    @Column(name = "study_details_admitting_diagnoses_desc")
    private String studyDetailsAdmittingDiagnosesDesc;

    @Nationalized
    @Column(name = "study_details_dicom_patient_id")
    private String studyDetailsDicomPatientId;

    @Nationalized
    @Column(name = "study_details_dicom_study_id")
    private String studyDetailsDicomStudyId;

    @Nationalized
    @Column(name = "study_details_institution")
    private String studyDetailsInstitution;

    private String study_details_isPreOrder;

    @Nationalized
    @Column(name = "study_details_manu_mod_name")
    private String studyDetailsManuModName;

    @Nationalized
    @Column(name = "study_details_manufacturer")
    private String studyDetailsManufacturer;

    @Nationalized
    @Column(name = "study_details_modality")
    private String studyDetailsModality;

    @Nationalized
    @Column(name = "study_details_name_phys_reading_study")
    private String studyDetailsNamePhysReadingStudy;

    @Nationalized
    @Column(name = "study_details_num_instances")
    private String studyDetailsNumInstances;

    @Nationalized
    @Column(name = "study_details_patients_age")
    private String studyDetailsPatientsAge;

    @Nationalized
    @Column(name = "study_details_protocol_name")
    private String studyDetailsProtocolName;

    @Nationalized
    @Column(name = "study_details_ref_phy_name")
    private String studyDetailsRefPhyName;

    @Nationalized
    @Column(name = "study_details_series_no")
    private String studyDetailsSeriesNo;

    @Nationalized
    @Column(name = "study_details_station")
    private String studyDetailsStation;

    @Nationalized
    @Column(name = "study_details_study_desc")
    private String studyDetailsStudyDesc;

    @Column(name = "study_details_study_dt")
    private OffsetDateTime studyDetailsStudyDt;

    @Nationalized
    @Column(name = "study_details_study_time")
    private String studyDetailsStudyTime;

    @Nationalized
    @Column(name = "study_details_study_uid")
    private String studyDetailsStudyUid;

    @Column(name = "study_dt")
    private OffsetDateTime studyDt;

    @Nationalized
    @Column(name = "study_guid")
    private String studyGuid;

    @Nationalized
    @Column(name = "study_info")
    private String studyInfo;

    @Nationalized
    @Column(name = "study_info_accession_no")
    private String studyInfoAccessionNo;

    @Nationalized
    @Column(name = "study_info_ae_title")
    private String studyInfoAeTitle;

    @Nationalized
    @Column(name = "study_info_api_request_id")
    private String studyInfoApiRequestId;

    @Nationalized
    @Column(name = "study_info_api_version")
    private String studyInfoApiVersion;

    private String study_info_ApprovedBy;

    private String study_info_ApprovedDt;

    @Nationalized
    @Column(name = "study_info_approving_doctor")
    private String studyInfoApprovingDoctor;

    @Nationalized
    @Column(name = "study_info_approving_doctor_id")
    private String studyInfoApprovingDoctorId;

    @Nationalized
    @Column(name = "study_info_birth_date")
    private String studyInfoBirthDate;

    private String study_info_Check_InBy;

    private String study_info_Check_InDt;

    @Nationalized
    @Column(name = "study_info_company_id")
    private String studyInfoCompanyId;

    @Nationalized
    @Column(name = "study_info_conflict_reason")
    private String studyInfoConflictReason;

    @Nationalized
    @Column(name = "study_info_createdby")
    private String studyInfoCreatedby;

    @Nationalized
    @Column(name = "study_info_current_status_waiting_time")
    private String studyInfoCurrentStatusWaitingTime;

    @Nationalized
    @Column(name = "study_info_department")
    private String studyInfoDepartment;

    @Nationalized
    @Column(name = "study_info_dicom_study_id")
    private String studyInfoDicomStudyId;

    private String study_info_DraftedBy;

    private String study_info_DraftedDt;

    @Nationalized
    @Column(name = "study_info_first_name")
    private String studyInfoFirstName;

    @Nationalized
    @Column(name = "study_info_full_name")
    private String studyInfoFullName;

    @Nationalized
    @Column(name = "study_info_gender")
    private String studyInfoGender;

    @Nationalized
    @Column(name = "study_info_has_processed")
    private String studyInfoHasProcessed;

    private String study_info_IncompleteBy;

    private String study_info_IncompleteDt;

    @Nationalized
    @Column(name = "study_info_instittion")
    private String studyInfoInstittion;

    @Nationalized
    @Column(name = "study_info_institution")
    private String studyInfoInstitution;

    @Nationalized
    @Column(name = "study_info_is_pacs_study")
    private String studyInfoIsPacsStudy;

    @Nationalized
    @Column(name = "study_info_is_signed_by_doctor")
    private String studyInfoIsSignedByDoctor;

    private String study_info_isPreOrder;

    @Nationalized
    @Column(name = "study_info_issuer_id")
    private String studyInfoIssuerId;

    @Nationalized
    @Column(name = "study_info_last_name")
    private String studyInfoLastName;

    @Nationalized
    @Column(name = "study_info_marketing_rep")
    private String studyInfoMarketingRep;

    @Nationalized
    @Column(name = "study_info_middle_name")
    private String studyInfoMiddleName;

    private String study_info_Modality;

    private String study_info_ModalityRooms;

    @Nationalized
    @Column(name = "study_info_no_of_instances")
    private String studyInfoNoOfInstances;

    @Nationalized
    @Column(name = "study_info_no_of_series")
    private String studyInfoNoOfSeries;

    @Nationalized
    @Column(name = "study_info_no_of_stacks")
    private String studyInfoNoOfStacks;

    private String study_info_Office;

    private String study_info_orderingDesc;

    @Nationalized
    @Column(name = "study_info_patients_age")
    private String studyInfoPatientsAge;

    @Nationalized
    @Column(name = "study_info_phy_order_status")
    private String studyInfoPhyOrderStatus;

    private String study_info_preOrderDays;

    @Nationalized
    @Column(name = "study_info_qc_upgraded")
    private String studyInfoQcUpgraded;

    private String study_info_readDescription;

    private String study_info_refDescription;

    @Nationalized
    @Column(name = "study_info_sde_study")
    private String studyInfoSdeStudy;

    @Nationalized
    @Column(name = "study_info_signed_ref_phy_id")
    private String studyInfoSignedRefPhyId;

    @Nationalized
    @Column(name = "study_info_sr_type")
    private String studyInfoSrType;

    @Nationalized
    @Column(name = "study_info_station")
    private String studyInfoStation;

    @Nationalized
    @Column(name = "study_info_study_description")
    private String studyInfoStudyDescription;

    @Column(name = "study_info_study_dt")
    private OffsetDateTime studyInfoStudyDt;

    @Nationalized
    @Column(name = "study_info_study_flag")
    private String studyInfoStudyFlag;

    private String study_info_Tech_StartBy;

    private String study_info_Tech_StartDt;

    @Nationalized
    @Column(name = "study_info_temp_patient_id")
    private String studyInfoTempPatientId;

    @Nationalized
    @Column(name = "study_info_units")
    private String studyInfoUnits;

    private String study_info_UnreadBy;

    private String study_info_UnreadDt;

    @Nationalized
    @Column(name = "study_info_upgraded_from_qc1")
    private String studyInfoUpgradedFromQc1;

    @Nationalized
    @Column(name = "study_info_was_stat")
    private String studyInfoWasStat;

    @Column(name = "study_received_dt")
    private OffsetDateTime studyReceivedDt;

    @Column(name = "study_started")
    private boolean studyStarted;

    @Nationalized
    @Column(name = "study_status")
    private String studyStatus;

    @Nationalized
    @Column(name = "study_uid")
    private String studyUid;

    @Nationalized
    @Column(name = "study_uid_received")
    private String studyUidReceived;

    @Column(name = "study_unread_dt")
    private OffsetDateTime studyUnreadDt;

    @Column(name = "tat_level")
    private int tatLevel;

    @Column(name = "unlocked_dt")
    private OffsetDateTime unlockedDt;

    @Nationalized
    @Column(name = "viewer_series_link_info")
    private String viewerSeriesLinkInfo;

    @Nationalized
    @Column(name = "viewer_stack_link_info")
    private String viewerStackLinkInfo;

}
