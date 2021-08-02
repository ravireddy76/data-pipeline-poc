package com.cdi.so.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan(basePackages = {"com.cdi.so.di"})
@EntityScan(basePackages = {"com.cdi.domain"})
@EnableJpaRepositories(basePackages = {"com.cdi.domain.repository"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class})
public class SchedulingOfficeIngestApp {
    public static void main(String[] args) {
        SpringApplication.run(SchedulingOfficeIngestApp.class, args);
    }
}
