package com.cdi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * ApplicationEntity entity is used to map the data of
 * <p>
 * <i> <b>Table = application_entities </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name="application_entities",schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ApplicationEntity extends BaseEntity {

    @Nationalized
    @Column(name="ae_info")
    private String aeInfo;

    @Nationalized
    @Column(name="ae_info_acc_no_issuer")
    private String aeInfoAccNoIssuer;

    @Nationalized
    @Column(name="ae_info_ae_description")
    private String aeInfoAeDescription;

    @Nationalized
    @Column(name="ae_info_ae_group")
    private String aeInfoAeGroup;

    @Nationalized
    @Column(name="ae_info_artrim_timeout")
    private String aeInfoArtrimTimeout;

    @Nationalized
    @Column(name="ae_info_border_margins")
    private String aeInfoBorderMargins;

    @Nationalized
    @Column(name="ae_info_concurrent_transfers")
    private String aeInfoConcurrentTransfers;

    @Nationalized
    @Column(name="ae_info_department")
    private String aeInfoDepartment;

    @Nationalized
    @Column(name="ae_info_disable_qc2live")
    private String aeInfoDisableQc2live;

    @Nationalized
    @Column(name="ae_info_ignore_scan_documents")
    private String aeInfoIgnoreScanDocuments;

    @Nationalized
    @Column(name="ae_info_institution")
    private String aeInfoInstitution;

    @Nationalized
    @Column(name="ae_info_is_de")
    private String aeInfoIsDe;

    @Nationalized
    @Column(name="ae_info_issuer")
    private String aeInfoIssuer;

    @Nationalized
    @Column(name="ae_info_max_pdu_length")
    private String aeInfoMaxPduLength;

    @Nationalized
    @Column(name="ae_info_password")
    private String aeInfoPassword;

    @Nationalized
    @Column(name="ae_info_patient_id_issuer")
    private String aeInfoPatientIdIssuer;

    @Nationalized
    @Column(name="ae_info_read_timeout")
    private String aeInfoReadTimeout;

    @Nationalized
    @Column(name="ae_info_retries")
    private String aeInfoRetries;

    @Nationalized
    @Column(name="ae_info_send_annotation_as")
    private String aeInfoSendAnnotationAs;

    @Nationalized
    @Column(name="ae_info_send_one_image_per_study")
    private String aeInfoSendOneImagePerStudy;

    @Nationalized
    @Column(name="ae_info_send_unique_image_uid")
    private String aeInfoSendUniqueImageUid;

    @Nationalized
    @Column(name="ae_info_station_name")
    private String aeInfoStationName;

    @Nationalized
    @Column(name="ae_info_transfer_syntax_receive")
    private String aeInfoTransferSyntaxReceive;

    @Nationalized
    @Column(name="ae_info_transfer_syntax_send")
    private String aeInfoTransferSyntaxSend;

    @Nationalized
    @Column(name="ae_info_true_size")
    private String aeInfoTrueSize;

    @Nationalized
    @Column(name="ae_info_user_id")
    private String aeInfoUserId;

    @Nationalized
    @Column(name="ae_info_wadourl")
    private String aeInfoWadourl;

    @Nationalized
    @Column(name="ae_info_write_timeout")
    private String aeInfoWriteTimeout;

    @Nationalized
    @Column(name="ae_title")
    private String aeTitle;

    @Nationalized
    @Column(name="ae_type")
    private String aeType;

    @Nationalized
    @Column(name="ae_type2")
    private String aeType2;

    @Nationalized
    @Column(name="ae_types")
    private String aeTypes;

    @Nationalized
    @Column(name="cipher_suites")
    private String cipherSuites;

    @Column(name="company_id")
    private int companyId;

    @Nationalized
    @Column(name="deleted_dt")
    private String deletedDt;

    @Nationalized
    @Column(name="facilities")
    private String facilities;

    @Column(name="facility_id")
    private int facilityId;

    @Column(name="file_store_id")
    private int fileStoreId;

    @Column(name="has_deleted")
    private boolean hasDeleted;

    @Column(name="has_installed")
    private boolean hasInstalled;

    @Column(name="has_registered")
    private boolean hasRegistered;

    @Nationalized
    @Column(name="host_name")
    private String hostName;

    @Column(name="include_approved_report")
    private boolean includeApprovedReport;

    @Column(name="is_active")
    private boolean isActive;

    @Column(name="is_sde")
    private boolean isSde;

    @Column(name="issuer_id")
    private long issuerId;

    @Nationalized
    @Column(name="LastAction")
    private String lastAction;

    @Column(name="LastModified")
    private Timestamp lastModified;

    @Nationalized
    @Column(name="modalities")
    private String modalities;

    @Nationalized
    @Column(name="mwl_modalities")
    private String mwlModalities;

    @Column(name="port")
    private int port;

    @Column(name="requires_ssl")
    private boolean requiresSsl;

    @Nationalized
    @Column(name="send_annotation_as")
    private String sendAnnotationAs;

    @Column(name="send_unique_image_uid")
    private boolean sendUniqueImageUid;

    @Nationalized
    @Column(name="src_ae_title")
    private String srcAeTitle;

    @Nationalized
    @Column(name="vehicle_id")
    private String vehicleId;
}
