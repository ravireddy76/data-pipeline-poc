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
 * Issue entity is used to map the data of
 * <p>
 * <i> <b>Table = issues </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "issues", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Issue extends BaseEntity {

    @Column(name="created_dt")
    private OffsetDateTime createdDt;

    @Column(name="deleted_dt")
    private OffsetDateTime deletedDt;

    @Column(name="has_deleted")
    private boolean hasDeleted;

    @Column(name="has_resolved")
    private boolean hasResolved;

    @Nationalized
    @Column(name="issue_summary")
    private String issueSummary;

    @Column(name="LastAction")
    private String lastAction;

    @Column(name="LastModified")
    private Timestamp lastModified;

    @Nationalized
    @Column(name="resolved_dt")
    private String resolvedDt;

    @Nationalized
    @Column(name="subject")
    private String subject;

    @Column(name="user_id")
    private int userId;
}
