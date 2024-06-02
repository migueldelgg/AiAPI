package br.com.migueldelgado.spring_boot_chatgpt.config;

import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean //sobreescrevendo uma implementacao que ja existe
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("Startup Idea API").
                        description("API responsavel por geração de ideias de startups inovadoras.").
                        version("1"));
    }

}


