package com.cdi.domain.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.OffsetDateTime;

/**
 * ProviderScheduleTemplate entity is used to map the data of
 * <p>
 * <i> <b>Table = provider_schedule_templates </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "provider_schedule_templates", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProviderScheduleTemplate extends BaseEntity {

    @Column(name = "allow_scheduling")
    private boolean allowScheduling;

    @Nationalized
    @Column(name = "color_code")
    private String colorCode;

    @Column(name = "deleted_dt")
    private OffsetDateTime deletedDt;

    @Column(name = "display_order")
    private int displayOrder;

    @Nationalized
    @Column(name = "facilities")
    private String facilities;

    @Column(name = "facility_id")
    private int facilityId;

    @Column(name = "from_date")
    private Date fromDate;

    @Column(name = "has_deleted")
    private boolean hasDeleted;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "lastaction")
    private String lastaction;

    @Column(name = "lastmodified")
    private Timestamp lastmodified;

    @Column(name = "provider_id")
    private int providerId;

    @Nationalized
    @Column(name = "template_info")
    private String templateInfo;

    @Nationalized
    @Column(name = "template_info_days")
    private String templateInfoDays;

    @Nationalized
    @Column(name = "template_info_schedule_type")
    private String templateInfoScheduleType;

    @Nationalized
    @Column(name = "template_info_wdays")
    private String templateInfoWdays;

    @Nationalized
    @Column(name = "template_info_week1")
    private String templateInfoWeek1;

    @Nationalized
    @Column(name = "template_info_week1days")
    private String templateInfoWeek1days;

    @Nationalized
    @Column(name = "template_info_week2")
    private String templateInfoWeek2;

    @Nationalized
    @Column(name = "template_info_week2days")
    private String templateInfoWeek2days;

    @Nationalized
    @Column(name = "template_info_week3")
    private String templateInfoWeek3;

    @Nationalized
    @Column(name = "template_info_week3days")
    private String templateInfoWeek3days;

    @Nationalized
    @Column(name = "template_info_week4")
    private String templateInfoWeek4;

    @Nationalized
    @Column(name = "template_info_week4days")
    private String templateInfoWeek4days;

    @Nationalized
    @Column(name = "template_info_week5")
    private String templateInfoWeek5;

    @Nationalized
    @Column(name = "template_info_week5days")
    private String templateInfoWeek5days;

    @Nationalized
    @Column(name = "template_info_week6")
    private String templateInfoWeek6;

    @Nationalized
    @Column(name = "template_info_week6days")
    private String templateInfoWeek6days;

    @Nationalized
    @Column(name = "template_name")
    private String templateName;

    @Column(name = "to_date")
    private Date toDate;
}
