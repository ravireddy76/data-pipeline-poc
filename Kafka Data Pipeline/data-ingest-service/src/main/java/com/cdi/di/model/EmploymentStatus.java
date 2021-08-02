package com.cdi.di.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * EmploymentStatus entity is used to map the data of
 * <p>
 * <i> <b>Table = employment_status </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "employment_status", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class EmploymentStatus extends BaseEntity {

    @Column(name="company_id")
    private long companyId;

    @Nationalized
    @Column(name="description")
    private String description;

    @Nationalized
    @Column(name="inactivated_dt")
    private String inactivatedDt;

    @Column(name="lastaction")
    private String lastaction;

    @Column(name="lastmodified")
    private Timestamp lastmodified;

}
