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
 * PeerReviewStudyDescription entity is used to map the data of
 * <p>
 * <i> <b>Table = peer_review_study_descriptions </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "peer_review_study_descriptions", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProviderAltName extends BaseEntity {

    @Column(name = "deleted_dt")
    private OffsetDateTime deletedDt;

    @Nationalized
    @Column(name = "dicom_name")
    private String dicomName;

    @Nationalized
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "has_deleted")
    private boolean hasDeleted;

    @Nationalized
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "lastaction")
    private String lastaction;

    @Column(name = "lastmodified")
    private Timestamp lastmodified;

    @Nationalized
    @Column(name = "middle_initial")
    private String middleInitial;

    @Column(name = "provider_id")
    private int providerId;

    @Nationalized
    @Column(name = "suffix")
    private String suffix;
}
