package com.cdi.de.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Alert entity is used to map the data of
 * <p>
 * <i> <b>Table = alerts </b> under <br/>
 * <b>Schema = poc_catalog </b> with in the enterprise application. </i>
 * </p>
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI Corporation. It's Illegal to reproduce this code.
 */
@Entity
@Table(name = "alerts", schema = "public")
@Data
@NoArgsConstructor
public class Alerts {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "company_id", nullable = false)
    private Integer companyId;

    @Column(name = "description", nullable = false)
    private String description;
}
