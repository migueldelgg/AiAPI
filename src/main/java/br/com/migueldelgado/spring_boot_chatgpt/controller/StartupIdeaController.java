package br.com.migueldelgado.spring_boot_chatgpt.controller;

import br.com.migueldelgado.spring_boot_chatgpt.dto.ChatGPTRequest;
import br.com.migueldelgado.spring_boot_chatgpt.dto.ChatGPTResponse;
import br.com.migueldelgado.spring_boot_chatgpt.service.StartupIdeaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/startupidea")
@Tag(name = "Startup Idea", description = "Informações da aplicação")
public class StartupIdeaController {

    @Autowired
    private StartupIdeaService service;

    @Operation(summary = "Query para aplicação",
            description = "Essa função é responsável por executar a Query do usuario para a API da Open AI.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = ChatGPTResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "No response.")
    })
    @GetMapping("/chat")
    public String chat(@RequestParam String userPrompt) {

        return service.execute(userPrompt);
    }

}
