package com.cdi.di.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.OffsetDateTime;

/**
 * StudyStatus entity is used to map the data of
 * <p>
 * <i> <b>Table = study_status </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "study_status", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class StudyStatus extends BaseEntity {

    @Column(name = "can_delete")
    private boolean canDelete;

    @Column(name = "can_edit")
    private boolean canEdit;

    @Column(name = "color_code")
    private String colorCode;

    @Column(name = "deleted_dt")
    private OffsetDateTime deletedDt;

    @Column(name = "display_order")
    private int displayOrder;

    @Column(name = "facility_id")
    private int facilityId;

    @Column(name = "has_deleted")
    private boolean hasDeleted;

    @Column(name = "LastAction")
    private String lastAction;

    @Column(name = "LastModified")
    private Timestamp lastModified;

    @Column(name = "mobile_rad_related")
    private boolean mobileRadRelated;

    @Column(name = "order_related")
    private boolean orderRelated;

    @Column(name = "rad_related")
    private boolean radRelated;

    @Column(name = "show_right_click")
    private boolean showRightClick;

    @Column(name = "show_validation_window")
    private boolean showValidationWindow;

    @Column(name = "status_code")
    private String statusCode;

    @Column(name = "status_desc")
    private String statusDesc;

    @Column(name = "status_validation")
    private String statusValidation;

    @Column(name = "waiting_time")
    private int waitingTime;
}
