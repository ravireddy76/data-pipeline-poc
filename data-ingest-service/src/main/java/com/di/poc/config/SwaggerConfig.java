package com.di.poc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static com.google.common.collect.Lists.newArrayList;

/**
 * SwaggerConfig class used for API documentation and provides html page.
 *
 * @author Ravi Reddy
 * @CopyRight (C) All rights reserved to Ravi POC Inc. It's Illegal to reproduce this code.
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket apiDoc() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Data Ingest Service")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.di.poc.controller"))
                .build()
                .useDefaultResponseMessages(true)
                .tags(new Tag("Data Ingest Service", "Data Ingest service to ingesting data into destination"))
                .globalResponseMessage(RequestMethod.GET,
                        newArrayList(getResponseMessageBuilder(200),
                                getResponseMessageBuilder(500)))
                .globalResponseMessage(RequestMethod.POST,
                        newArrayList(getResponseMessageBuilder(200),
                                getResponseMessageBuilder(500)))
                .globalResponseMessage(RequestMethod.PUT,
                        newArrayList(getResponseMessageBuilder(200),
                                getResponseMessageBuilder(500)))
                .globalResponseMessage(RequestMethod.DELETE,
                        newArrayList(getResponseMessageBuilder(200),
                                getResponseMessageBuilder(500)))
                .apiInfo(apiInfo());
    }

    /**
     * <p>This method is for building the ResponseMessage.<p/>
     *
     * @param statusCode
     */
    private ResponseMessage getResponseMessageBuilder(int statusCode) {
        ResponseMessageBuilder messageBuilder = new ResponseMessageBuilder();
        return messageBuilder.code(statusCode)
                .message("Success")
                .responseModel(new ModelRef("Void")).build();

    }

    /**
     * This method to build api info.
     *
     * @return ApiInfo
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Data Ingest service is micro service to ingest data into destination")
                .description("Data Ingest service is micro service to ingest data into destination.")
                .contact(new Contact("Data Ingest service", null, "ravireddy76@gmail.com"))
                .version("2.0")
                .build();
    }

}
