package com.cdi.di.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * CallLog entity is used to map the data of
 * <p>
 * <i> <b>Table = call_log </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name="call_log", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class CallLog extends BaseEntity {

    @Column(name="call_category_id")
    private int callCategoryId;

    @Column(name="created_by")
    private int createdBy;

    @Column(name="created_dt")
    private Timestamp createdDt;

    @Column(name="LastAction")
    private String lastAction;

    @Column(name="LastModified")
    private Timestamp lastModified;

    @Column(name="note")
    private String note;

    @Column(name="study_id")
    private BigInteger studyId;
}
