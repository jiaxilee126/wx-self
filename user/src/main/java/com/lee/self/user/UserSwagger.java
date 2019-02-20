package com.lee.self.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName UserSwagger
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/19 11:50
 */
@Configuration
@EnableSwagger2
public class UserSwagger {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.lee.self.user.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    public ApiInfo apiInfo () {
        return new ApiInfoBuilder()
                //页面标题
                .title("用户api调用接口")
                //创建人
                .contact(new Contact("Jussi Lee", "https://github.com/jiaxilee126/wx-self", ""))
                //版本号
                .version("1.0")
                //描述
                .description("API调用接口")
                .build();
    }
}
