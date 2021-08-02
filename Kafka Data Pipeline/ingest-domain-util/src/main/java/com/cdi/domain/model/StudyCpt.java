package com.cdi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.OffsetDateTime;

/**
 * StudyCpt entity is used to map the data of
 * <p>
 * <i> <b>Table = study_cpt </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "study_cpt", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class StudyCpt extends BaseEntity {

    @Nationalized
    @Column(name = "authorization_info")
    private String authorizationInfo;

    @Nationalized
    @Column(name = "authorization_info_primary")
    private String authorizationInfoPrimary;

    @Nationalized
    @Column(name = "bill_fee")
    private BigDecimal billFee;

    @Nationalized
    @Column(name = "cpt_code")
    private String cptCode;

    @Column(name = "cpt_code_id")
    private int cptCodeId;

    @Column(name = "deleted_dt")
    private OffsetDateTime deletedDt;

    @Column(name = "has_deleted")
    private boolean hasDeleted;

    @Column(name = "is_custom_bill_fee")
    private boolean isCustomBillFee;

    @Column(name = "lastaction")
    private String lastAction;

    @Column(name = "lastmodified")
    private Timestamp lastModified;

    @Column(name = "modifier1_id")
    private BigInteger modifier1Id;

    @Column(name = "modifier2_id")
    private BigInteger modifier2Id;

    @Column(name = "modifier3_id")
    private BigInteger modifier3Id;

    @Column(name = "modifier4_id")
    private BigInteger modifier4Id;

    @Column(name = "order_id")
    private BigInteger orderId;

    @Column(name = "rvu")
    private BigDecimal rvu;

    @Nationalized
    @Column(name = "study_cpt_info")
    private String studyCptInfo;

    @Nationalized
    @Column(name = "study_cpt_info_cpt_description")
    private String studyCptInfoCptDescription;

    @Nationalized
    @Column(name = "study_cpt_info_duration")
    private String studyCptInfoDuration;

    @Nationalized
    @Column(name = "study_cpt_info_isbatch")
    private String studyCptInfoIsbatch;

    @Nationalized
    @Column(name = "study_cpt_info_reorder")
    private String studyCptInfoReorder;

    @Nationalized
    @Column(name = "study_cpt_info_secondary")
    private String studyCptInfoSecondary;

    @Nationalized
    @Column(name = "study_cpt_info_tertiary")
    private String studyCptInfoTertiary;

    @Nationalized
    @Column(name = "study_cpt_info_units")
    private String studyCptInfoUnits;

    @Column(name = "study_id")
    private long studyId;

    @Column(name = "units")
    private BigDecimal units;
}
