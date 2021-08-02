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
 * RelationshipStatus entity is used to map the data of
 * <p>
 * <i> <b>Table = relationship_status </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "relationship_status", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RelationshipStatus extends BaseEntity {

    @Column(name = "company_id")
    private long companyId;

    @Nationalized
    @Column(name = "description")
    private String description;

    @Column(name = "inactivated_dt")
    private Timestamp inactivatedDt;

    @Column(name = "LastAction")
    private String lastAction;

    @Column(name = "LastModified")
    private Timestamp lastModified;
}
