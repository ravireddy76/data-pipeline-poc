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
 * TranscriptionTemplate entity is used to map the data of
 * <p>
 * <i> <b>Table = transcription_templates </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "transcription_templates", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TranscriptionTemplate extends BaseEntity {

    @Column(name = "company_id")
    private int companyId;

    @Column(name = "deleted_dt")
    private OffsetDateTime deletedDt;

    @Nationalized
    @Column(name = "facilities")
    private String facilities;

    @Column(name = "has_deleted")
    private boolean hasDeleted;

    @Nationalized
    @Column(name = "institutions")
    private String institutions;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "LastAction")
    private String lastAction;

    @Column(name = "LastModified")
    private Timestamp lastModified;

    @Column(name = "margin_bottom")
    private BigDecimal marginBottom;

    @Column(name = "margin_left")
    private BigDecimal marginLeft;

    @Column(name = "margin_right")
    private BigDecimal marginRight;

    @Column(name = "margin_top")
    private BigDecimal marginTop;

    @Nationalized
    @Column(name = "modalities")
    private String modalities;

    @Nationalized
    @Column(name = "page_footer")
    private String pageFooter;

    @Nationalized
    @Column(name = "page_header")
    private String pageHeader;

    @Nationalized
    @Column(name = "report_body")
    private String reportBody;

    @Nationalized
    @Column(name = "report_footer")
    private String reportFooter;

    @Nationalized
    @Column(name = "report_header")
    private String reportHeader;

    @Nationalized
    @Column(name = "report_options")
    private String reportOptions;

    @Nationalized
    @Column(name = "study_descriptions")
    private String studyDescriptions;

    @Nationalized
    @Column(name = "summary")
    private String summary;

    @Nationalized
    @Column(name = "template_info")
    private String templateInfo;

    @Nationalized
    @Column(name = "template_name")
    private String templateName;

    @Nationalized
    @Column(name = "text_type")
    private String textType;

    @Column(name = "user_id")
    private int userId;
}
