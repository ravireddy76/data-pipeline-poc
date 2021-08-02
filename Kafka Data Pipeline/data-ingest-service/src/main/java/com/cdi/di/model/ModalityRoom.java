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
import java.time.OffsetDateTime;

/**
 * ModalityRoom entity is used to map the data of
 * <p>
 * <i> <b>Table = modality_rooms </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "modality_rooms", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ModalityRoom extends BaseEntity {

    @Column(name="allow_scheduling")
    private boolean allowScheduling;

    @Nationalized
    @Column(name="application_entity_id")
    private String applicationEntityId;

    @Nationalized
    @Column(name="color_code")
    private String colorCode;

    @Column(name="deleted_dt")
    private OffsetDateTime deletedDt;

    @Column(name="display_order")
    private int displayOrder;

    @Column(name="facility_id")
    private int facilityId;

    @Column(name="fri_from_time")
    private OffsetDateTime friFromTime;

    @Column(name="fri_to_time")
    private OffsetDateTime friToTime;

    @Column(name="from_date")
    private Date fromDate;

    @Column(name="has_deleted")
    private boolean hasDeleted;

    @Column(name="is_active")
    private boolean isActive;

    @Column(name="lastaction")
    private String lastaction;

    @Column(name="lastmodified")
    private Timestamp lastmodified;

    @Nationalized
    @Column(name="modalities")
    private String modalities;

    @Nationalized
    @Column(name="modality_room_code")
    private String modalityRoomCode;

    @Nationalized
    @Column(name="modality_room_name")
    private String modalityRoomName;

    @Column(name="mon_from_time")
    private OffsetDateTime monFromTime;

    @Column(name="mon_to_time")
    private OffsetDateTime monToTime;

    @Nationalized
    @Column(name="more_info")
    private String moreInfo;

    @Nationalized
    @Column(name="more_info_current_linked_resource")
    private String moreInfoCurrentLinkedResource;

    @Nationalized
    @Column(name="more_info_linked_tech_code")
    private String moreInfoLinkedTechCode;

    @Nationalized
    @Column(name="more_info_linked_tech_id")
    private String moreInfoLinkedTechId;

    @Nationalized
    @Column(name="more_info_linked_tech_name")
    private String moreInfoLinkedTechName;

    @Nationalized
    @Column(name="more_info_linked_vechicle_id")
    private String moreInfoLinkedVechicleId;

    @Nationalized
    @Column(name="more_info_linked_vechicle_name")
    private String moreInfoLinkedVechicleName;

    @Column(name="sat_from_time")
    private OffsetDateTime satFromTime;

    @Column(name="sat_to_time")
    private OffsetDateTime satToTime;

    @Column(name="sun_from_time")
    private OffsetDateTime sunFromTime;

    @Column(name="sun_to_time")
    private OffsetDateTime sunToTime;

    @Column(name="thu_from_time")
    private OffsetDateTime thuFromTime;

    @Column(name="thu_to_time")
    private OffsetDateTime thuToTime;

    @Column(name="to_date")
    private Date toDate;

    @Column(name="tue_from_time")
    private OffsetDateTime tueFromTime;

    @Column(name="tue_to_time")
    private OffsetDateTime tueToTime;

    @Column(name="wed_from_time")
    private OffsetDateTime wedFromTime;

    @Column(name="wed_to_time")
    private OffsetDateTime wedToTime;
}
