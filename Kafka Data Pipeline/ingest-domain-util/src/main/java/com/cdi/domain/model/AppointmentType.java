package com.cdi.domain.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * AppointmentType entity is used to map the data of
 * <p>
 * <i> <b>Table = appointment_types </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name="appointment_types",schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class AppointmentType extends BaseEntity {

    @Nationalized
    @Column(name="code")
    private String code;

    @Nationalized
    @Column(name="description")
    private String description;

    @Column(name="duration")
    private int duration;

    @Column(name="exam_count")
    private int examCount;

    @Nationalized
    @Column(name="exam_prep_instructions")
    private String examPrepInstructions;

    @Nationalized
    @Column(name="facility_ids")
    private String facilityIds;

    @Column(name="is_active")
    private boolean isActive;

    @Column(name="is_group_appt")
    private boolean isGroupAppt;

    @Nationalized
    @Column(name="keywords")
    private String keywords;

    @Column(name="lastaction")
    private String lastaction;

    @Column(name="lastmodified")
    private Timestamp lastmodified;

    @Nationalized
    @Column(name="lead_time")
    private String leadTime;

    @Nationalized
    @Column(name="modality_ids")
    private String modalityIds;

    @Nationalized
    @Column(name="modality_room_durations")
    private String modalityRoomDurations;

    @Nationalized
    @Column(name="modality_room_ids")
    private String modalityRoomIds;

    @Nationalized
    @Column(name="name")
    private String name;

    @Nationalized
    @Column(name="ref_code")
    private String refCode;
}
