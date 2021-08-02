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
 * StudyFlag entity is used to map the data of
 * <p>
 * <i> <b>Table = study_flags </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "study_flags", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class StudyFlag extends BaseEntity {

    @Column(name = "available_in_portal")
    private boolean availableInPortal;

    @Nationalized
    @Column(name = "color_code")
    private String colorCode;

    @Column(name = "company_id")
    private int companyId;

    @Column(name = "deleted_dt")
    private OffsetDateTime deletedDt;

    @Nationalized
    @Column(name = "description")
    private String description;

    @Nationalized
    @Column(name = "facilities")
    private String facilities;

    @Column(name = "has_deleted")
    private boolean hasDeleted;

    @Nationalized
    @Column(name = "institutions")
    private String institutions;

    @Nationalized
    @Column(name = "modalities")
    private String modalities;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "lastaction")
    private String lastaction;

    @Column(name = "lastmodified")
    private Timestamp lastmodified;
}
