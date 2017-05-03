package com.gxq;

import com.google.common.base.Predicate;
import com.gxq.controller.EfanController;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Created by xuenianxiang on 2017/4/5.
 */

@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {

        Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
            @Override
            public boolean apply(RequestHandler input) {
                Class<?> declaringClass = input.declaringClass();

                if (declaringClass == EfanController.class){
                    return true;
                }else {
                    return false;
                }


//                if (declaringClass == BasicErrorController.class)// 排除
//                    return false;
//                if(declaringClass.isAnnotationPresent(RestController.class)) // 被注解的类
//                    return true;
//                if(input.isAnnotatedWith(ResponseBody.class)) // 被注解的方法
//                    return true;
//                return false;
            }
        };

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(predicate)
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("广告管理接口")
                .version("1.0")
                .build();
    }
}
