package com.cdi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * IcdCode entity is used to map the data of
 * <p>
 * <i> <b>Table = icd_codes </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "icd_codes", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class IcdCode extends BaseEntity {

    @Nationalized
    @Column(name="code")
    private String code;

    @Nationalized
    @Column(name="code_type")
    private String codeType;

    @Column(name="company_id")
    private int companyId;

    @Column(name="created_dt")
    private Timestamp createdDt;

    @Nationalized
    @Column(name="deleted_dt")
    private String deletedDt;

    @Nationalized
    @Column(name="description")
    private String description;

    @Column(name="has_deleted")
    private boolean hasDeleted;

    @Column(name="is_active")
    private boolean isActive;

    @Column(name="LastAction")
    private String lastAction;

    @Column(name="LastModified")
    private Timestamp lastModified;
}
