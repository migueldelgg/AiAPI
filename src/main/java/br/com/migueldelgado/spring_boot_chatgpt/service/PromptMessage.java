package br.com.migueldelgado.spring_boot_chatgpt.service;

public class PromptMessage {
    public static final String TEMPLATE = """
        Geração de Ideias de Startups
        Com base nas informações fornecidas pelo usuário, crie três conceitos inovadores de startups. Cada conceito deve incluir:
        - Uma breve descrição

        Exemplo de saída: 
        - Startup: [Descrição da Startup]
          - Descrição: [Breve descrição da startup]   
            - A saida deve conter no maximo 2000 caracteres  
        
        Gere as ideias com base nas informações fornecidas pelo usuário, quantidade de exemplos e responda em português formal
       
  
    """;
}
