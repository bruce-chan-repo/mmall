package com.imock.mmall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置类.
 * @author: Chen Kj
 * @date: 2018/8/21 14:18
 * @version: 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.imock.mmall.web"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Mmall RESTFul APIs")
                .description("使用中有问题，请联系开发人员 940075318@qq.com")
                .termsOfServiceUrl("www.baidu.com")
                .contact("OldChen")
                .version("1.0")
                .build();
    }
}
