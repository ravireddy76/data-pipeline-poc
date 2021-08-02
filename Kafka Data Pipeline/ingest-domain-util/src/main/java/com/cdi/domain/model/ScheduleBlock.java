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
import java.util.Date;

/**
 * ScheduleFilter entity is used to map the data of
 * <p>
 * <i> <b>Table = schedule_blocks </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "schedule_blocks", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ScheduleBlock extends BaseEntity {

    @Nationalized
    @Column(name = "description")
    private String description;

    @Nationalized
    @Column(name = "summary")
    private String summary;

    @Nationalized
    @Column(name = "color_code")
    private String colorCode;

    @Column(name = "can_schedule")
    private boolean canSchedule;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "end_time")
    private Timestamp endTime;

    @Column(name = "full_day_event")
    private boolean fullDayEvent;

    @Nationalized
    @Column(name = "end_occurence_mod")
    private String endOccurenceMod;

    @Column(name = "end_after_occurences")
    private int endAfterOccurences;

    @Nationalized
    @Column(name = "recurrence_type")
    private String recurrenceType;

    @Column(name = "recurring_frequency")
    private int recurringFrequency;

    @Column(name = "every_weekday")
    private boolean everyWeekday;

    @Column(name = "sunday")
    private boolean sunday;

    @Column(name = "monday")
    private boolean monday;

    @Column(name = "tuesday")
    private boolean tuesday;

    @Column(name = "wednesday")
    private boolean wednesday;

    @Column(name = "thursday")
    private boolean thursday;

    @Column(name = "friday")
    private boolean friday;

    @Column(name = "saturday")
    private boolean saturday;

    @Column(name = "day_of_month")
    private int dayOfMonth;

    @Column(name = "evry_nth_week")
    private int evryNthWeek;

    @Column(name = "week_day")
    private int weekDay;

    @Column(name = "month_day")
    private int monthDay;

    @Column(name = "day_of_year")
    private int dayOfYear;

    @Column(name = "month_of_year")
    private int monthOfYear;

    @Nationalized
    @Column(name = "modality_rooms")
    private String modalityRooms;

    @Column(name = "facility_id")
    private int facilityId;

    @Column(name = "has_deleted")
    private boolean hasDeleted;

    @Column(name = "deleted_dt")
    private OffsetDateTime deletedDt;

    @Column(name = "is_active")
    private boolean isActive;

    @Nationalized
    @Column(name = "provider_schedule_templates")
    private String providerScheduleTemplates;

    @Column(name = "LastAction")
    private String lastAction;

    @Column(name = "LastModified")
    private Timestamp lastModified;
}
