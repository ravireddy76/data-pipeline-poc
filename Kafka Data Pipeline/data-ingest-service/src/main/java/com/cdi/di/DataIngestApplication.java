package com.cdi.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan(basePackages = {"com.cdi.di"})
@EnableJpaRepositories(basePackages = {"com.cdi.di.repository"})
public class DataIngestApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataIngestApplication.class, args);
    }
}
