package com.cdi.di.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.OffsetDateTime;

/**
 * Patient entity is used to map the data of
 * <p>
 * <i> <b>Table = patients </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "patients", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Patient extends BaseEntity {

    @Nationalized
    @Column(name = "account_no")
    private String accountNo;

    @Nationalized
    @Column(name = "account_no_history")
    private String accountNoHistory;

    @Nationalized
    @Column(name = "account_no_history_acc")
    private String accountNoHistoryAcc;

    @Nationalized
    @Column(name = "account_no_history_createdby")
    private String accountNoHistoryCreatedby;

    @Nationalized
    @Column(name = "account_no_history_createddt")
    private String accountNoHistoryCreateddt;

    @Nationalized
    @Column(name = "alert_note")
    private String alertNote;

    @Nationalized
    @Column(name = "alt_account_no")
    private String altAccountNo;

    @Nationalized
    @Column(name = "birth_date")
    private String birthDate;

    @Nationalized
    @Column(name = "checkin_code")
    private String checkinCode;

    @Column(name = "checkin_code_created_dt")
    private OffsetDateTime checkinCodeCreatedDt;

    @Column(name = "company_id")
    private int companyId;

    @Column(name = "created_dt")
    private OffsetDateTime createdDt;

    @Column(name = "deleted_dt")
    private OffsetDateTime deletedDt;

    @Nationalized
    @Column(name = "dicom_patient_id")
    private String dicomPatientId;

    @Column(name = "employment_status_id")
    private BigInteger employmentStatusId;

    @Column(name = "facility_id")
    private int facilityId;

    @Nationalized
    @Column(name = "first_name")
    private String firstName;

    @Nationalized
    @Column(name = "full_name")
    private String fullName;

    @Nationalized
    @Column(name = "gender")
    private String gender;

    @Column(name = "hie_consent_id")
    private int hieConsentId;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "is_vip")
    private boolean isVip;

    @Column(name = "last_edit_by")
    private int lastEditBy;

    @Column(name = "last_edit_dt")
    private OffsetDateTime lastEditDt;

    @Nationalized
    @Column(name = "last_name")
    private String lastName;

    @Nationalized
    @Column(name = "LastAction")
    private String lastAction;

    @Column(name = "LastModified")
    private Timestamp lastModified;

    @Nationalized
    @Column(name = "middle_name")
    private String middleName;

    @Nationalized
    @Column(name = "ordering_facilities")
    private String orderingFacilities;

    @Column(name = "owner_id")
    private BigInteger ownerId;

    @Nationalized
    @Column(name = "patient_details")
    private String patientDetails;

    @Nationalized
    @Column(name = "patient_details_birth_date")
    private String patientDetailsBirthDate;

    @Nationalized
    @Column(name = "patient_details_dicom_patient_id")
    private String patientDetailsDicomPatientId;

    @Nationalized
    @Column(name = "patient_details_first_name")
    private String patientDetailsFirstName;

    @Nationalized
    @Column(name = "patient_details_patient_name")
    private String patientDetailsPatientName;

    @Nationalized
    @Column(name = "patient_details_patient_sex")
    private String patientDetailsPatientSex;

    @Nationalized
    @Column(name = "patient_info")
    private String patientInfo;

    @Nationalized
    @Column(name = "patient_info_accountno")
    private String patientInfoAccountno;

    @Nationalized
    @Column(name = "patient_info_alt")
    private String patientInfoAlt;

    @Nationalized
    @Column(name = "patient_info_c1addressline1")
    private String patientInfoC1addressline1;

    @Nationalized
    @Column(name = "patient_info_c1addressline2")
    private String patientInfoC1addressline2;

    @Nationalized
    @Column(name = "patient_info_c1city")
    private String patientInfoC1city;

    @Nationalized
    @Column(name = "patient_info_c1country")
    private String patientInfoC1country;

    @Nationalized
    @Column(name = "patient_info_c1email")
    private String patientInfoC1email;

    @Nationalized
    @Column(name = "patient_info_c1homephone")
    private String patientInfoC1homephone;

    @Nationalized
    @Column(name = "patient_info_c1mobilephone")
    private String patientInfoC1mobilephone;

    @Nationalized
    @Column(name = "patient_info_c1state")
    private String patientInfoC1state;

    @Nationalized
    @Column(name = "patient_info_c1workphone")
    private String patientInfoC1workphone;

    @Nationalized
    @Column(name = "patient_info_c1zip")
    private String patientInfoC1zip;

    @Nationalized
    @Column(name = "patient_info_c2addressline1")
    private String patientInfoC2addressline1;

    @Nationalized
    @Column(name = "patient_info_c2addressline2")
    private String patientInfoC2addressline2;

    @Nationalized
    @Column(name = "patient_info_c2city")
    private String patientInfoC2city;

    @Nationalized
    @Column(name = "patient_info_c2country")
    private String patientInfoC2country;

    @Nationalized
    @Column(name = "patient_info_c2email")
    private String patientInfoC2email;

    @Nationalized
    @Column(name = "patient_info_c2homephone")
    private String patientInfoC2homephone;

    @Nationalized
    @Column(name = "patient_info_c2mobilephone")
    private String patientInfoC2mobilephone;

    @Nationalized
    @Column(name = "patient_info_c2state")
    private String patientInfoC2state;

    @Nationalized
    @Column(name = "patient_info_c2workphone")
    private String patientInfoC2workphone;

    @Nationalized
    @Column(name = "patient_info_c2zip")
    private String patientInfoC2zip;

    @Nationalized
    @Column(name = "patient_info_commpref")
    private String patientInfoCommpref;

    @Nationalized
    @Column(name = "patient_info_deathreason")
    private String patientInfoDeathreason;

    @Nationalized
    @Column(name = "patient_info_employeraddress")
    private String patientInfoEmployeraddress;

    @Nationalized
    @Column(name = "patient_info_employercity")
    private String patientInfoEmployercity;

    @Nationalized
    @Column(name = "patient_info_employerfax")
    private String patientInfoEmployerfax;

    @Nationalized
    @Column(name = "patient_info_employername")
    private String patientInfoEmployername;

    @Nationalized
    @Column(name = "patient_info_employerphone")
    private String patientInfoEmployerphone;

    @Nationalized
    @Column(name = "patient_info_employerstate")
    private String patientInfoEmployerstate;

    @Nationalized
    @Column(name = "patient_info_employerzip")
    private String patientInfoEmployerzip;

    private String patient_info_enableVerterinary;

    @Nationalized
    @Column(name = "patient_info_ethnic")
    private String patientInfoEthnic;

    @Nationalized
    @Column(name = "patient_info_expirydate")
    private String patientInfoExpirydate;

    @Nationalized
    @Column(name = "patient_info_height")
    private String patientInfoHeight;

    @Nationalized
    @Column(name = "patient_info_is_animal")
    private String patientInfoIsAnimal;

    private String patient_info_isReviewedHealthInfo;

    @Nationalized
    @Column(name = "patient_info_language")
    private String patientInfoLanguage;

    @Nationalized
    @Column(name = "patient_info_licenseno")
    private String patientInfoLicenseno;

    @Nationalized
    @Column(name = "patient_info_licensestate")
    private String patientInfoLicensestate;

    @Nationalized
    @Column(name = "patient_info_maritalstatus")
    private String patientInfoMaritalstatus;

    @Nationalized
    @Column(name = "patient_info_orderingfacility")
    private String patientInfoOrderingfacility;

    @Nationalized
    @Column(name = "patient_info_patient_allergies")
    private String patientInfoPatientAllergies;

    @Nationalized
    @Column(name = "patient_info_patient_lab_orders")
    private String patientInfoPatientLabOrders;

    @Nationalized
    @Column(name = "patient_info_patient_medications")
    private String patientInfoPatientMedications;

    @Nationalized
    @Column(name = "patient_info_patient_problems")
    private String patientInfoPatientProblems;

    @Nationalized
    @Column(name = "patient_info_patient_vital")
    private String patientInfoPatientVital;

    @Nationalized
    @Column(name = "patient_info_patientflag")
    private String patientInfoPatientflag;

    @Nationalized
    @Column(name = "patient_info_providerfacilities")
    private String patientInfoProviderfacilities;

    @Nationalized
    @Column(name = "patient_info_providerid")
    private String patientInfoProviderid;

    @Nationalized
    @Column(name = "patient_info_providername")
    private String patientInfoProvidername;

    @Nationalized
    @Column(name = "patient_info_racial")
    private String patientInfoRacial;

    private String patient_info_resonForDeath;

    @Nationalized
    @Column(name = "patient_info_setordfacilityaddress")
    private String patientInfoSetordfacilityaddress;

    @Nationalized
    @Column(name = "patient_info_showexistpatient")
    private String patientInfoShowexistpatient;

    @Nationalized
    @Column(name = "patient_info_smokingstatus")
    private String patientInfoSmokingstatus;

    @Nationalized
    @Column(name = "patient_info_smsconsent")
    private String patientInfoSmsconsent;

    @Nationalized
    @Column(name = "patient_info_ssn")
    private String patientInfoSsn;

    @Nationalized
    @Column(name = "patient_info_weight")
    private String patientInfoWeight;

    @Nationalized
    @Column(name = "patient_type")
    private String patientType;

    @Nationalized
    @Column(name = "patient_uid")
    private String patientUid;

    @Nationalized
    @Column(name = "patient_uid_system")
    private String patientUidSystem;

    @Column(name = "portal_activated_dt")
    private OffsetDateTime portalActivatedDt;

    @Nationalized
    @Column(name = "portal_info")
    private String portalInfo;

    @Nationalized
    @Column(name = "portal_info_activated")
    private String portalInfoActivated;

    @Nationalized
    @Column(name = "portal_info_active")
    private String portalInfoActive;

    @Nationalized
    @Column(name = "portal_info_created_dt")
    private String portalInfoCreatedDt;

    @Nationalized
    @Column(name = "portal_info_lock")
    private String portalInfoLock;

    @Nationalized
    @Column(name = "portal_info_outpatient")
    private String portalInfoOutpatient;

    @Nationalized
    @Column(name = "portal_info_password")
    private String portalInfoPassword;

    @Nationalized
    @Column(name = "portal_info_username")
    private String portalInfoUsername;

    @Nationalized
    @Column(name = "prefix_name")
    private String prefixName;

    @Nationalized
    @Column(name = "rcopia_id")
    private String rcopiaId;

    @Nationalized
    @Column(name = "suffix_name")
    private String suffixName;

}
