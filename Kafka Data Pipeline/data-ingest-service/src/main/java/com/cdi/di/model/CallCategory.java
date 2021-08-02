package com.cdi.di.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * CallCategory entity is used to map the data of
 * <p>
 * <i> <b>Table = call_categories </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name="call_categories", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class CallCategory extends BaseEntity {

    @Column(name="company_id")
    private int companyId;

    @Nationalized
    @Column(name="deactivated_dt")
    private String deactivatedDt;

    @Nationalized
    @Column(name="deleted_dt")
    private String deletedDt;

    @Nationalized
    @Column(name="LastAction")
    private String lastAction;

    @Column(name="LastModified")
    private Timestamp lastModified;

    @Nationalized
    @Column(name="name")
    private String name;
}
