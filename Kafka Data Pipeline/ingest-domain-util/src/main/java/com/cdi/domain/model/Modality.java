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
 * Modality entity is used to map the data of
 * <p>
 * <i> <b>Table = modalities </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "modalities", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Modality extends BaseEntity {

    @Column(name="company_id")
    private int companyId;

    @Column(name="deleted_dt")
    private OffsetDateTime deletedDt;

    @Column(name="has_deleted")
    private boolean hasDeleted;

    @Column(name="hidden_on_physician_portal")
    private boolean hiddenOnPhysicianPortal;

    @Column(name="is_active")
    private boolean isActive;

    @Column(name="lastaction")
    private String lastaction;

    @Column(name="lastmodified")
    private Timestamp lastmodified;

    @Nationalized
    @Column(name="modality_code")
    private String modalityCode;

    @Nationalized
    @Column(name="modality_name")
    private String modalityName;

    @Column(name="priority")
    private int priority;
}
