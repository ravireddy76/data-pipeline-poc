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
 * PeerReviewCptCodes entity is used to map the data of
 * <p>
 * <i> <b>Table = peer_review_cpt_codes </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "peer_review_cpt_codes", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PeerReviewCptCodes extends BaseEntity {

    @Nationalized
    @Column(name = "condition")
    private String condition;

    @Column(name = "cpt_code_id")
    private int cptCodeId;

    @Column(name = "LastAction")
    private String lastAction;

    @Column(name = "LastModified")
    private Timestamp lastModified;

    @Column(name = "provider_id")
    private int providerId;
}
