package com.cdi.di.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Facility entity is used to map the data of
 * <p>
 * <i> <b>Table = companies </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "companies", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Company extends BaseEntity {

    @Nationalized
    @Column(name="acc_info")
    private String accInfo;

    @Nationalized
    @Column(name="acc_info_prefix")
    private String accInfoPrefix;

    @Nationalized
    @Column(name="acc_info_preview")
    private String accInfoPreview;

    @Nationalized
    @Column(name="acc_info_suffix")
    private String accInfoSuffix;

    @Nationalized
    @Column(name="ae_institution_filter")
    private String aeInstitutionFilter;

    @Nationalized
    @Column(name="ae_ip_filter")
    private String aeIpFilter;

    @Nationalized
    @Column(name="ae_title_filter")
    private String aeTitleFilter;

    @Nationalized
    @Column(name="app_cancel_reasons")
    private String appCancelReasons;

    @Nationalized
    @Column(name="app_followup_reasons")
    private String appFollowupReasons;

    @Nationalized
    @Column(name="app_followup_reasons_follow_up_reason")
    private String appFollowupReasonsFollowUpReason;

    @Nationalized
    @Column(name="app_scan_document_types")
    private String appScanDocumentTypes;

    @Nationalized
    @Column(name="app_states")
    private String appStates;

    @Nationalized
    @Column(name="billing_info")
    private String billingInfo;

    @Nationalized
    @Column(name="billing_info_corporate_type")
    private String billingInfoCorporateType;

    @Nationalized
    @Column(name="billing_info_edi_billing_npi")
    private String billingInfoEdiBillingNpi;

    @Nationalized
    @Column(name="billing_info_edi_edi_receiver_id")
    private String billingInfoEdiEdiReceiverId;

    @Nationalized
    @Column(name="billing_info_edi_modifiers_in_order")
    private String billingInfoEdiModifiersInOrder;

    @Nationalized
    @Column(name="billing_info_edi_submitter_id")
    private String billingInfoEdiSubmitterId;

    @Nationalized
    @Column(name="billing_info_edi_taxonomy_code")
    private String billingInfoEdiTaxonomyCode;

    @Nationalized
    @Column(name="billing_info_icd9To10")
    private String billingInfoIcd9To10;

    @Nationalized
    @Column(name="billing_info_tax_id")
    private String billingInfoTaxId;

    @Nationalized
    @Column(name="company_code")
    private String companyCode;

    @Nationalized
    @Column(name="company_info")
    private String companyInfo;

    @Nationalized
    @Column(name="company_info_company_address1")
    private String companyInfoCompanyAddress1;

    @Nationalized
    @Column(name="company_info_company_address2")
    private String companyInfoCompanyAddress2;

    @Nationalized
    @Column(name="company_info_company_city")
    private String companyInfoCompanyCity;

    @Nationalized
    @Column(name="company_info_company_contactNo")
    private String companyInfoCompanyContactNo;

    @Nationalized
    @Column(name="company_info_company_email")
    private String companyInfoCompanyEmail;

    @Nationalized
    @Column(name="company_info_company_portal_info")
    private String companyInfoCompanyPortalInfo;

    @Nationalized
    @Column(name="company_info_company_state")
    private String companyInfoCompanyState;

    @Nationalized
    @Column(name="company_info_company_website")
    private String companyInfoCompanyWebsite;

    @Nationalized
    @Column(name="company_info_company_zip")
    private String companyInfoCompanyZip;

    @Nationalized
    @Column(name="company_info_country")
    private String companyInfoCountry;

    @Nationalized
    @Column(name="company_info_id")
    private String companyInfoId;

    @Nationalized
    @Column(name="company_name")
    private String companyName;

    @Nationalized
    @Column(name="deleted_dt")
    private String deletedDt;

    @Nationalized
    @Column(name="document_review_config")
    private String documentReviewConfig;

    @Nationalized
    @Column(name="document_review_config_lo")
    private String documentReviewConfigLo;

    @Nationalized
    @Column(name="document_review_config_lo_name")
    private String documentReviewConfigLoName;

    @Nationalized
    @Column(name="document_review_config_lo_requires_review")
    private String documentReviewConfigLoRequiresReview;

    @Nationalized
    @Column(name="document_review_config_lr")
    private String documentReviewConfigLr;

    @Nationalized
    @Column(name="document_review_config_lr_name")
    private String documentReviewConfigLrName;

    @Nationalized
    @Column(name="document_review_config_lr_requires_review")
    private String documentReviewConfigLrRequiresReview;

    @Nationalized
    @Column(name="document_review_config_pa")
    private String documentReviewConfigPa;

    @Nationalized
    @Column(name="document_review_config_pa_name")
    private String documentReviewConfigPaName;

    @Nationalized
    @Column(name="document_review_config_pa_requires_review")
    private String documentReviewConfigPaRequiresReview;

    @Nationalized
    @Column(name="document_review_config_pd")
    private String documentReviewConfigPd;

    @Nationalized
    @Column(name="document_review_config_pd_name")
    private String documentReviewConfigPdName;

    @Nationalized
    @Column(name="document_review_config_pd_requires_review")
    private String documentReviewConfigPdRequiresReview;

    @Nationalized
    @Column(name="document_review_config_pm")
    private String documentReviewConfigPm;

    @Nationalized
    @Column(name="document_review_config_pm_name")
    private String documentReviewConfigPmName;

    @Nationalized
    @Column(name="document_review_config_pm_requires_review")
    private String documentReviewConfigPmRequiresReview;

    @Nationalized
    @Column(name="document_review_config_pp")
    private String documentReviewConfigPp;

    @Nationalized
    @Column(name="document_review_config_pp_name")
    private String documentReviewConfigPpName;

    @Nationalized
    @Column(name="document_review_config_pp_requires_review")
    private String documentReviewConfigPpRequiresReview;

    @Nationalized
    @Column(name="email_config")
    private String emailConfig;

    @Nationalized
    @Column(name="email_config_from_address")
    private String emailConfigFromAddress;

    @Nationalized
    @Column(name="email_config_password")
    private String emailConfigPassword;

    @Nationalized
    @Column(name="email_config_port")
    private String emailConfigPort;

    @Nationalized
    @Column(name="email_config_smtpserver")
    private String emailConfigSmtpserver;

    @Nationalized
    @Column(name="email_config_subject")
    private String emailConfigSubject;

    @Nationalized
    @Column(name="email_config_username")
    private String emailConfigUsername;

    @Column(name="enable_flag_routing_trigger")
    private boolean enableFlagRoutingTrigger;

    @Column(name="enable_ldap")
    private boolean enableLdap;

    @Column(name="enable_payment_gateway")
    private boolean enablePaymentGateway;

    @Column(name="enable_rcopia")
    private boolean enableRcopia;

    @Column(name="file_store_id")
    private int fileStoreId;

    @Nationalized
    @Column(name="hl7_config")
    private String hl7Config;

    @Nationalized
    @Column(name="hl7_receiver_facilities")
    private String hl7ReceiverFacilities;

    @Column(name="LastAction")
    private String lastAction;

    @Column(name="LastModified")
    private Timestamp lastModified;

    @Nationalized
    @Column(name="ldap_config")
    private String ldapConfig;

    @Nationalized
    @Column(name="ldap_config_allowcaching")
    private String ldapConfigAllowcaching;

    @Nationalized
    @Column(name="ldap_config_dn")
    private String ldapConfigDn;

    @Nationalized
    @Column(name="ldap_config_domainname")
    private String ldapConfigDomainname;

    @Nationalized
    @Column(name="ldap_config_impersonate")
    private String ldapConfigImpersonate;

    @Nationalized
    @Column(name="ldap_config_imppassword")
    private String ldapConfigImppassword;

    @Nationalized
    @Column(name="ldap_config_impusername")
    private String ldapConfigImpusername;

    @Nationalized
    @Column(name="ldap_config_ldappassword")
    private String ldapConfigLdappassword;

    @Nationalized
    @Column(name="ldap_config_ldapusername")
    private String ldapConfigLdapusername;

    @Nationalized
    @Column(name="ldap_config_server")
    private String ldapConfigServer;

    @Nationalized
    @Column(name="ldap_config_slicedqueries")
    private String ldapConfigSlicedqueries;

    @Nationalized
    @Column(name="ldap_config_usernameprefix")
    private String ldapConfigUsernameprefix;

    @Nationalized
    @Column(name="ldap_config_usernamessuffix")
    private String ldapConfigUsernamessuffix;

    @Nationalized
    @Column(name="mrn_info")
    private String mrnInfo;

    @Nationalized
    @Column(name="mrn_info_allow_duplicates")
    private String mrnInfoAllowDuplicates;

    @Nationalized
    @Column(name="mrn_info_can_edit")
    private String mrnInfoCanEdit;

    @Nationalized
    @Column(name="mrn_info_current_index")
    private String mrnInfoCurrentIndex;

    @Nationalized
    @Column(name="mrn_info_fieldLength")
    private String mrnInfoFieldLength;

    @Nationalized
    @Column(name="mrn_info_is_fixed_length")
    private String mrnInfoIsFixedLength;

    @Nationalized
    @Column(name="mrn_info_mrn_type")
    private String mrnInfoMrnType;

    @Nationalized
    @Column(name="mrn_info_prefix")
    private String mrnInfoPrefix;

    @Nationalized
    @Column(name="mrn_info_preview")
    private String mrnInfoPreview;

    @Nationalized
    @Column(name="mrn_info_start_from")
    private String mrnInfoStartFrom;

    @Nationalized
    @Column(name="mrn_info_suffix")
    private String mrnInfoSuffix;

    @Nationalized
    @Column(name="mu_cognitive_status")
    private String muCognitiveStatus;

    @Nationalized
    @Column(name="mu_functional_status")
    private String muFunctionalStatus;

    @Nationalized
    @Column(name="password_mgt")
    private String passwordMgt;

    @Nationalized
    @Column(name="payment_gateway_info")
    private String paymentGatewayInfo;

    @Nationalized
    @Column(name="peer_review_config")
    private String peerReviewConfig;

    @Nationalized
    @Column(name="peer_review_config_frequency")
    private String peerReviewConfigFrequency;

    @Nationalized
    @Column(name="rcopia_info")
    private String rcopiaInfo;

    @Nationalized
    @Column(name="rcopia_info_ans_url1")
    private String rcopiaInfoAnsUrl1;

    @Nationalized
    @Column(name="rcopia_info_ans_url2")
    private String rcopiaInfoAnsUrl2;

    @Nationalized
    @Column(name="rcopia_info_application_name")
    private String rcopiaInfoApplicationName;

    @Nationalized
    @Column(name="rcopia_info_application_version")
    private String rcopiaInfoApplicationVersion;

    @Nationalized
    @Column(name="rcopia_info_notification_itnerval")
    private String rcopiaInfoNotificationItnerval;

    @Nationalized
    @Column(name="rcopia_info_rcopia_user_id")
    private String rcopiaInfoRcopiaUserId;

    @Nationalized
    @Column(name="rcopia_info_save_request_files")
    private String rcopiaInfoSaveRequestFiles;

    @Nationalized
    @Column(name="rcopia_info_save_response_files")
    private String rcopiaInfoSaveResponseFiles;

    @Nationalized
    @Column(name="rcopia_info_transaction_interval")
    private String rcopiaInfoTransactionInterval;

    @Nationalized
    @Column(name="scan_document_types")
    private String scanDocumentTypes;

    @Nationalized
    @Column(name="scan_document_types_scan_document_type")
    private String scanDocumentTypesScanDocumentType;

    @Nationalized
    @Column(name="sys_config")
    private String sysConfig;

    @Nationalized
    @Column(name="sys_config_sys_body_parts")
    private String sysConfigSysBodyParts;

    @Nationalized
    @Column(name="sys_config_sys_credentials")
    private String sysConfigSysCredentials;

    @Nationalized
    @Column(name="sys_config_sys_death_reason")
    private String sysConfigSysDeathReason;

    @Nationalized
    @Column(name="sys_config_sys_ethnicity")
    private String sysConfigSysEthnicity;

    @Nationalized
    @Column(name="sys_config_sys_gender")
    private String sysConfigSysGender;

    @Nationalized
    @Column(name="sys_config_sys_languages")
    private String sysConfigSysLanguages;

    @Nationalized
    @Column(name="sys_config_sys_marital_status")
    private String sysConfigSysMaritalStatus;

    @Nationalized
    @Column(name="sys_config_sys_orientation")
    private String sysConfigSysOrientation;

    @Nationalized
    @Column(name="sys_config_sys_priorities")
    private String sysConfigSysPriorities;

    @Nationalized
    @Column(name="sys_config_sys_racial_identity")
    private String sysConfigSysRacialIdentity;

    @Nationalized
    @Column(name="sys_config_sys_sources")
    private String sysConfigSysSources;

    @Nationalized
    @Column(name="sys_config_sys_specialties")
    private String sysConfigSysSpecialties;

    @Nationalized
    @Column(name="sys_config_sys_studyflag")
    private String sysConfigSysStudyflag;

    @Nationalized
    @Column(name="sys_config_sys_transportation")
    private String sysConfigSysTransportation;

    @Nationalized
    @Column(name="sys_config_sys_user_titles")
    private String sysConfigSysUserTitles;

    @Nationalized
    @Column(name="sys_config_sys_veterinary")
    private String sysConfigSysVeterinary;

    @Nationalized
    @Column(name="sys_config_viewer_sys_administration_site")
    private String sysConfigViewerSysAdministrationSite;

    @Nationalized
    @Column(name="sys_config_viewer_sys_communication_preferences")
    private String sysConfigViewerSysCommunicationPreferences;

    @Nationalized
    @Column(name="sys_config_viewer_titlebar_text")
    private String sysConfigViewerTitlebarText;

    @Nationalized
    @Column(name="time_zone")
    private String timeZone;
}
