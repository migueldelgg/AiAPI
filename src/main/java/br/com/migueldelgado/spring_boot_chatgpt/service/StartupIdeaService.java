package br.com.migueldelgado.spring_boot_chatgpt.service;

import br.com.migueldelgado.spring_boot_chatgpt.dto.Message;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.ChatOptionsBuilder;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StartupIdeaService {

    private final String apiKey;

    private final ChatClient chatClient;

    public StartupIdeaService(ChatClient.Builder chatClientBuilder,
                              @Value("${spring.ai.openai.api-key}") String apiKey) {
        this.chatClient = chatClientBuilder.build();
        this.apiKey = apiKey;
    }

    public String execute(String message) {
        PromptTemplate prompt = new PromptTemplate(PromptMessage.TEMPLATE + message);

        // Imprimir o template para ver se a substituição está correta
        System.out.println("Prompt after substitution: " + prompt.getTemplate());

        Flux<String> responseFlux = chatClient.prompt()
                .user(prompt.getTemplate())
                .stream()
                .content();

        String response = responseFlux.collectList().block().stream().collect(Collectors.joining());

        return response;
    }



}
