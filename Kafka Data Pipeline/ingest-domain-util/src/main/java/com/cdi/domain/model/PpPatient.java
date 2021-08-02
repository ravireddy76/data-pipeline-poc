package com.cdi.domain.model;

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
 * PpPatient entity is used to map the data of
 * <p>
 * <i> <b>Table = pp_patients </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "pp_patients", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PpPatient extends BaseEntity {

    @Column(name = "company_id")
    private int companyId;

    @Column(name = "deleted_dt")
    private OffsetDateTime deletedDt;

    @Column(name = "has_deleted")
    private boolean hasDeleted;

    @Column(name = "has_linked")
    private boolean hasLinked;

    @Column(name = "lastaction")
    private String lastaction;

    @Column(name = "lastmodified")
    private Timestamp lastmodified;

    @Column(name = "linked_patient_id")
    private BigInteger linkedPatientId;

    @Nationalized
    @Column(name = "patient_info")
    private String patientInfo;

    @Nationalized
    @Column(name = "patient_info_address1")
    private String patientInfoAddress1;

    @Nationalized
    @Column(name = "patient_info_address2")
    private String patientInfoAddress2;

    @Nationalized
    @Column(name = "patient_info_city")
    private String patientInfoCity;

    @Nationalized
    @Column(name = "patient_info_dob")
    private String patientInfoDob;

    @Nationalized
    @Column(name = "patient_info_emailid")
    private String patientInfoEmailid;

    @Nationalized
    @Column(name = "patient_info_ethnic")
    private String patientInfoEthnic;

    @Nationalized
    @Column(name = "patient_info_firstname")
    private String patientInfoFirstname;

    @Nationalized
    @Column(name = "patient_info_gender")
    private String patientInfoGender;

    @Nationalized
    @Column(name = "patient_info_language")
    private String patientInfoLanguage;

    @Nationalized
    @Column(name = "patient_info_lastname")
    private String patientInfoLastname;

    @Nationalized
    @Column(name = "patient_info_mobile")
    private String patientInfoMobile;

    @Nationalized
    @Column(name = "patient_info_password")
    private String patientInfoPassword;

    @Nationalized
    @Column(name = "patient_info_race")
    private String patientInfoRace;

    @Nationalized
    @Column(name = "patient_info_requestedbyuser")
    private String patientInfoRequestedbyuser;

    @Nationalized
    @Column(name = "patient_info_requesteddate")
    private String patientInfoRequesteddate;

    @Nationalized
    @Column(name = "patient_info_state")
    private String patientInfoState;

    @Nationalized
    @Column(name = "patient_info_username")
    private String patientInfoUsername;

    @Nationalized
    @Column(name = "patient_info_userstatus")
    private String patientInfoUserstatus;

    @Nationalized
    @Column(name = "patient_info_zip")
    private String patientInfoZip;

    @Column(name = "pp_patient_id")
    private long ppPatientId;

    @Column(name = "relationship_id")
    private long relationshipId;
}
