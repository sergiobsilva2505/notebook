package br.com.sbs.notebook.anotacao;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AnotacaoController {

    @GetMapping("/receitas")
    public String salva(){
        return "Hello World";
    }
}
