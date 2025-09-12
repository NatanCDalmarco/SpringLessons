package com.natan.project01.Controllers;

import org.springframework.web.bind.annotation.*;

record MensagemDTO(String texto) {}

@RequestMapping("/teste")
@RestController
public class HelloController {

    @GetMapping()
    public String dizerOla() {
        return "Fala baixo!";
    }

    @PostMapping()
    public String receberMensagem(@RequestBody MensagemDTO mensagem) {
        return "fala " + mensagem.texto();
    }
}