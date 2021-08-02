package com.cdi.di.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class BaseEntity {
    @Id
    @Column(name = "id")
    private int id;

}
