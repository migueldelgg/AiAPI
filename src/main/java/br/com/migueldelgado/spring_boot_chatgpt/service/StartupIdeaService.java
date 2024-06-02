package br.com.migueldelgado.spring_boot_chatgpt.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.stream.Collectors;

@Service
public class StartupIdeaService {

    private final ChatClient chatClient;

    public StartupIdeaService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String execute(String message) {

        PromptTemplate prompt = new PromptTemplate("""
                Geração de ideias de startups
                Baseado nos detalhes fornecidos pelo usuário, gere três conceitos inovadores de startups, 
                cada um com uma breve descrição, público-alvo e proposta de valor.
                                
                Informações do usuário: {message}
                                
                Exemplo de saída:
                - Startup 1: Aplicativo de saúde mental
                  - Descrição: Um aplicativo que conecta usuários a terapeutas licenciados via videochamadas.
                  - Público-alvo: Adultos entre 20 e 50 anos que buscam terapia acessível.
                  - Proposta de valor: Oferece sessões de terapia flexíveis e a preços acessíveis.
                                
                Gere as ideias com base nas informações fornecidas pelo usuário:
                """);
        prompt.add("message", message);

        // Usando streaming para obter a resposta completa
        Flux<String> responseFlux = chatClient.prompt()
                .user(prompt.getTemplate())
                .stream()
                .content();

        // Coletar a resposta completa em uma String
        String response = responseFlux.collectList().block().stream().collect(Collectors.joining());

        return response;
    }
}
