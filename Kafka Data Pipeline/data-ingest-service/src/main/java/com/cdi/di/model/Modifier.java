package com.cdi.di.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Modifier entity is used to map the data of
 * <p>
 * <i> <b>Table = modifiers </b> under <br/>
 * <b>Schema = pub </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@Entity
@Table(name = "modifiers", schema = "pub")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Modifier extends BaseEntity {

    @Nationalized
    @Column(name = "code")
    private String code;

    @Column(name = "company_id")
    private long companyId;

    @Nationalized
    @Column(name = "description")
    private String description;

    @Column(name = "lastaction")
    private String lastaction;

    @Column(name = "lastmodified")
    private Timestamp lastmodified;

    @Nationalized
    @Column(name = "level")
    private String level;

    @Column(name = "modifier_amount")
    private BigDecimal modifierAmount;

    @Column(name = "modifier1")
    private boolean modifier1;

    @Column(name = "modifier2")
    private boolean modifier2;

    @Column(name = "modifier3")
    private boolean modifier3;

    @Column(name = "modifier4")
    private boolean modifier4;

    @Column(name = "override_amount")
    private BigDecimal overrideAmount;

    @Nationalized
    @Column(name = "sign")
    private String sign;

    @Nationalized
    @Column(name = "type")
    private String type;

}
