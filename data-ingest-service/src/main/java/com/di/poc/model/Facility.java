//package com.di.poc.model;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.sql.Timestamp;
//
//
///**
// * Facility entity is used to map the data of
// * <p>
// * <i> <b>Table = facilities </b> under <br/>
// * <b>Schema = poc_catalog </b> with in the enterprise application. </i>
// * </p>
// *
// * @author Ravi
// * @CopyRight (C) All rights reserved to Ravi POC World Inc. It's Illegal to reproduce this code.
// */
//@Entity
//@Table(name = "facilities", schema = "trans_data")
//@Data
//@NoArgsConstructor
//public class Facility {
//
//    @Id
//    @Column(name = "id")
//    private int id;
//
//    @Column(name = "abbreviated_receipt")
//    private Object abbreviatedReceipt;
//
//    @Column(name = "arrival_status_code")
//    private String arrivalStatusCode;
//
//    @Column(name = "auth_requester_id")
//    private Object authRequesterId;
//
//    @Column(name = "benefit_on_date")
//    private Object benefitOnDate;
//
//    @Column(name = "company_id")
//    private int companyId;
//
//    @Column(name = "customReceiptEnabled")
//    private Object customReceiptEnabled;
//
//    @Column(name = "deleted_dt")
//    private Timestamp deletedDt;
//
//    @Column(name = "display_date")
//    private Object displayDate;
//
//    @Column(name = "eligibility_receiver_id")
//    private Object eligibilityReceiverId;
//
//    @Column(name = "enable_alt_account_no")
//    private Object enableAltAccountNo;
//
//    @Column(name = "enable_insurance_claims")
//    private Object enableInsuranceClaims;
//
//    @Column(name = "enable_insurance_eligibility")
//    private Object enableInsuranceEligibility;
//
//    @Column(name = "enable_manual_checkout")
//    private Object enableManualCheckout;
//
//    @Column(name = "enable_veterinary")
//    private boolean enableVeterinary;
//
//    @Column(name = "exam_prep_required")
//    private Object examPrepRequired;
//
//    @Column(name = "facility_address1")
//    private Object facilityAddress1;
//
//    @Column(name = "facility_address2")
//    private Object facilityAddress2;
//
//	@Column(name = "facility_autoFax")
//    private Object facility_autoFax;
//
//    @Column(name = "facility_city")
//    private Object facilityCity;
//
//    @Column(name = "facility_code")
//    private Object facilityCode;
//
//    @Column(name = "facility_contactNo")
//    private Object facility_contactNo;
//
//    @Column(name = "facility_country")
//    private Object facilityCountry;
//
//    @Column(name = "facility_email")
//    private Object facilityEmail;
//
//    @Column(name = "facility_emailAttachment")
//    private Object facility_emailAttachment;
//
//    @Column(name = "facility_emailLink")
//    private Object facility_emailLink;
//
//    @Column(name = "facility_emailPassword")
//    private Object facility_emailPassword;
//
//    @Column(name = "facility_faxNo")
//    private Object facility_faxNo;
//
//    @Column(name = "facility_inherit")
//    private Object facilityInherit;
//
//    @Column(name = "facility_mammoLicenseId")
//    private Object facility_mammoLicenseId;
//
//    @Column(name = "facility_name")
//    private Object facilityName;
//
//    @Column(name = "facility_state")
//    private Object facilityState;
//
//    @Column(name = "facility_website")
//    private Object facilityWebsite;
//
//    @Column(name = "facility_zip")
//    private Object facilityZip;
//
//    @Column(name = "federal_tax_id")
//    private Object federalTaxId;
//
//    @Column(name = "fee_schedule_id")
//    private long feeScheduleId;
//
//    @Column(name = "file_store_id")
//    private int fileStoreId;
//
//    @Column(name = "global_auto_print")
//    private Object globalAutoPrint;
//
//    @Column(name = "global_auto_printer")
//    private Object globalAutoPrinter;
//
//    @Column(name = "import_docs_into_dicoms")
//    private Object importDocsIntoDicoms;
//
//    @Column(name = "in_room_status_code")
//    private String inRoomStatusCode;
//
//    @Column(name = "is_active")
//    private boolean isActive;
//
//    @Column(name = "max_tat")
//    private short maxTat;
//
//    @Column(name = "mobileDispatchingAddress")
//    private Object mobileDispatchingAddress;
//
//    @Column(name = "modality_display_width")
//    private Object modalityDisplayWidth;
//
//    @Column(name = "mrn_info")
//    private Object mrnInfo;
//
//    @Column(name = "mu_validation_fields")
//    private Object muValidationFields;
//
//    @Column(name = "npino")
//    private Object npino;
//
//    @Column(name = "pay_to_provider_id")
//    private Object payToProviderId;
//
//    @Column(name = "place_of_service_id")
//    private long placeOfServiceId;
//
//    @Column(name = "pokitdok_response")
//    private Object pokitdokResponse;
//
//    @Column(name = "posOnAlways")
//    private Object posOnAlways;
//
//    @Column(name = "primary_phys_required")
//    private Object primaryPhysRequired;
//
//    @Column(name = "receiptAddress1")
//    private Object receiptAddress1;
//
//    @Column(name = "receiptAddress2")
//    private Object receiptAddress2;
//
//    @Column(name = "receiptCity")
//    private Object receiptCity;
//
//    @Column(name = "receiptCity")
//    private Object receiptContactNo;
//
//    @Column(name = "receiptCountry")
//    private Object receiptCountry;
//
//    @Column(name = "receiptFax")
//    private Object receiptFax;
//
//    @Column(name = "receiptName")
//    private Object receiptName;
//
//    @Column(name = "receiptState")
//    private Object receiptState;
//
//    @Column(name = "receiptZip")
//    private Object receiptZip;
//
//    @Column(name = "rendering_provider_id")
//    private Object renderingProviderId;
//
//    @Column(name = "restrictDoubleBooking")
//    private Object restrictDoubleBooking;
//
//    @Column(name = "service_facility_id")
//    private Object serviceFacilityId;
//
//    @Column(name = "service_facility_name")
//    private Object serviceFacilityName;
//
//    @Column(name = "show_patient_alerts")
//    private Object showPatientAlerts;
//
//    @Column(name = "show_recent_schedules")
//    private Object showRecentSchedules;
//
//    @Column(name = "show_schedules_days")
//    private Object showSchedulesDays;
//
//    @Column(name = "show_studies")
//    private Object showStudies;
//
//    @Column(name = "ssn_required")
//    private Object ssnRequired;
//
//    @Column(name = "study_workflow_locations")
//    private Object studyWorkflowLocations;
//
//    @Column(name = "submitter_id")
//    private Object submitterId;
//
//    @Column(name = "time_zone")
//    private Object timeZone;
//
//    @Column(name = "updox_account")
//    private Object updoxAccount;
//
//    @Column(name = "updox_send_fax")
//    private Object updoxSendFax;
//
//}