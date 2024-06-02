package br.com.migueldelgado.spring_boot_chatgpt.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/startupidea")
public class StartupIdeaController {

    private final ChatClient chatClient;

    public StartupIdeaController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/chat")
    public ChatResponse generation(@RequestParam(value = "message",
            defaultValue = "De ideias de startups inovadoras para o futuro.") String message) {

        ChatResponse response = chatClient.prompt().user(message).call().chatResponse();

        return response;
    }

}
