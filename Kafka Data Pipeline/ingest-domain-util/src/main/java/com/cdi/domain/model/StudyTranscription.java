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
 * StudyTranscription entity is used to map the data of
 * <p>
 * <i> <b>Table = study_transcriptions </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "study_transcriptions", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class StudyTranscription extends BaseEntity {

    @Column(name = "addendum_no")
    private int addendumNo;

    @Column(name = "approved_dt")
    private OffsetDateTime approvedDt;

    @Column(name = "approving_provider_id")
    private int approvingProviderId;

    @Column(name = "created_by")
    private int createdBy;

    @Column(name = "created_dt")
    private OffsetDateTime createdDt;

    @Column(name = "has_locked")
    private boolean hasLocked;

    @Column(name = "LastAction")
    private String lastAction;

    @Column(name = "LastModified")
    private Timestamp lastModified;

    @Column(name = "linked_studies")
    private long linkedStudies;

    @Column(name = "locked_dt")
    private OffsetDateTime lockedDt;

    @Column(name = "pre_approved_dt")
    private OffsetDateTime preApprovedDt;

    @Column(name = "pre_approved_provider_contact_id")
    private int preApprovedProviderContactId;

    @Column(name = "study_id")
    private long studyId;

    @Column(name = "text_type")
    private String textType;

    @Column(name = "transcribing_user")
    private int transcribingUser;

    @Nationalized
    @Column(name = "transcription_data")
    private String transcriptionData;

    @Nationalized
    @Column(name = "transcription_text")
    private String transcriptionText;

    @Column(name = "transcription_type")
    private String transcriptionType;

    @Column(name = "unlocked_dt")
    private OffsetDateTime unlockedDt;

    @Column(name = "updated_dt")
    private OffsetDateTime updatedDt;
}
