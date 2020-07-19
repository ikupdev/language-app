package ru.kuper.restswag;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RestSwagApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestSwagApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(LanguageRepo languageRepo) {
        return args -> {
            languageRepo.save(new Language().setName("name1").setAuthor("author1"));
            languageRepo.save(new Language().setName("name2").setAuthor("author2"));

        };
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }




}
