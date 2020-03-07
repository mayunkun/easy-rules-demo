/**
 * Copyright (c) 2016-2019 aoruntaikang All rights reserved.
 * <p>
 * https://www.aoruntaikang.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.aeert.easyrules.common.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("轻量级规则引擎easy-rules使用")
                .description("轻量级规则引擎easy-rules使用demo")
                .termsOfServiceUrl("http://www.aeert.com")
                .version("3.4.0")
                .build();
    }

    @Bean
    public Docket easyRulesApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("轻量级规则引擎easy-rules使用")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.aeert.easyrules.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(security());
    }

    private List<ApiKey> security() {
        return newArrayList(
                new ApiKey("token", "token", "header")
        );
    }

}