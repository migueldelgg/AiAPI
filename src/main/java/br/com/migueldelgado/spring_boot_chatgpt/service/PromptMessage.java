package br.com.migueldelgado.spring_boot_chatgpt.service;

public class PromptMessage {
    public static final String TEMPLATE = """
        proponha ideias de startups conforme o input do usuário
        {userPrompt}
        
        - Uma breve descrição
        - Public alvo da Startup
        
        Exemplo de saída: 
        
        Liste 3 exemplos
        - Startup: [Descrição da Startup]
          - Descrição: [Breve descrição da startup]   
            - A saida deve conter no maximo 2000 caracteres  
        
        Gere as ideias com base nas informações fornecidas pelo usuário e responda em português formal.
    """;
}
