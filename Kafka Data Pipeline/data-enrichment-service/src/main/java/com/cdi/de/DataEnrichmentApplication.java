package com.cdi.de;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan(basePackages = {"com.cdi.de"})
public class DataEnrichmentApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataEnrichmentApplication.class, args);
    }
}
