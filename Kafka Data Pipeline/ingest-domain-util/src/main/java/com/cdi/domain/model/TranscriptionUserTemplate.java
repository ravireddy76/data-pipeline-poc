package com.cdi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.OffsetDateTime;

/**
 * TranscriptionUserTemplate entity is used to map the data of
 * <p>
 * <i> <b>Table = transcription_user_templates </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "transcription_user_templates", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TranscriptionUserTemplate extends BaseEntity {

    @Nationalized
    @Column(name = "template_name")
    private String templateName;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "user_id")
    private boolean userId;

    @Column(name = "company_id")
    private int companyId;

    @Column(name = "is_global")
    private boolean isGlobal;

    @Column(name = "has_deleted")
    private boolean hasDeleted;

    @Column(name = "deleted_dt")
    private OffsetDateTime deletedDt;

    @Nationalized
    @Column(name = "text_text")
    private String textText;

    @Nationalized
    @Column(name = "modalities")
    private String modalities;

    @Nationalized
    @Column(name = "body_parts")
    private String bodyParts;

    @Nationalized
    @Column(name = "study_descriptions")
    private String studyDescriptions;

    @Nationalized
    @Column(name = "institutions")
    private String institutions;

    @Column(name = "all_match")
    private boolean allMatch;

    @Nationalized
    @Column(name = "appointment_type_ids")
    private String appointmentTypeIds;

    @Nationalized
    @Column(name = "user_ids")
    private String userIds;

    @Nationalized
    @Column(name = "facilities")
    private String facilities;

    @Column(name = "LastAction")
    private String lastAction;

    @Column(name = "LastModified")
    private Timestamp lastModified;
}
