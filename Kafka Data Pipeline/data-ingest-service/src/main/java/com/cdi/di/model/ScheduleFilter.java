package com.cdi.di.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * ScheduleFilter entity is used to map the data of
 * <p>
 * <i> <b>Table = schedule_filters </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "schedule_filters", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ScheduleFilter extends BaseEntity {

    @Column(name = "company_id")
    private int companyId;

    @Nationalized
    @Column(name = "filter_name")
    private String filterName;

    @Column(name = "LastAction")
    private String lastAction;

    @Column(name = "LastModified")
    private Timestamp lastModified;

    @Column(name = "modality_display_width")
    private int modalityDisplayWidth;

    @Nationalized
    @Column(name = "modality_rooms")
    private String modalityRooms;

    @Column(name = "no_of_days")
    private int noOfDays;
}
