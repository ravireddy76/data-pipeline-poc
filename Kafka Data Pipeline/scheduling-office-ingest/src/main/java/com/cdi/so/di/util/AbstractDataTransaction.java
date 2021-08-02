package com.cdi.so.di.util;

import com.cdi.domain.dsa.repo.DsaRepository;
import com.cdi.domain.dsb.repo.DsbRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AbstractDataTransaction class used to ingest data into multiple data sources.
 *
 * @author Ravi Reddy
 * @CopyRight (C) All rights reserved to CDI Inc. It's Illegal to reproduce this code.
 */
@Service
@Slf4j
public class AbstractDataTransaction {

    @Autowired
    private DsaRepository dsaRepository;

    @Autowired
    private DsbRepository dsbRepository;

    /**
     * Method to ingest the data into multiple data sources for given entity.
     *
     * @param entity
     * @param <T>
     */
    public <T> void ingestData(T entity) {
        dsaRepository.save(entity);
        dsbRepository.save(entity);
        log.info("{} data is ingested into all data sources ", entity.getClass().getSimpleName());
    }
}
