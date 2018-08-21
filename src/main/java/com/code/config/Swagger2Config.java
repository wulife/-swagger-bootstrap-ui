package com.code.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * swagger 配置类
 *
 * @author ww
 * @date 2018/8/14
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {


    @Bean(value = "defaultApi")
    @Order(value = 4)
    public Docket defaultApi() {
        ParameterBuilder parameterBuilder=new ParameterBuilder();
        List<Parameter> parameters= Lists.newArrayList();
        parameterBuilder.name("token").description("token令牌").modelRef(new ModelRef("String"))
                .parameterType("header").defaultValue("abc")
                .required(true).build();
        parameters.add(parameterBuilder.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("默认接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.code.controller"))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(parameters)
                .securityContexts(Lists.newArrayList(securityContext(),securityContext1())).securitySchemes(Lists.<SecurityScheme>newArrayList(apiKey(),apiKey1()));
    }

    @Bean(value = "groupRestApi")
    @Order(value = 1)
    public Docket groupRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(groupApiInfo())
                .groupName("分组接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.code.controller"))
                .paths(PathSelectors.any())
                .build().securityContexts(Lists.newArrayList(securityContext(),securityContext1())).securitySchemes(Lists.<SecurityScheme>newArrayList(apiKey(),apiKey1()));
    }
    private ApiInfo groupApiInfo(){
        return new ApiInfoBuilder()
                .title("分组Api")
                .description("分组api文档")
                .termsOfServiceUrl("http://www.wodolife.cn")
                .contact(new Contact("wwei", "http://127.0.0.1:520/doc.html", "1459770665@qq.com"))
                .build();
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("java api默认文档接口测试")
                .description("***系统接口文档")
                .termsOfServiceUrl("http://www.wodolife.cn")
                .contact(new Contact("wwei", "http://127.0.0.1:520/doc.html", "1459770665@qq.com"))
                .build();
    }
//    @Bean
//    public Docket buildDocket(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.code.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }
    private ApiKey apiKey() {
        return new ApiKey("BearerToken", "Authorization", "header");
    }
    private ApiKey apiKey1() {
        return new ApiKey("BearerToken1", "Authorization-x", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }
    private SecurityContext securityContext1() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth1())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("BearerToken", authorizationScopes));
    }
    List<SecurityReference> defaultAuth1() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("BearerToken1", authorizationScopes));
    }
}
