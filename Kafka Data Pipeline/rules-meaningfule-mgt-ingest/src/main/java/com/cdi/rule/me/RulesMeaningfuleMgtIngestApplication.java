package com.cdi.rule.me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan(basePackages = {"com.cdi.rule.me;"})
@EntityScan(basePackages = {"com.cdi.domain"})
@EnableJpaRepositories(basePackages = {"com.cdi.domain.repository"})
public class RulesMeaningfuleMgtIngestApplication {

	public static void main(String[] args) {

		SpringApplication.run(RulesMeaningfuleMgtIngestApplication.class, args);
	}

}
