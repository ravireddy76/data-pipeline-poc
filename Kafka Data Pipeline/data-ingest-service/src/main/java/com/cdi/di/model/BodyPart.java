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
 * BodyPart entity is used to map the data of
 * <p>
 * <i> <b>Table = body_parts </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "body_parts", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class BodyPart extends BaseEntity {

    @Nationalized
    @Column(name = "alt_names")
    private String altNames;

    @Column(name = "company_id")
    private int companyId;

    @Nationalized
    @Column(name = "deleted_dt")
    private String deletedDt;

    @Column(name = "has_deleted")
    private boolean hasDeleted;

    @Column(name = "is_active")
    private boolean isActive;

    @Nationalized
    @Column(name = "LastAction")
    private String lastAction;

    @Column(name = "LastModified")
    private Timestamp lastModified;

    @Nationalized
    @Column(name = "name")
    private String name;
}
