package com.cdi.di.model;

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
 * MarketingRepTask entity is used to map the data of
 * <p>
 * <i> <b>Table = marketing_rep_tasks </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "marketing_rep_tasks", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class MarketingRepTask extends BaseEntity {

    @Column(name="created_dt")
    private OffsetDateTime createdDt;

    @Column(name="deleted_dt")
    private OffsetDateTime deletedDt;

    @Column(name="due_date")
    private OffsetDateTime dueDate;

    @Column(name="has_completed")
    private boolean hasCompleted;

    @Column(name="has_deleted")
    private boolean hasDeleted;

    @Column(name="LastAction")
    private String lastAction;

    @Column(name="LastModified")
    private Timestamp lastModified;

    @Nationalized
    @Column(name="notes")
    private String notes;

    @Column(name="provider_contact_id")
    private int providerContactId;

    @Nationalized
    @Column(name="provider_flag")
    private String providerFlag;

    @Column(name="provider_group_id")
    private long providerGroupId;

    @Column(name="provider_id")
    private long providerId;

    @Nationalized
    @Column(name="subject")
    private String subject;

    @Nationalized
    @Column(name="task_flag")
    private String taskFlag;

    @Nationalized
    @Column(name="task_info")
    private String taskInfo;

    @Nationalized
    @Column(name="task_info_flag")
    private String taskInfoFlag;

    @Nationalized
    @Column(name="task_info_has_completed")
    private String taskInfoHasCompleted;

    @Nationalized
    @Column(name="task_info_ov")
    private String taskInfoOv;

    @Nationalized
    @Column(name="task_info_pc")
    private String taskInfoPc;

    @Nationalized
    @Column(name="task_type")
    private String taskType;

}
