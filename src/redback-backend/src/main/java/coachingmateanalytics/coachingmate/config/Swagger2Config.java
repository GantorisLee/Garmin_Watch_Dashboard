package coachingmateanalytics.coachingmate.config;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @Auther: Qi Li, Yu Wu
 * @Date: 23/4/22 16:10
 * @Description:
 * add swagger option, easy to develop for front end developer
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {
    private static final Logger LOGGER = LoggerFactory.getLogger(Swagger2Config.class);

    @Bean
    public Docket swaggerDocket(){
        LOGGER.debug("Coachingmate2022--API configuration");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().description("Coachingmate2022 API")
                .contact(new Contact("Saul", "http://localhost:8080/index.html", "rance.liki@gmail.com"))
                .version("2.0.0")
                .termsOfServiceUrl("http://47.74.88.139:8080/")
                .build();
    }
}
