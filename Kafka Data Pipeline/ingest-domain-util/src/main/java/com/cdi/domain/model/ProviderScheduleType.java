package com.cdi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.OffsetDateTime;

/**
 * ProviderScheduleType entity is used to map the data of
 * <p>
 * <i> <b>Table = provider_schedule_types </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "provider_schedule_types", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProviderScheduleType extends BaseEntity {

    @Column(name = "cpt_code_id")
    private int cptCodeId;

    @Column(name = "day_no")
    private int dayNo;

    @Column(name = "from_time")
    private OffsetDateTime fromTime;

    @Column(name = "lastaction")
    private String lastaction;

    @Column(name = "lastmodified")
    private Timestamp lastmodified;

    @Column(name = "provider_id")
    private int providerId;

    @Column(name = "provider_schedule_template_id")
    private BigInteger providerScheduleTemplateId;

    @Column(name = "to_time")
    private OffsetDateTime toTime;

    @Column(name = "vehicle_id")
    private int vehicleId;
}
