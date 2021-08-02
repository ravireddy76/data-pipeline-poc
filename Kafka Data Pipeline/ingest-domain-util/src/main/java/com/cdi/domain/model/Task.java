package com.cdi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.OffsetDateTime;

/**
 * Task entity is used to map the data of
 * <p>
 * <i> <b>Table = tasks </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "tasks", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Task extends BaseEntity {

    @Column(name = "created_dt")
    private OffsetDateTime createdDt;

    @Column(name = "deleted_dt")
    private OffsetDateTime deletedDt;

    @Column(name = "description")
    private String description;

    @Column(name = "has_completed")
    private boolean hasCompleted;

    @Column(name = "has_deleted")
    private boolean hasDeleted;

    @Column(name = "LastAction")
    private String lastAction;

    @Column(name = "LastModified")
    private Timestamp lastModified;

    @Nationalized
    @Column(name = "title")
    private String title;

    @Column(name = "user_id")
    private int userId;

}
