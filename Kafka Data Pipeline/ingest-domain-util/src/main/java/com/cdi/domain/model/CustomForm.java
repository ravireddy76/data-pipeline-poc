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
 * CustomForm entity is used to map the data of
 * <p>
 * <i> <b>Table = custom_forms </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "custom_forms", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class CustomForm extends BaseEntity {

    @Column(name="allow_patient_to_view")
    private boolean allowPatientToView;

    @Nationalized
    @Column(name="assign_options")
    private String assignOptions;

    @Column(name="company_id")
    private int companyId;

    @Nationalized
    @Column(name="deleted_dt")
    private String deletedDt;

    @Nationalized
    @Column(name="description")
    private String description;

    @Nationalized
    @Column(name="document_content")
    private String documentContent;

    @Nationalized
    @Column(name="document_name")
    private String documentName;

    @Column(name="facilities")
    private int facilities;

    @Nationalized
    @Column(name="form_flag")
    private String formFlag;

    @Nationalized
    @Column(name="form_type")
    private String formType;

    @Column(name="has_deleted")
    private boolean hasDeleted;

    @Nationalized
    @Column(name="icd_codes")
    private String icdCodes;

    @Column(name="insurance_providers")
    private int insuranceProviders;

    @Column(name="is_active")
    private boolean isActive;

    @Column(name="is_mammo_sheet")
    private boolean isMammoSheet;

    @Nationalized
    @Column(name="lab_code_id")
    private String labCodeId;

    @Column(name="LastAction")
    private String lastAction;

    @Column(name="LastModified")
    private Timestamp lastModified;

    @Nationalized
    @Column(name="medication_drugs")
    private String medicationDrugs;

    @Column(name="modalities")
    private int modalities;

    @Column(name="referring_providers")
    private int referringProviders;
}
