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
 * PatientAccessReason entity is used to map the data of
 * <p>
 * <i> <b>Table = patient_access_reasons </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "patient_access_reasons", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PatientAccessReason extends BaseEntity {

    @Nationalized
    @Column(name = "code")
    private String code;

    @Column(name="company_id")
    private long companyId;

    @Nationalized
    @Column(name = "description")
    private String description;

    @Column(name="is_default")
    private boolean isDefault;

    @Column(name="LastAction")
    private String lastAction;

    @Column(name="LastModified")
    private Timestamp lastModified;
}
