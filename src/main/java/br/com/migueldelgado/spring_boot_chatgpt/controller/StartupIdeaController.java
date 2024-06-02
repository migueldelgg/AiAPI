package br.com.migueldelgado.spring_boot_chatgpt.controller;

import br.com.migueldelgado.spring_boot_chatgpt.dto.ChatGPTRequest;
import br.com.migueldelgado.spring_boot_chatgpt.dto.ChatGPTResponse;
import br.com.migueldelgado.spring_boot_chatgpt.dto.Message;
import br.com.migueldelgado.spring_boot_chatgpt.service.StartupIdeaService;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import java.util.List;


@RestController
@RequestMapping("/startupidea")
public class StartupIdeaController {

    @Value("${openai.api.model}")
    private String model;

    @Value("${openai.api.url}")
    private String url;

    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate template;

    @Autowired
    private StartupIdeaService service;

    @GetMapping("/chat")
    public String generation(@RequestParam(value = "message",
            defaultValue = "De ideias de startups inovadoras para o futuro.") String message) {

        String response = service.execute(message);

        return response;
    }

    @GetMapping("/chat_two")
    public String chat(@RequestParam String userPrompt) {

        var prompt = service.execute(userPrompt);

        // create a request
        ChatGPTRequest request = new ChatGPTRequest(model, prompt);

        // call the API
        ChatGPTResponse response = template.postForObject(url, request, ChatGPTResponse.class);

        if (response == null || response.choices() == null || response.choices().isEmpty()) {
            return "No response";
        }

        // return the first response
        return response.choices().get(0).message().content();
    }

}
