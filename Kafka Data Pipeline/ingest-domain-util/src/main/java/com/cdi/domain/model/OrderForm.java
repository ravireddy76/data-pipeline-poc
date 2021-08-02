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
 * OrderForm entity is used to map the data of
 * <p>
 * <i> <b>Table = order_forms </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "order_forms", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class OrderForm extends BaseEntity {

    @Column(name = "custom_form_id")
    private BigInteger customFormId;

    @Nationalized
    @Column(name = "document_html")
    private String documentHtml;

    @Nationalized
    @Column(name = "document_options")
    private String documentOptions;

    @Column(name = "LastAction")
    private String lastAction;

    @Column(name = "LastModified")
    private Timestamp lastModified;

    @Column(name = "order_id")
    private BigInteger orderId;

    @Nationalized
    @Column(name = "signature_image")
    private String signatureImage;

    @Nationalized
    @Column(name = "signature_integrity_hmac")
    private String signatureIntegrityHmac;

    @Nationalized
    @Column(name = "signed_by")
    private String signedBy;

    @Nationalized
    @Column(name = "signed_by_entity")
    private String signedByEntity;

    @Column(name = "signed_date")
    private OffsetDateTime signedDate;
}
