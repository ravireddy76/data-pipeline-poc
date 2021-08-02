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
 * News entity is used to map the data of
 * <p>
 * <i> <b>Table = news </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "news", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class News extends BaseEntity {

    @Column(name="company_id")
    private int companyId;

    @Column(name="deleted_dt")
    private Timestamp deletedDt;

    @Nationalized
    @Column(name = "description")
    private String description;

    @Nationalized
    @Column(name = "facilities")
    private String facilities;

    @Column(name="has_deleted")
    private boolean hasDeleted;

    @Column(name="is_active")
    private boolean isActive;

    @Column(name="is_ref_portal")
    private boolean isRefPortal;

    @Column(name="LastAction")
    private String lastAction;

    @Column(name="LastModified")
    private Timestamp lastModified;

    @Nationalized
    @Column(name = "title")
    private String title;
}
