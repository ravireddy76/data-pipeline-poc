package com.cdi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * InsuranceAuthorization entity is used to map the data of
 * <p>
 * <i> <b>Table = insurance_authorizations </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "insurance_authorizations", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class InsuranceAuthorization extends BaseEntity {
    
    @Column(name="allow_scheduling")
    private boolean allowScheduling;

    @Column(name="apply_all_codes")
    private boolean applyAllCodes;

    @Column(name="apply_all_insurances")
    private boolean applyAllInsurances;

    @Column(name="apply_all_modalities")
    private boolean applyAllModalities;

    @Nationalized
    @Column(name="cpt_codes")
    private String cptCodes;

    @Column(name="days")
    private int days;

    @Nationalized
    @Column(name="deleted_dt")
    private String deletedDt;

    @Column(name="facility_id")
    private int facilityId;

    @Column(name="has_deleted")
    private boolean hasDeleted;

    @Nationalized
    @Column(name="insurance_providers")
    private String insuranceProviders;

    @Column(name="is_active")
    private int isActive;

    @Column(name="LastAction")
    private String lastAction;

    @Column(name="LastModified")
    private Timestamp lastModified;

    @Column(name="modality_id")
    private int modalityId;
}
