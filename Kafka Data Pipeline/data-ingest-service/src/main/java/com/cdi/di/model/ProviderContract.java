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
 * ProviderContract entity is used to map the data of
 * <p>
 * <i> <b>Table = provider_contracts </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "provider_contracts", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProviderContract extends BaseEntity {

    @Nationalized
    @Column(name = "contract_name")
    private String contractName;

    @Nationalized
    @Column(name = "contract_type")
    private String contractType;

    @Column(name = "deleted_dt")
    private OffsetDateTime deletedDt;

    @Column(name = "exp_date")
    private Date expDate;

    @Column(name = "has_deleted")
    private boolean hasDeleted;

    @Column(name = "lastaction")
    private String lastaction;

    @Column(name = "lastmodified")
    private Timestamp lastmodified;

    @Nationalized
    @Column(name = "notes")
    private String notes;

    @Column(name = "provider_contact_id")
    private int providerContactId;

    @Column(name = "provider_group_id")
    private int providerGroupId;

    @Column(name = "provider_id")
    private int providerId;

    @Column(name = "reminder_date")
    private Date reminderDate;

    @Column(name = "start_date")
    private Date startDate;
}
