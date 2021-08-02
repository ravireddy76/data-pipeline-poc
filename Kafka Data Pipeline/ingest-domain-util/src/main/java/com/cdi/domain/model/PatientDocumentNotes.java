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
 * PatientDocumentNotes entity is used to map the data of
 * <p>
 * <i> <b>Table = patient_document_notes </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "patient_document_notes", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PatientDocumentNotes extends BaseEntity {

    @Column(name = "created_by")
    private BigInteger createdBy;

    @Column(name = "created_dt")
    private OffsetDateTime createdDt;

    @Column(name = "LastAction")
    private String lastAction;

    @Column(name = "LastModified")
    private Timestamp lastModified;

    @Nationalized
    @Column(name = "note")
    private String note;

    @Column(name = "patient_document_id")
    private BigInteger patientDocumentId;
}
