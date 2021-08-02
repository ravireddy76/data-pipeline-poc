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
 * VitalSign entity is used to map the data of
 * <p>
 * <i> <b>Table = vital_signs </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "vital_signs", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class VitalSign extends BaseEntity {

    @Column(name = "created_dt")
    private OffsetDateTime createdDt;

    @Column(name = "deleted_dt")
    private OffsetDateTime deletedDt;

    @Column(name = "has_deleted")
    private boolean hasDeleted;

    @Column(name = "heightinInches")
    private String heightInInches;

    @Column(name = "LastAction")
    private String lastAction;

    @Column(name = "LastModified")
    private Timestamp lastModified;

    @Column(name = "measured_dt")
    private OffsetDateTime measuredDt;

    @Nationalized
    @Column(name = "more_info")
    private String moreInfo;

    @Column(name = "order_id")
    private BigInteger orderId;

    @Column(name = "patient_id")
    private BigInteger patientId;

    @Column(name = "weightinPounds")
    private String weightInPounds;
}
