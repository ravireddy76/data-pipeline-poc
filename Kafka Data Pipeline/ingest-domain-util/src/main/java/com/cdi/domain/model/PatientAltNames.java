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

/**
 * PatientAltNames entity is used to map the data of
 * <p>
 * <i> <b>Table = patient_alt_names </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "patient_alt_names", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PatientAltNames extends BaseEntity {

    @Nationalized
    @Column(name = "first_name")
    private String firstName;

    @Nationalized
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "LastAction")
    private String lastAction;

    @Column(name = "LastModified")
    private Timestamp lastModified;

    @Nationalized
    @Column(name = "middle_initial")
    private String middleInitial;

    @Nationalized
    @Column(name = "name_type")
    private String nameType;

    @Column(name = "patient_id")
    private BigInteger patientId;

    @Nationalized
    @Column(name = "prefix")
    private String prefix;

    @Nationalized
    @Column(name = "suffix")
    private String suffix;
}
