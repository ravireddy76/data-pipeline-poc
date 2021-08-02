package com.cdi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.OffsetDateTime;

/**
 * Market entity is used to map the data of
 * <p>
 * <i> <b>Table = markets </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "markets", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Market extends BaseEntity {

    @Column(name="region_id")
    private long regionId;

    @Nationalized
    @Column(name = "code")
    private String code;

    @Nationalized
    @Column(name = "name")
    private String name;

    @Column(name="company_id")
    private long companyId;

    @Column(name="created_dt")
    private OffsetDateTime createdDt;

    @Column(name="deleted_dt")
    private OffsetDateTime deletedDt;

    @Column(name="inactivated_dt")
    private OffsetDateTime inactivatedDt;

    @Column(name = "lastaction")
    private String lastaction;

    @Column(name = "lastmodified")
    private Timestamp lastmodified;

}
