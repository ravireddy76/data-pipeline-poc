package com.cdi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * PatientInsurance entity is used to map the data of
 * <p>
 * <i> <b>Table = patient_insurances </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "patient_insurances", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PatientInsurance extends BaseEntity {
    
    @Column(name="assign_benefits_to_patient")
    private boolean assignBenefitsToPatient;

    @Nationalized
    @Column(name="coverage_level")
    private String coverageLevel;

    @Nationalized
    @Column(name="group_name")
    private String groupName;

    @Nationalized
    @Column(name="group_number")
    private String groupNumber;

    @Nationalized
    @Column(name="home_phone_number")
    private String homePhoneNumber;

    @Column(name="insurance_provider_id")
    private BigInteger insuranceProviderId;

    @Column(name="LastAction")
    private String lastAction;

    @Column(name="LastModified")
    private Timestamp lastModified;

    @Nationalized
    @Column(name="medicare_insurance_type_code")
    private String medicareInsuranceTypeCode;

    @Column(name="patient_id")
    private BigInteger patientId;

    @Nationalized
    @Column(name="policy_number")
    private String policyNumber;

    @Nationalized
    @Column(name="precertification_fax_number")
    private String precertificationFaxNumber;

    @Nationalized
    @Column(name="precertification_phone_number")
    private String precertificationPhoneNumber;

    @Nationalized
    @Column(name="subscriber_address_line1")
    private String subscriberAddressLine1;

    @Nationalized
    @Column(name="subscriber_address_line2")
    private String subscriberAddressLine2;

    @Nationalized
    @Column(name="subscriber_city")
    private String subscriberCity;

    @Column(name="subscriber_dob")
    private Date subscriberDob;

    @Column(name="subscriber_employment_status_id")
    private BigInteger subscriberEmploymentStatusId;

    @Nationalized
    @Column(name="subscriber_firstname")
    private String subscriberFirstname;

    @Nationalized
    @Column(name="subscriber_gender")
    private String subscriberGender;

    @Nationalized
    @Column(name="subscriber_lastname")
    private String subscriberLastname;

    @Nationalized
    @Column(name="subscriber_middlename")
    private String subscriberMiddlename;

    @Nationalized
    @Column(name="subscriber_name_suffix")
    private String subscriberNameSuffix;

    @Column(name="subscriber_relationship_id")
    private long subscriberRelationshipId;

    @Nationalized
    @Column(name="subscriber_state")
    private String subscriberState;

    @Nationalized
    @Column(name="subscriber_zipcode")
    private String subscriberZipcode;

    @Column(name="valid_from_date")
    private Date validFromDate;

    @Column(name="valid_to_date")
    private Date validToDate;

    @Nationalized
    @Column(name="work_phone_number")
    private String workPhoneNumber;
}
