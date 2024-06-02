package br.com.migueldelgado.spring_boot_chatgpt.dto;

import java.util.ArrayList;
import java.util.List;

public record ChatGPTRequest(String model, List<Message> messages, int n, double temperature, int max_tokens) {

    public ChatGPTRequest(String model, String prompt) {
        this(model, createMessages(prompt), 1, 0.0, 2000);
    }

    private static List<Message> createMessages(String prompt) {
        List<Message> messages = new ArrayList<>();
        messages.add(new Message("user", prompt));
        return messages;
    }
}
