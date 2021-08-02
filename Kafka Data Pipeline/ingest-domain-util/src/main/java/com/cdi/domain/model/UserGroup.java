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
 * UserGroup entity is used to map the data of
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
public class UserGroup extends BaseEntity {

    @Column(name = "ad_group_id")
    private int adGroupId;

    @Column(name = "can_delete")
    private boolean canDelete;

    @Column(name = "company_id")
    private int companyId;

    @Column(name = "deleted_dt")
    private OffsetDateTime deletedDt;

    @Nationalized
    @Column(name = "document_types")
    private String documentTypes;

    @Nationalized
    @Column(name = "group_code")
    private String groupCode;

    @Nationalized
    @Column(name = "group_description")
    private String groupDescription;

    @Nationalized
    @Column(name = "group_info")
    private String groupInfo;

    @Nationalized
    @Column(name = "group_info_user_nav")
    private String groupInfoUserNav;

    @Nationalized
    @Column(name = "group_name")
    private String groupName;

    @Nationalized
    @Column(name = "group_type")
    private String groupType;

    @Column(name = "has_deleted")
    private boolean hasDeleted;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "LastAction")
    private String lastAction;

    @Column(name = "LastModified")
    private Timestamp lastModified;

    @Column(name = "user_roles")
    private int userRoles;
}
