package com.di.poc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * ModalityRoom entity is used to map the data of
 * <p>
 * <i> <b>Table = modality_rooms </b> under <br/>
 * <b>Schema = trans_data </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to Ravi POC World Inc. It's Illegal to reproduce this code.
 */
@Entity
@Table(name = "modality_rooms", schema = "trans_data")
@Data
@NoArgsConstructor
public class ModalityRoom {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "allow_scheduling")
    private boolean allowScheduling;

    @Column(name = "application_entity_id")
    private Object applicationEntityId;

    @Column(name = "color_code")
    private Object colorCode;

    @Column(name = "current_linked_resource")
    private Object currentLinkedResource;

    @Column(name = "deleted_dt")
    private Timestamp deletedDt;

    @Column(name = "display_order")
    private int displayOrder;

    @Column(name = "facility_id")
    private int facilityId;

    @Column(name = "fri_from_time")
    private Timestamp friFromTime;

    @Column(name = "fri_to_time")
    private Timestamp friToTime;

    @Column(name = "from_date")
    private Object fromDate;

    @Column(name = "has_deleted")
    private boolean hasDeleted;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "linked_tech_code")
    private Object linkedTechCode;

    @Column(name = "linked_tech_id")
    private Object linkedTechId;

    @Column(name = "linked_tech_name")
    private Object linkedTechName;

    @Column(name = "linked_vechicle_id")
    private Object linkedVechicleId;

    @Column(name = "linked_vechicle_name")
    private Object linkedVechicleName;

    @Column(name = "modalities")
    private Object modalities;

    @Column(name = "modality_room_code")
    private Object modalityRoomCode;

    @Column(name = "modality_room_name")
    private Object modalityRoomName;

    @Column(name = "mon_from_time")
    private Timestamp monFromTime;

    @Column(name = "mon_to_time")
    private Timestamp monToTime;

    @Column(name = "sat_from_time")
    private Timestamp satFromTime;

    @Column(name = "sat_to_time")
    private Timestamp satToTime;

    @Column(name = "sun_from_time")
    private Timestamp sunFromTime;

    @Column(name = "sun_to_time")
    private Timestamp sunToTime;

    @Column(name = "thu_from_time")
    private Timestamp thuFromTime;

    @Column(name = "thu_to_time")
    private Timestamp thuToTime;

    @Column(name = "to_date")
    private Object toDate;

    @Column(name = "tue_from_time")
    private Timestamp tueFromTime;

    @Column(name = "tue_to_time")
    private Timestamp tueToTime;

    @Column(name = "wed_from_time")
    private Timestamp wedFromTime;

    @Column(name = "wed_to_time")
    private Timestamp wedToTime;

}