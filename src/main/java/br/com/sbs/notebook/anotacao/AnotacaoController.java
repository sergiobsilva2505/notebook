package br.com.sbs.notebook.anotacao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static java.lang.String.format;

@RestController
@RequestMapping("/receitas")
public class AnotacaoController {

    private final AnotacaoService anotacaoServie;

    public AnotacaoController(AnotacaoService anotacaoServie) {
        this.anotacaoServie = anotacaoServie;
    }

    @PostMapping
    public ResponseEntity<Void> save (@RequestBody AnotacaoForm anotacaoForm) {
        Anotacao anotacao = anotacaoForm.toEntity();
        anotacaoServie.save(anotacao);
        URI uri = URI.create(format("receitas/%s", anotacao.getId() ));
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Anotacao>> salva() {
        List<Anotacao> anotacoes = anotacaoServie.findAll();
        return ResponseEntity.ok().body(anotacoes);
    }
}
