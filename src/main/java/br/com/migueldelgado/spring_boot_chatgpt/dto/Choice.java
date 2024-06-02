package br.com.migueldelgado.spring_boot_chatgpt.dto;

public record Choice(int index, Message message) {
    // O record já fornece os métodos padrão como construtor, equals, hashCode e toString
}
