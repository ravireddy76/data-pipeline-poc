package com.cdi.domain.repository;

import com.cdi.domain.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


/**
 * DataRepository class used to persist data into tables for given entity.
 *
 * @author Ravi Reddy
 * @CopyRight (C) All rights reserved to CDI. It's Illegal to reproduce this code.
 */
@Repository
@Transactional
public interface DataRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
}
