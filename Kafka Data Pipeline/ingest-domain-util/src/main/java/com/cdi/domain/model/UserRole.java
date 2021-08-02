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

/**
 * UserRole entity is used to map the data of
 * <p>
 * <i> <b>Table = user_groups </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "user_groups", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserRole extends BaseEntity {

    @Column(name = "company_id")
    private int companyId;

    @Column(name = "deleted_dt")
    private OffsetDateTime deletedDt;

    @Column(name = "has_deleted")
    private boolean hasDeleted;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "LastAction")
    private String lastAction;

    @Column(name = "LastModified")
    private Timestamp lastModified;

    @Nationalized
    @Column(name = "permissions")
    private String permissions;

    @Nationalized
    @Column(name = "role_description")
    private String roleDescription;

    @Nationalized
    @Column(name = "role_name")
    private String roleName;
}
