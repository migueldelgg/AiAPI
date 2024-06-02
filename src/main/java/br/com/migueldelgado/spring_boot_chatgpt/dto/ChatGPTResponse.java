package br.com.migueldelgado.spring_boot_chatgpt.dto;

import java.util.List;

public record ChatGPTResponse(List<Choice> choices) {

}
