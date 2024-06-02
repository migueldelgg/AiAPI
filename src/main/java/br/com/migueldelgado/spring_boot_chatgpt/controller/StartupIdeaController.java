package br.com.migueldelgado.spring_boot_chatgpt.controller;

import br.com.migueldelgado.spring_boot_chatgpt.service.StartupIdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/startupidea")
public class StartupIdeaController {

    @Autowired
    private StartupIdeaService service;

    @GetMapping("/chat")
    public String generation(@RequestParam(value = "message",
            defaultValue = "De ideias de startups inovadoras para o futuro.") String message) {

        String response = service.execute(message);

        return response;
    }

}
