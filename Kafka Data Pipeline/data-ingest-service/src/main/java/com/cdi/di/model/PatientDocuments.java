package com.cdi.di.model;

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
 * PatientDocuments entity is used to map the data of
 * <p>
 * <i> <b>Table = patient_documents </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "patient_documents", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PatientDocuments extends BaseEntity {

    @Column(name = "created_by")
    private int createdBy;

    @Column(name = "created_dt")
    private OffsetDateTime createdDt;

    @Column(name = "created_dt_display")
    private OffsetDateTime createdDtDisplay;

    @Column(name = "deleted_dt")
    private OffsetDateTime deletedDt;

    @Column(name = "doc_level")
    private int docLevel;

    @Column(name = "document_count")
    private int documentCount;

    @Nationalized
    @Column(name = "document_file_dir")
    private String documentFileDir;

    @Nationalized
    @Column(name = "document_file_name")
    private String documentFileName;

    @Nationalized
    @Column(name = "document_file_type")
    private String documentFileType;

    @Nationalized
    @Column(name = "document_info")
    private String documentInfo;

    @Nationalized
    @Column(name = "document_info_encounterid")
    private String documentInfoEncounterid;

    @Nationalized
    @Column(name = "document_info_importid")
    private String documentInfoImportid;

    @Nationalized
    @Column(name = "document_info_requestedby")
    private String documentInfoRequestedby;

    @Nationalized
    @Column(name = "document_source")
    private String documentSource;

    @Nationalized
    @Column(name = "document_type")
    private String documentType;

    @Column(name = "documents_uploaded")
    private int documentsUploaded;

    @Column(name = "file_store_id")
    private int fileStoreId;

    @Column(name = "has_completed")
    private boolean hasCompleted;

    @Column(name = "has_deleted")
    private boolean hasDeleted;

    @Nationalized
    @Column(name = "instance_uid")
    private String instanceUid;

    @Column(name = "lab_order_id")
    private BigInteger labOrderId;

    @Column(name = "lab_order_test_id")
    private BigInteger labOrderTestId;

    @Column(name = "LastAction")
    private String lastAction;

    @Column(name = "LastModified")
    private Timestamp lastModified;

    @Column(name = "order_id")
    private BigInteger orderId;

    @Column(name = "patient_id")
    private BigInteger patientId;

    @Column(name = "provider_contact_id")
    private int providerContactId;

    @Column(name = "provider_group_id")
    private int providerGroupId;

    @Column(name = "provider_id")
    private int providerId;

    @Nationalized
    @Column(name = "series_uid")
    private String seriesUid;

    @Column(name = "study_id")
    private BigInteger studyId;
}
