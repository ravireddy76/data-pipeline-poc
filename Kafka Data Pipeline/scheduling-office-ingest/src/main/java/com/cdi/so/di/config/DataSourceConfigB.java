package com.cdi.so.di.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "dsbEntityManagerFactory",
transactionManagerRef = "dsbTransactionManager",
basePackages = {"com.cdi.domain.dsb.repo"})
public class DataSourceConfigB {

    @Autowired
    private Environment env;

    @Bean(name = "dsbDataSource")
    @ConfigurationProperties(prefix = "spring.dsb")
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.dsb.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.dsb.url"));
        dataSource.setUsername(env.getProperty("spring.dsb.username"));
        dataSource.setPassword(env.getProperty("spring.dsb.password"));
        return dataSource;
    }

    @Bean(name = "dsbEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean dsbEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("dsbDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("com.cdi.domain.model")
                .persistenceUnit("dsbDS")
                .build();
    }

    @Bean(name = "dsbTransactionManager")
    public PlatformTransactionManager dsaTransactionManager(@Qualifier("dsbEntityManagerFactory") EntityManagerFactory dsbEntityManagerFactory) {
        return new JpaTransactionManager(dsbEntityManagerFactory);
    }

}
