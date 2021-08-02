package com.cdi.di.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Facility entity is used to map the data of
 * <p>
 * <i> <b>Table = facilities </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "facilities", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Facility extends BaseEntity {

    @Nationalized
    @Column(name = "arrival_status_code")
    private String arrivalStatusCode;

    @Column(name = "company_id")
    private int companyId;

    @Nationalized
    @Column(name = "deleted_dt")
    private String deletedDt;

    @Column(name = "enable_veterinary")
    private boolean enableVeterinary;

    @Nationalized
    @Column(name = "facility_code")
    private String facilityCode;

    // @Nationalized
    @Column(name = "facility_info")
    private String facilityInfo;

    @Nationalized
    @Column(name = "facility_info_abbreviated_receipt")
    private String facilityInfoAbbreviatedReceipt;

    @Nationalized
    @Column(name = "facility_info_auth_requester_id")
    private String facilityInfoAuthRequesterId;

    @Nationalized
    @Column(name = "facility_info_benefit_on_date")
    private String facilityInfoBenefitOnDate;

    @Nationalized
    @Column(name = "facility_info_customreceiptenabled")
    private String facilityInfoCustomReceiptEnabled;

    @Nationalized
    @Column(name = "facility_info_display_date")
    private String facilityInfoDisplayDate;

    @Nationalized
    @Column(name = "facility_info_eligibility_receiver_id")
    private String facilityInfoEligibilityReceiverId;

    @Nationalized
    @Column(name = "facility_info_enable_alt_account_no")
    private String facilityInfoEnableAltAccountNo;

    @Nationalized
    @Column(name = "facility_info_enable_insurance_claims")
    private String facilityInfoEnableInsuranceClaims;

    @Nationalized
    @Column(name = "facility_info_enable_insurance_eligibility")
    private String facilityInfoEnableInsuranceEligibility;

    @Nationalized
    @Column(name = "facility_info_enable_manual_checkout")
    private String facilityInfoEnableManualCheckout;

    @Nationalized
    @Column(name = "facility_info_exam_prep_required")
    private String facilityInfoExamPrepRequired;

    @Nationalized
    @Column(name = "facility_info_facility_address1")
    private String facilityInfoFacilityAddress1;

    @Nationalized
    @Column(name = "facility_info_facility_address2")
    private String facilityInfoFacilityAddress2;

    @Nationalized
    @Column(name = "facility_info_facility_autofax")
    private String facilityInfoFacilityAutofax;

    @Nationalized
    @Column(name = "facility_info_facility_city")
    private String facilityInfoFacilityCity;

    @Nationalized
    @Column(name = "facility_info_facility_contactno")
    private String facilityInfoFacilityContactNo;

    @Nationalized
    @Column(name = "facility_info_facility_country")
    private String facilityInfoFacilityCountry;

    @Nationalized
    @Column(name = "facility_info_facility_email")
    private String facilityInfoFacilityEmail;

    @Nationalized
    @Column(name = "facility_info_facility_emailattachment")
    private String facilityInfoFacilityEmailAttachment;

    @Nationalized
    @Column(name = "facility_info_facility_emaillink")
    private String facilityInfoFacilityEmailLink;

    @Nationalized
    @Column(name = "facility_info_facility_emailpassword")
    private String facilityInfoFacilityEmailPassword;

    @Nationalized
    @Column(name = "facility_info_facility_faxno")
    private String facilityInfoFacilityFaxNo;

    @Nationalized
    @Column(name = "facility_info_facility_inherit")
    private String facilityInfoFacilityInherit;

    @Nationalized
    @Column(name = "facility_info_facility_mammolicenseid")
    private String facilityInfoFacilityMammoLicenseId;

    @Nationalized
    @Column(name = "facility_info_facility_state")
    private String facilityInfoFacilityState;

    @Nationalized
    @Column(name = "facility_info_facility_website")
    private String facilityInfoFacilityWebsite;

    @Nationalized
    @Column(name = "facility_info_facility_zip")
    private String facilityInfoFacilityZip;

    @Nationalized
    @Column(name = "facility_info_federal_tax_id")
    private String facilityInfoFederalTaxId;

    @Nationalized
    @Column(name = "facility_info_global_auto_print")
    private String facilityInfoGlobalAutoPrint;

    @Nationalized
    @Column(name = "facility_info_global_auto_printer")
    private String facilityInfoGlobalAutoPrinter;

    @Nationalized
    @Column(name = "facility_info_import_docs_into_dicoms")
    private String facilityInfoImportDocsIntoDicoms;

    @Nationalized
    @Column(name = "facility_info_mobiledispatchingaddress")
    private String facilityInfoMobileDispatchingAddress;

    @Nationalized
    @Column(name = "facility_info_modality_display_width")
    private String facilityInfoModalityDisplayWidth;

    @Nationalized
    @Column(name = "facility_info_npino")
    private String facilityInfoNpiNo;

    @Nationalized
    @Column(name = "facility_info_pay_to_provider_id")
    private String facilityInfoPayToProviderId;

    @Nationalized
    @Column(name = "facility_info_pokitdok_response")
    private String facilityInfoPokitdokResponse;

    @Nationalized
    @Column(name = "facility_info_posonalways")
    private String facilityInfoPosonalways;

    @Nationalized
    @Column(name = "facility_info_primary_phys_required")
    private String facilityInfoPrimaryPhysRequired;

    @Nationalized
    @Column(name = "facility_info_receiptaddress1")
    private String facilityInfoReceiptAddress1;

    @Nationalized
    @Column(name = "facility_info_receiptaddress2")
    private String facilityInfoReceiptAddress2;

    @Nationalized
    @Column(name = "facility_info_receiptcity")
    private String facilityInfoReceiptCity;

    @Nationalized
    @Column(name = "facility_info_receiptcontactno")
    private String facilityInfoReceiptContactNo;

    @Nationalized
    @Column(name = "facility_info_receiptcountry")
    private String facilityInfoReceiptCountry;

    @Nationalized
    @Column(name = "facility_info_receiptfax")
    private String facilityInfoReceiptFax;

    @Nationalized
    @Column(name = "facility_info_receiptname")
    private String facilityInfoReceiptName;

    @Nationalized
    @Column(name = "facility_info_receiptstate")
    private String facilityInfoReceiptState;

    @Nationalized
    @Column(name = "facility_info_receiptzip")
    private String facilityInfoReceiptZip;

    @Nationalized
    @Column(name = "facility_info_rendering_provider_id")
    private String facilityInfoRenderingProviderId;

    @Nationalized
    @Column(name = "facility_info_restrictdoublebooking")
    private String facilityInfoRestrictDoubleBooking;

    @Nationalized
    @Column(name = "facility_info_service_facility_id")
    private String facilityInfoServiceFacilityId;

    @Nationalized
    @Column(name = "facility_info_service_facility_name")
    private String facilityInfoServiceFacilityName;

    @Nationalized
    @Column(name = "facility_info_show_patient_alerts")
    private String facilityInfoShowPatientAlerts;

    @Nationalized
    @Column(name = "facility_info_show_recent_schedules")
    private String facilityInfoShowRecentSchedules;

    @Nationalized
    @Column(name = "facility_info_show_schedules_days")
    private String facilityInfoShowSchedulesDays;

    @Nationalized
    @Column(name = "facility_info_show_studies")
    private String facilityInfoShowStudies;

    @Nationalized
    @Column(name = "facility_info_ssn_required")
    private String facilityInfoSsnRequired;

    @Nationalized
    @Column(name = "facility_info_submitter_id")
    private String facilityInfoSubmitterId;

    @Nationalized
    @Column(name = "facility_info_updox_account")
    private String facilityInfoUpdoxAccount;

    @Nationalized
    @Column(name = "facility_info_updox_send_fax")
    private String facilityInfoUpdoxSendFax;

    @Nationalized
    @Column(name = "facility_name")
    private String facilityName;

    @Column(name = "fee_schedule_id")
    private long feeScheduleId;

    @Column(name = "file_store_id")
    private int fileStoreId;

    @Nationalized
    @Column(name = "in_room_status_code")
    private String inRoomStatusCode;

    @Column(name = "is_active")
    private boolean activeStatus;

    //@Nationalized
    @Column(name = "lastaction")
    private String lastAction;

    @Column(name = "lastmodified")
    private Timestamp lastModified;

    @Column(name = "max_tat")
    private short maxTat;

    // @Nationalized
    @Column(name = "mrn_info")
    private String mrnInfo;

    @Nationalized
    @Column(name = "mrn_info_allow_duplicates")
    private String mrnInfoAllowDuplicates;

    @Nationalized
    @Column(name = "mrn_info_can_edit")
    private String mrnInfoCanEdit;

    @Nationalized
    @Column(name = "mrn_info_current_index")
    private String mrnInfoCurrentIndex;

    @Nationalized
    @Column(name = "mrn_info_field_length")
    private String mrnInfoFieldLength;

    @Nationalized
    @Column(name = "mrn_info_is_fixed_length")
    private String mrnInfoIsFixedLength;

    @Nationalized
    @Column(name = "mrn_info_mrn_type")
    private String mrnInfoMrnType;

    @Nationalized
    @Column(name = "mrn_info_prefix")
    private String mrnInfoPrefix;

    @Nationalized
    @Column(name = "mrn_info_preview")
    private String mrnInfoPreview;

    @Nationalized
    @Column(name = "mrn_info_start_from")
    private String mrnInfoStartFrom;

    @Nationalized
    @Column(name = "mrn_info_suffix")
    private String mrnInfoSuffix;

    @Nationalized
    @Column(name = "mu_validation_fields")
    private String muValidationFields;

    @Column(name = "place_of_service_id")
    private long placeOfServiceId;

    //@Nationalized
    @Column(name = "study_workflow_locations")
    private String studyWorkflowLocations;

    @Nationalized
    @Column(name = "time_zone")
    private String timeZone;

}
