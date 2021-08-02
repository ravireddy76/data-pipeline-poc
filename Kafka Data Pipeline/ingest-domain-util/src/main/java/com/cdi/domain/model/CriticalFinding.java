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
 * CriticalFinding entity is used to map the data of
 * <p>
 * <i> <b>Table = critical_findings </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "critical_findings", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class CriticalFinding extends BaseEntity {

    @Column(name="company_id")
    private int companyId;

    @Nationalized
    @Column(name="description")
    private String description;

    @Column(name="LastAction")
    private String lastAction;

    @Column(name="LastModified")
    private Timestamp lastModified;
}
