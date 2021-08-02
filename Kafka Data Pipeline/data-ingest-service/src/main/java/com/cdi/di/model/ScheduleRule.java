package com.cdi.di.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * ScheduleRule entity is used to map the data of
 * <p>
 * <i> <b>Table = provider_contracts </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "schedule_rules", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ScheduleRule extends BaseEntity {

    @Nationalized
    @Column(name = "dates")
    private String dates;

    @Column(name = "exclusion")
    private boolean exclusion;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "LastAction")
    private String lastAction;

    @Column(name = "LastModified")
    private Timestamp lastModified;

    @Nationalized
    @Column(name = "name")
    private String name;

    @Column(name = "re_end_dt")
    private Date reEndDt;

    @Column(name = "re_frequency")
    private int reFrequency;

    @Nationalized
    @Column(name = "re_repeats")
    private String reRepeats;

    @Column(name = "re_start_dt")
    private Date reStartDt;

    @Nationalized
    @Column(name = "re_time_end")
    private String reTimeEnd;

    @Nationalized
    @Column(name = "re_time_start")
    private String reTimeStart;

    @Nationalized
    @Column(name = "recurrence")
    private String recurrence;

    @Column(name = "schedule_template_id")
    private int scheduleTemplateId;

    @Nationalized
    @Column(name = "type")
    private String type;
}
