package com.cdi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.OffsetDateTime;

/**
 * OrderFollowup entity is used to map the data of
 * <p>
 * <i> <b>Table = order_followups </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "order_followups", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class OrderFollowup extends BaseEntity {

    @Nationalized
    @Column(name = "deleted_dt")
    private OffsetDateTime deletedDt;

    @Nationalized
    @Column(name = "followup_info")
    private String followupInfo;

    @Nationalized
    @Column(name = "followup_info_code")
    private String followupInfoCode;

    @Nationalized
    @Column(name = "followup_info_description")
    private String followupInfoDescription;

    @Nationalized
    @Column(name = "followup_info_expecteddate")
    private String followupInfoExpecteddate;

    @Nationalized
    @Column(name = "followup_info_from")
    private String followupInfoFrom;

    @Nationalized
    @Column(name = "followup_info_nextfollowupdate")
    private String followupInfoNextfollowupdate;

    @Nationalized
    @Column(name = "has_deleted")
    private boolean hasDeleted;

    @Nationalized
    @Column(name = "LastAction")
    private String lastAction;

    @Nationalized
    @Column(name = "LastModified")
    private Timestamp lastModified;

    @Column(name = "order_id")
    private BigInteger orderId;

    @Column(name = "patient_id")
    private BigInteger patientId;
}
