package com.fiap.avaliacoes.api.config;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiV2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(regex("/avaliacoes/.*")).build()
                .apiInfo(apiInfo())
                .globalResponseMessage(RequestMethod.GET, Lists.newArrayList(
                        new ResponseMessageBuilder()
                                .code(404)
                                .message("Não foram encontrados resultados para sua busca.")
                                .build(),
                        new ResponseMessageBuilder()
                                .code(204)
                                .message("Resposta sem conteudo.")
                                .build()
                ))
                .globalResponseMessage(RequestMethod.POST, Lists.newArrayList(
                        new ResponseMessageBuilder()
                                .code(201)
                                .message("A API retorna uma mensagem de sucesso e o id do objeto cadastrado.")
                                .build(),
                        new ResponseMessageBuilder()
                                .code(200)
                                .message("A API retorna uma mensagem de sucesso.")
                                .build(),
                        new ResponseMessageBuilder()
                                .code(400)
                                .message("A API retorna a causa do erro junto com o campo e o objeto incorretos.")
                                .build()
                ));

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Avaliações API")
                .description("Documentação da Avaliações API")
                .version("2.0")
                .build();
    }


}
