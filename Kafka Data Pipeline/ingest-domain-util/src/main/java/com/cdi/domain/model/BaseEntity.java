package com.cdi.domain.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * BaseEntity class used as a parent class for the tables which primary key(PK) data type is "int".
 *
 * @author Ravi
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Data
@MappedSuperclass
public class BaseEntity {
    @Id
    @Column(name = "id")
    private long id;

}
