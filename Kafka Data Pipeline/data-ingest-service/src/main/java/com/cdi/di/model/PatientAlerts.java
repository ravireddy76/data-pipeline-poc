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
 * PatientAlerts entity is used to map the data of
 * <p>
 * <i> <b>Table = patient_alerts </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "patient_alerts", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PatientAlerts extends BaseEntity {

    @Nationalized
    @Column(name = "alert")
    private String alert;

    @Column(name = "alert_id")
    private BigInteger alertId;

    @Column(name = "created_by")
    private long createdBy;

    @Column(name = "created_dt")
    private OffsetDateTime createdDt;

    @Column(name = "LastAction")
    private String lastAction;

    @Column(name = "LastModified")
    private Timestamp lastModified;

    @Column(name = "patient_id")
    private BigInteger patientId;
}
