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
 * Provider entity is used to map the data of
 * <p>
 * <i> <b>Table = providers </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "providers", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Provider extends BaseEntity {

    @Column(name = "company_id")
    private int companyId;

    @Column(name = "deleted_dt")
    private OffsetDateTime deletedDt;

    @Nationalized
    @Column(name = "dicom_name")
    private String dicomName;

    @Nationalized
    @Column(name = "facilities")
    private String facilities;

    @Column(name = "fee_schedule_id")
    private BigInteger feeScheduleId;

    @Nationalized
    @Column(name = "first_name")
    private String firstName;

    @Nationalized
    @Column(name = "full_name")
    private String fullName;

    @Nationalized
    @Column(name = "is_active")
    private boolean isActive;

    @Nationalized
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "lastaction")
    private String lastaction;

    @Column(name = "lastmodified")
    private Timestamp lastmodified;

    @Nationalized
    @Column(name = "marketing_rep")
    private String marketingRep;

    @Column(name = "marketing_rep_id")
    private int marketingRepId;

    @Column(name = "max_tat")
    private short maxTat;

    @Nationalized
    @Column(name = "middle_initial")
    private String middleInitial;

    @Column(name = "place_of_service_id")
    private BigInteger placeOfServiceId;

    @Nationalized
    @Column(name = "provider_code")
    private String providerCode;

    @Nationalized
    @Column(name = "provider_info")
    private String providerInfo;

    @Nationalized
    @Column(name = "provider_info_degree")
    private String providerInfoDegree;

    @Nationalized
    @Column(name = "provider_info_drofficename")
    private String providerInfoDrofficename;

    @Nationalized
    @Column(name = "provider_info_ein")
    private String providerInfoEin;

    @Nationalized
    @Column(name = "provider_info_eincode")
    private String providerInfoEincode;

    @Nationalized
    @Column(name = "provider_info_etin")
    private String providerInfoEtin;

    @Nationalized
    @Column(name = "provider_info_federaltaxid")
    private String providerInfoFederaltaxid;

    @Nationalized
    @Column(name = "provider_info_licenseno")
    private String providerInfoLicenseno;

    @Nationalized
    @Column(name = "provider_info_medicaidproviderno")
    private String providerInfoMedicaidproviderno;

    @Nationalized
    @Column(name = "provider_info_medicareproviderno")
    private String providerInfoMedicareproviderno;

    @Nationalized
    @Column(name = "provider_info_medicareupin")
    private String providerInfoMedicareupin;

    @Nationalized
    @Column(name = "provider_info_npi")
    private String providerInfoNpi;

    @Nationalized
    @Column(name = "provider_info_provideragreementcode")
    private String providerInfoProvideragreementcode;

    @Nationalized
    @Column(name = "provider_info_signprint")
    private String providerInfoSignprint;

    @Nationalized
    @Column(name = "provider_info_ssn")
    private String providerInfoSsn;

    @Nationalized
    @Column(name = "provider_info_ssncode")
    private String providerInfoSsncode;

    @Nationalized
    @Column(name = "provider_info_txc")
    private String providerInfoTxc;

    @Nationalized
    @Column(name = "provider_type")
    private String providerType;

    @Nationalized
    @Column(name = "specialities")
    private String specialities;

    @Nationalized
    @Column(name = "suffix")
    private String suffix;

    @Column(name = "sys_provider")
    private boolean sysProvider;

    @Nationalized
    @Column(name = "technologist_modalities")
    private String technologistModalities;
}
