package com.cdi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.OffsetDateTime;

/**
 * Order entity is used to map the data of
 * <p>
 * <i> <b>Table = news </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "orders", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Order extends BaseEntity {

    @Nationalized
    @Column(name = "aa")
    private String aa;

    @Nationalized
    @Column(name = "appontment_reminder")
    private String appontmentReminder;

    @Nationalized
    @Column(name = "cc_ros")
    private String ccRos;

    @Nationalized
    @Column(name = "cognitive_status")
    private String cognitiveStatus;

    @Column(name = "company_id")
    private int companyId;

    @Nationalized
    @Column(name = "cpt_codes")
    private String cptCodes;

    @Nationalized
    @Column(name = "created_by")
    private String createdBy;

    @Nationalized
    @Column(name = "curent_date")
    private String curentDate;

    @Nationalized
    @Column(name = "deleted_dt")
    private String deletedDt;

    @Nationalized
    @Column(name = "discharge_instructions")
    private String dischargeInstructions;

    @Nationalized
    @Column(name = "dispatch_address")
    private String dispatchAddress;

    @Nationalized
    @Column(name = "dispatch_contact_name")
    private String dispatchContactName;

    @Nationalized
    @Column(name = "dispatch_contact_number")
    private String dispatchContactNumber;

    @Column(name = "duration")
    private int duration;

    @Nationalized
    @Column(name = "emp")
    private String emp;

    @Column(name = "facility_id")
    private int facilityId;

    @Nationalized
    @Column(name = "functional_status")
    private String functionalStatus;

    @Nationalized
    @Column(name = "google_job_id")
    private String googleJobId;

    @Column(name = "has_approved")
    private boolean hasApproved;

    @Column(name = "has_rescheduled")
    private boolean hasRescheduled;

    @Nationalized
    @Column(name = "history_info")
    private String historyInfo;

    @Nationalized
    @Column(name = "icd_codes")
    private String icdCodes;

    @Column(name = "in_hold")
    private boolean inHold;

    @Nationalized
    @Column(name = "is_medication_reconciliation")
    private String isMedicationReconciliation;

    @Nationalized
    @Column(name = "is_pre_order")
    private String isPreOrder;

    @Column(name = "is_quick_appt")
    private boolean isQuickAppt;

    @Nationalized
    @Column(name = "is_quickappt_from")
    private String isQuickapptFrom;

    @Nationalized
    @Column(name = "is_rejected")
    private String isRejected;

    @Nationalized
    @Column(name = "jos")
    private String jos;

    @Nationalized
    @Column(name = "last_mu_updated_by")
    private String lastMuUpdatedBy;

    @Column(name = "LastAction")
    private String lastAction;

    @Column(name = "LastModified")
    private Timestamp lastModified;

    @Nationalized
    @Column(name = "linked_rad_orders")
    private String linkedRadOrders;

    @Column(name = "modality_id")
    private int modalityId;

    @Column(name = "modality_room_id")
    private int modalityRoomId;

    @Nationalized
    @Column(name = "mu_last_updated")
    private OffsetDateTime muLastUpdated;

    @Column(name = "mu_passed")
    private boolean muPassed;

    @Nationalized
    @Column(name = "mu_validation_data")
    private String muValidationData;

    @Nationalized
    @Column(name = "mu_validation_data_clinical_summary")
    private String muValidationDataClinicalSummary;

    @Nationalized
    @Column(name = "mu_validation_data_clinical_summary_applied")
    private String muValidationDataClinicalSummaryApplied;

    @Nationalized
    @Column(name = "mu_validation_data_clinical_summary_updated_date")
    private String muValidationDataClinicalSummaryUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_clinical_summary_user")
    private String muValidationDataClinicalSummaryUser;

    @Nationalized
    @Column(name = "mu_validation_data_family_health_info")
    private String muValidationDataFamilyHealthInfo;

    @Nationalized
    @Column(name = "mu_validation_data_family_health_info_applied")
    private String muValidationDataFamilyHealthInfoApplied;

    @Nationalized
    @Column(name = "mu_validation_data_family_health_info_updated_date")
    private String muValidationDataFamilyHealthInfoUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_family_health_info_user")
    private String muValidationDataFamilyHealthInfoUser;

    @Nationalized
    @Column(name = "mu_validation_data_functional_status")
    private String muValidationDataFunctionalStatus;

    @Nationalized
    @Column(name = "mu_validation_data_functional_status_applied")
    private String muValidationDataFunctionalStatusApplied;

    @Nationalized
    @Column(name = "mu_validation_data_functional_status_updated_date")
    private String muValidationDataFunctionalStatusUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_functional_status_user")
    private String muValidationDataFunctionalStatusUser;

    @Nationalized
    @Column(name = "mu_validation_data_imageresults")
    private String muValidationDataImageresults;

    @Nationalized
    @Column(name = "mu_validation_data_imageresults_applied")
    private String muValidationDataImageresultsApplied;

    @Nationalized
    @Column(name = "mu_validation_data_imageresults_updated_date")
    private String muValidationDataImageresultsUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_imageresults_user")
    private String muValidationDataImageresultsUser;

    @Nationalized
    @Column(name = "mu_validation_data_medrecon")
    private String muValidationDataMedrecon;

    @Nationalized
    @Column(name = "mu_validation_data_medrecon_applied")
    private String muValidationDataMedreconApplied;

    @Nationalized
    @Column(name = "mu_validation_data_medrecon_updated_date")
    private String muValidationDataMedreconUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_medrecon_user")
    private String muValidationDataMedreconUser;

    @Nationalized
    @Column(name = "mu_validation_data_patientallergies")
    private String muValidationDataPatientallergies;

    @Nationalized
    @Column(name = "mu_validation_data_patientallergies_applied")
    private String muValidationDataPatientallergiesApplied;

    @Nationalized
    @Column(name = "mu_validation_data_patientallergies_updated_date")
    private String muValidationDataPatientallergiesUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_patientallergies_user")
    private String muValidationDataPatientallergiesUser;

    @Nationalized
    @Column(name = "mu_validation_data_patientcognitivestatus")
    private String muValidationDataPatientcognitivestatus;

    @Nationalized
    @Column(name = "mu_validation_data_patientcognitivestatus_applied")
    private String muValidationDataPatientcognitivestatusApplied;

    @Nationalized
    @Column(name = "mu_validation_data_patientcognitivestatus_updated_date")
    private String muValidationDataPatientcognitivestatusUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_patientcognitivestatus_user")
    private String muValidationDataPatientcognitivestatusUser;

    @Nationalized
    @Column(name = "mu_validation_data_patientdemographics")
    private String muValidationDataPatientdemographics;

    @Nationalized
    @Column(name = "mu_validation_data_patientdemographics_applied")
    private String muValidationDataPatientdemographicsApplied;

    @Nationalized
    @Column(name = "mu_validation_data_patientdemographics_updated_date")
    private String muValidationDataPatientdemographicsUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_patientdemographics_user")
    private String muValidationDataPatientdemographicsUser;

    @Nationalized
    @Column(name = "mu_validation_data_patientdob")
    private String muValidationDataPatientdob;

    @Nationalized
    @Column(name = "mu_validation_data_patientdob_applied")
    private String muValidationDataPatientdobApplied;

    @Nationalized
    @Column(name = "mu_validation_data_patientdob_updated_date")
    private String muValidationDataPatientdobUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_patientdob_user")
    private String muValidationDataPatientdobUser;

    @Nationalized
    @Column(name = "mu_validation_data_patientedumaterial")
    private String muValidationDataPatientedumaterial;

    @Nationalized
    @Column(name = "mu_validation_data_patientedumaterial_applied")
    private String muValidationDataPatientedumaterialApplied;

    @Nationalized
    @Column(name = "mu_validation_data_patientedumaterial_updated_date")
    private String muValidationDataPatientedumaterialUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_patientedumaterial_user")
    private String muValidationDataPatientedumaterialUser;

    @Nationalized
    @Column(name = "mu_validation_data_patientelectronicaccessvdt")
    private String muValidationDataPatientelectronicaccessvdt;

    @Nationalized
    @Column(name = "mu_validation_data_patientelectronicaccessvdt_applied")
    private String muValidationDataPatientelectronicaccessvdtApplied;

    @Nationalized
    @Column(name = "mu_validation_data_patientelectronicaccessvdt_updated_date")
    private String muValidationDataPatientelectronicaccessvdtUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_patientelectronicaccessvdt_user")
    private String muValidationDataPatientelectronicaccessvdtUser;

    @Nationalized
    @Column(name = "mu_validation_data_patientethnicity")
    private String muValidationDataPatientethnicity;

    @Nationalized
    @Column(name = "mu_validation_data_patientethnicity_applied")
    private String muValidationDataPatientethnicityApplied;

    @Nationalized
    @Column(name = "mu_validation_data_patientethnicity_updated_date")
    private String muValidationDataPatientethnicityUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_patientethnicity_user")
    private String muValidationDataPatientethnicityUser;

    @Nationalized
    @Column(name = "mu_validation_data_patientgender")
    private String muValidationDataPatientgender;

    @Nationalized
    @Column(name = "mu_validation_data_patientgender_applied")
    private String muValidationDataPatientgenderApplied;

    @Nationalized
    @Column(name = "mu_validation_data_patientgender_updated_date")
    private String muValidationDataPatientgenderUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_patientgender_user")
    private String muValidationDataPatientgenderUser;

    @Nationalized
    @Column(name = "mu_validation_data_patientimmunizations")
    private String muValidationDataPatientimmunizations;

    @Nationalized
    @Column(name = "mu_validation_data_patientimmunizations_applied")
    private String muValidationDataPatientimmunizationsApplied;

    @Nationalized
    @Column(name = "mu_validation_data_patientimmunizations_updated_date")
    private String muValidationDataPatientimmunizationsUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_patientimmunizations_user")
    private String muValidationDataPatientimmunizationsUser;

    @Nationalized
    @Column(name = "mu_validation_data_patientlaboratoryresults")
    private String muValidationDataPatientlaboratoryresults;

    @Nationalized
    @Column(name = "mu_validation_data_patientlaboratoryresults_applied")
    private String muValidationDataPatientlaboratoryresultsApplied;

    @Nationalized
    @Column(name = "mu_validation_data_patientlaboratoryresults_updated_date")
    private String muValidationDataPatientlaboratoryresultsUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_patientlaboratoryresults_user")
    private String muValidationDataPatientlaboratoryresultsUser;

    @Nationalized
    @Column(name = "mu_validation_data_patientlaboratorytest")
    private String muValidationDataPatientlaboratorytest;

    @Nationalized
    @Column(name = "mu_validation_data_patientlaboratorytest_applied")
    private String muValidationDataPatientlaboratorytestApplied;

    @Nationalized
    @Column(name = "mu_validation_data_patientlaboratorytest_updated_date")
    private String muValidationDataPatientlaboratorytestUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_patientlaboratorytest_user")
    private String muValidationDataPatientlaboratorytestUser;

    @Nationalized
    @Column(name = "mu_validation_data_patientmedication")
    private String muValidationDataPatientmedication;

    @Nationalized
    @Column(name = "mu_validation_data_patientmedication_applied")
    private String muValidationDataPatientmedicationApplied;

    @Nationalized
    @Column(name = "mu_validation_data_patientmedication_updated_date")
    private String muValidationDataPatientmedicationUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_patientmedication_user")
    private String muValidationDataPatientmedicationUser;

    @Nationalized
    @Column(name = "mu_validation_data_patientname")
    private String muValidationDataPatientname;

    @Nationalized
    @Column(name = "mu_validation_data_patientname_applied")
    private String muValidationDataPatientnameApplied;

    @Nationalized
    @Column(name = "mu_validation_data_patientname_updated_date")
    private String muValidationDataPatientnameUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_patientname_user")
    private String muValidationDataPatientnameUser;

    @Nationalized
    @Column(name = "mu_validation_data_patientpreferredlanguage")
    private String muValidationDataPatientpreferredlanguage;

    @Nationalized
    @Column(name = "mu_validation_data_patientpreferredlanguage_applied")
    private String muValidationDataPatientpreferredlanguageApplied;

    @Nationalized
    @Column(name = "mu_validation_data_patientpreferredlanguage_updated_date")
    private String muValidationDataPatientpreferredlanguageUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_patientpreferredlanguage_user")
    private String muValidationDataPatientpreferredlanguageUser;

    @Nationalized
    @Column(name = "mu_validation_data_patientprescription")
    private String muValidationDataPatientprescription;

    @Nationalized
    @Column(name = "mu_validation_data_patientprescription_applied")
    private String muValidationDataPatientprescriptionApplied;

    @Nationalized
    @Column(name = "mu_validation_data_patientprescription_updated_date")
    private String muValidationDataPatientprescriptionUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_patientprescription_user")
    private String muValidationDataPatientprescriptionUser;

    @Nationalized
    @Column(name = "mu_validation_data_patientproblems")
    private String muValidationDataPatientproblems;

    @Nationalized
    @Column(name = "mu_validation_data_patientproblems_applied")
    private String muValidationDataPatientproblemsApplied;

    @Nationalized
    @Column(name = "mu_validation_data_patientproblems_updated_date")
    private String muValidationDataPatientproblemsUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_patientproblems_user")
    private String muValidationDataPatientproblemsUser;

    @Nationalized
    @Column(name = "mu_validation_data_patientrace")
    private String muValidationDataPatientrace;

    @Nationalized
    @Column(name = "mu_validation_data_patientrace_applied")
    private String muValidationDataPatientraceApplied;

    @Nationalized
    @Column(name = "mu_validation_data_patientrace_updated_date")
    private String muValidationDataPatientraceUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_patientrace_user")
    private String muValidationDataPatientraceUser;

    @Nationalized
    @Column(name = "mu_validation_data_patientsmokingstatus")
    private String muValidationDataPatientsmokingstatus;

    @Nationalized
    @Column(name = "mu_validation_data_patientsmokingstatus_applied")
    private String muValidationDataPatientsmokingstatusApplied;

    @Nationalized
    @Column(name = "mu_validation_data_patientsmokingstatus_updated_date")
    private String muValidationDataPatientsmokingstatusUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_patientsmokingstatus_user")
    private String muValidationDataPatientsmokingstatusUser;

    @Nationalized
    @Column(name = "mu_validation_data_patientsummaryofcare")
    private String muValidationDataPatientsummaryofcare;

    @Nationalized
    @Column(name = "mu_validation_data_patientsummaryofcare_applied")
    private String muValidationDataPatientsummaryofcareApplied;

    @Nationalized
    @Column(name = "mu_validation_data_patientsummaryofcare_updated_date")
    private String muValidationDataPatientsummaryofcareUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_patientsummaryofcare_user")
    private String muValidationDataPatientsummaryofcareUser;

    @Nationalized
    @Column(name = "mu_validation_data_patientsummaryofcareelectronic")
    private String muValidationDataPatientsummaryofcareelectronic;

    @Nationalized
    @Column(name = "mu_validation_data_patientsummaryofcareelectronic_applied")
    private String muValidationDataPatientsummaryofcareelectronicApplied;

    @Nationalized
    @Column(name = "mu_validation_data_patientsummaryofcareelectronic_updated_date")
    private String muValidationDataPatientsummaryofcareelectronicUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_patientsummaryofcareelectronic_user")
    private String muValidationDataPatientsummaryofcareelectronicUser;

    @Nationalized
    @Column(name = "mu_validation_data_patientvitalsigns")
    private String muValidationDataPatientvitalsigns;

    @Nationalized
    @Column(name = "mu_validation_data_patientvitalsigns_applied")
    private String muValidationDataPatientvitalsignsApplied;

    @Nationalized
    @Column(name = "mu_validation_data_patientvitalsigns_updated_date")
    private String muValidationDataPatientvitalsignsUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_patientvitalsigns_user")
    private String muValidationDataPatientvitalsignsUser;

    @Nationalized
    @Column(name = "mu_validation_data_remainder")
    private String muValidationDataRemainder;

    @Nationalized
    @Column(name = "mu_validation_data_remainder_applied")
    private String muValidationDataRemainderApplied;

    @Nationalized
    @Column(name = "mu_validation_data_remainder_updated_date")
    private String muValidationDataRemainderUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_remainder_user")
    private String muValidationDataRemainderUser;

    @Nationalized
    @Column(name = "mu_validation_data_timely_access")
    private String muValidationDataTimelyAccess;

    @Nationalized
    @Column(name = "mu_validation_data_timely_access_applied")
    private String muValidationDataTimelyAccessApplied;

    @Nationalized
    @Column(name = "mu_validation_data_timely_access_updated_date")
    private String muValidationDataTimelyAccessUpdatedDate;

    @Nationalized
    @Column(name = "mu_validation_data_timely_access_user")
    private String muValidationDataTimelyAccessUser;

    @Nationalized
    @Column(name = "oa")
    private String oa;

    @Nationalized
    @Column(name = "order_contact")
    private String orderContact;

    @Nationalized
    @Column(name = "order_guid")
    private String orderGuid;

    @Nationalized
    @Column(name = "order_info")
    private String orderInfo;

    @Nationalized
    @Column(name = "order_info_aa")
    private String orderInfoAa;

    @Nationalized
    @Column(name = "order_info_accident_state")
    private String orderInfoAccidentState;

    @Nationalized
    @Column(name = "order_info_appontmentreminder")
    private String orderInfoAppontmentreminder;

    @Nationalized
    @Column(name = "order_info_authorization_no")
    private String orderInfoAuthorizationNo;

    @Nationalized
    @Column(name = "order_info_cognitivestatus")
    private String orderInfoCognitivestatus;

    @Nationalized
    @Column(name = "order_info_createdby")
    private String orderInfoCreatedby;

    @Nationalized
    @Column(name = "order_info_currentdate")
    private String orderInfoCurrentdate;

    @Nationalized
    @Column(name = "order_info_dischargeInstructions")
    private String orderInfoDischargeInstructions;

    @Nationalized
    @Column(name = "order_info_dispatch_address")
    private String orderInfoDispatchAddress;

    @Nationalized
    @Column(name = "order_info_dispatch_contact_name")
    private String orderInfoDispatchContactName;

    @Nationalized
    @Column(name = "order_info_dispatch_contact_number")
    private String orderInfoDispatchContactNumber;

    @Nationalized
    @Column(name = "order_info_emp")
    private String orderInfoEmp;

    @Nationalized
    @Column(name = "order_info_frequence_code")
    private String orderInfoFrequenceCode;

    @Nationalized
    @Column(name = "order_info_functionalstatus")
    private String orderInfoFunctionalstatus;

    @Nationalized
    @Column(name = "order_info_google_job_id")
    private String orderInfoGoogleJobId;

    @Nationalized
    @Column(name = "order_info_hfrom")
    private String orderInfoHfrom;

    @Nationalized
    @Column(name = "order_info_hto")
    private String orderInfoHto;

    @Nationalized
    @Column(name = "order_info_is_rejected")
    private String orderInfoIsRejected;

    @Nationalized
    @Column(name = "order_info_ismedicationreconciliation")
    private String orderInfoIsmedicationreconciliation;

    @Nationalized
    @Column(name = "order_info_ispreorder")
    private String orderInfoIspreorder;

    @Nationalized
    @Column(name = "order_info_isquickappt_from")
    private String orderInfoIsquickapptFrom;

    @Nationalized
    @Column(name = "order_info_jos")
    private String orderInfoJos;

    @Nationalized
    @Column(name = "order_info_lastmuupdatedby")
    private String orderInfoLastmuupdatedby;

    @Nationalized
    @Column(name = "order_info_oa")
    private String orderInfoOa;

    @Nationalized
    @Column(name = "order_info_ordercontact")
    private String orderInfoOrdercontact;

    @Nationalized
    @Column(name = "order_info_ordering_facility")
    private String orderInfoOrderingFacility;

    @Nationalized
    @Column(name = "order_info_ordering_facility_id")
    private String orderInfoOrderingFacilityId;

    @Nationalized
    @Column(name = "order_info_original_ref")
    private String orderInfoOriginalRef;

    @Nationalized
    @Column(name = "order_info_outsidelab")
    private String orderInfoOutsidelab;

    @Nationalized
    @Column(name = "order_info_patient_age")
    private String orderInfoPatientAge;

    @Nationalized
    @Column(name = "order_info_patientcondition")
    private String orderInfoPatientcondition;

    @Nationalized
    @Column(name = "order_info_patientemail")
    private String orderInfoPatientemail;

    @Nationalized
    @Column(name = "order_info_patientlocation")
    private String orderInfoPatientlocation;

    @Nationalized
    @Column(name = "order_info_patientroom")
    private String orderInfoPatientroom;

    @Nationalized
    @Column(name = "order_info_phy_order_status")
    private String orderInfoPhyOrderStatus;

    @Nationalized
    @Column(name = "order_info_pos")
    private String orderInfoPos;

    @Nationalized
    @Column(name = "order_info_pos_map_code")
    private String orderInfoPosMapCode;

    @Nationalized
    @Column(name = "order_info_pos_type_code")
    private String orderInfoPosTypeCode;

    @Nationalized
    @Column(name = "order_info_priority")
    private String orderInfoPriority;

    @Nationalized
    @Column(name = "order_info_referralno")
    private String orderInfoReferralno;

    @Nationalized
    @Column(name = "order_info_referring_providerloginid")
    private String orderInfoReferringProviderloginid;

    @Nationalized
    @Column(name = "order_info_requestingdate")
    private String orderInfoRequestingdate;

    @Nationalized
    @Column(name = "order_info_roomno")
    private String orderInfoRoomno;

    @Nationalized
    @Column(name = "order_info_source")
    private String orderInfoSource;

    @Nationalized
    @Column(name = "order_info_stat")
    private String orderInfoStat;

    @Nationalized
    @Column(name = "order_info_technologist_name")
    private String orderInfoTechnologistName;

    @Nationalized
    @Column(name = "order_info_transactioncarein")
    private String orderInfoTransactioncarein;

    @Nationalized
    @Column(name = "order_info_transport")
    private String orderInfoTransport;

    @Nationalized
    @Column(name = "order_info_vehicle_name")
    private String orderInfoVehicleName;

    @Nationalized
    @Column(name = "order_info_visit_no")
    private String orderInfoVisitNo;

    @Nationalized
    @Column(name = "order_info_wfrom")
    private String orderInfoWfrom;

    @Nationalized
    @Column(name = "order_info_wto")
    private String orderInfoWto;

    @Nationalized
    @Column(name = "order_source")
    private String orderSource;

    @Nationalized
    @Column(name = "order_status")
    private String orderStatus;

    @Nationalized
    @Column(name = "order_status_desc")
    private String orderStatusDesc;

    @Nationalized
    @Column(name = "order_status_last_changed_by")
    private int orderStatusLastChangedBy;

    @Nationalized
    @Column(name = "order_status_last_changed_dt")
    private OffsetDateTime orderStatusLastChangedDt;

    @Nationalized
    @Column(name = "order_type")
    private String orderType;

    @Nationalized
    @Column(name = "ordered_by")
    private int orderedBy;

    @Nationalized
    @Column(name = "ordered_dt")
    private String orderedDt;

    @Nationalized
    @Column(name = "ordering_facility")
    private String orderingFacility;

    @Nationalized
    @Column(name = "ordering_facility_id")
    private String orderingFacilityId;

    @Nationalized
    @Column(name = "ordering_providers")
    private String orderingProviders;

    @Nationalized
    @Column(name = "patient_age")
    private String patientAge;

    @Nationalized
    @Column(name = "patient_condition")
    private String patientCondition;

    @Nationalized
    @Column(name = "patient_email")
    private String patientEmail;

    @Nationalized
    @Column(name = "patient_id")
    private long patientId;

    @Nationalized
    @Column(name = "patient_location")
    private String patientLocation;

    @Nationalized
    @Column(name = "patient_room")
    private String patientRoom;

    @Nationalized
    @Column(name = "phy_order_status")
    private String phyOrderStatus;

    @Nationalized
    @Column(name = "pos")
    private String pos;

    @Nationalized
    @Column(name = "pos_map_code")
    private String posMapCode;

    @Nationalized
    @Column(name = "pos_type_code")
    private String posTypeCode;

    @Nationalized
    @Column(name = "primary_patient_insurance_id")
    private BigInteger primaryPatientInsuranceId;


    @Column(name = "provider_id")
    private int providerId;

    @Nationalized
    @Column(name = "reading_providers")
    private String readingProviders;

    @Nationalized
    @Column(name = "referral_no")
    private String referralNo;

    @Nationalized
    @Column(name = "referring_provider_ids")
    private String referringProviderIds;

    @Nationalized
    @Column(name = "referring_provider_login_id")
    private String referringProviderLoginId;

    @Nationalized
    @Column(name = "referring_providers")
    private String referringProviders;

    @Nationalized
    @Column(name = "requesting_date")
    private String requestingDate;

    @Nationalized
    @Column(name = "scheduled_date")
    private String scheduledDate;

    @Nationalized
    @Column(name = "scheduled_dt")
    private String scheduledDt;

    @Nationalized
    @Column(name = "secondary_patient_insurance_id")
    private BigInteger secondaryPatientInsuranceId;

    @Nationalized
    @Column(name = "source")
    private String source;

    @Nationalized
    @Column(name = "stat")
    private String stat;

    @Nationalized
    @Column(name = "technologist_id")
    private int technologistId;

    @Nationalized
    @Column(name = "technologist_name")
    private String technologistName;

    @Nationalized
    @Column(name = "tertiary_patient_insurance_id")
    private BigInteger tertiaryPatientInsuranceId;

    @Nationalized
    @Column(name = "transaction_care_in")
    private String transactionCareIn;

    @Nationalized
    @Column(name = "transport")
    private String transport;

    @Nationalized
    @Column(name = "vehicle_id")
    private int vehicleId;

    @Nationalized
    @Column(name = "vehicle_name")
    private String vehicleName;

    @Column(name = "visit_no")
    private String visitNo;

}