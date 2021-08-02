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
 * ScheduleTemplate entity is used to map the data of
 * <p>
 * <i> <b>Table = schedule_templates </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "schedule_templates", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ScheduleTemplate extends BaseEntity {

    @Nationalized
    @Column(name = "appointment_types")
    private String appointmentTypes;

    @Nationalized
    @Column(name = "description")
    private String description;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "LastAction")
    private String lastAction;

    @Column(name = "LastModified")
    private Timestamp lastModified;

    @Nationalized
    @Column(name = "modality_rooms")
    private String modalityRooms;

    @Nationalized
    @Column(name = "name")
    private String name;

    @Nationalized
    @Column(name = "providers")
    private String providers;
}
