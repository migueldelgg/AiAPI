package br.com.migueldelgado.spring_boot_chatgpt.service;

import br.com.migueldelgado.spring_boot_chatgpt.dto.ChatGPTRequest;
import br.com.migueldelgado.spring_boot_chatgpt.dto.ChatGPTResponse;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StartupIdeaService {

    @Value("${openai.api.model}")
    private String model;

    @Value("${openai.api.url}")
    private String url;

    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate template;

    public String generatePromptFromMessage(String userPrompt) {
        PromptTemplate prompt = new PromptTemplate(PromptMessage.TEMPLATE);

        prompt.add("userPrompt", userPrompt);

        var responseCreated = prompt.create();

        return responseCreated.getContents();
    }

    public String execute(String userPrompt) {

        var prompt = generatePromptFromMessage(userPrompt);

        // Cria a request para a API da Open AI
        ChatGPTRequest request = new ChatGPTRequest(model, prompt);

        // Chama a API da Open AI
        ChatGPTResponse response = template.postForObject(url, request, ChatGPTResponse.class);

        // Verifica se a API da Open AI retornou alguma resposta.
        if (response == null || response.choices() == null || response.choices().isEmpty()) {
            return "No response";
        }

        // Retorna a primeira resposta.
        return response.choices().get(0).message().content();
    }

}
