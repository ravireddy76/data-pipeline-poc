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
 * PatientIcds entity is used to map the data of
 * <p>
 * <i> <b>Table = patient_icds </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "patient_icds", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PatientIcds extends BaseEntity {

    @Nationalized
    @Column(name = "current_status")
    private String currentStatus;

    @Column(name = "icd_id")
    private int icdId;

    @Column(name = "LastAction")
    private String lastAction;

    @Column(name = "LastModified")
    private Timestamp lastModified;

    @Column(name = "onset_date")
    private OffsetDateTime onsetDate;

    @Column(name = "patient_id")
    private BigInteger patientId;
}
