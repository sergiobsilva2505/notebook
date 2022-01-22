package br.com.sbs.notebook.anotacao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static java.lang.String.format;

@RestController
@RequestMapping("/notebook")
public class AnnotationController {

    private final AnnotationService anotacaoServie;

    public AnnotationController(AnnotationService anotacaoServie) {
        this.anotacaoServie = anotacaoServie;
    }

    @GetMapping("/{tipo}")
    public ResponseEntity<List<Annotation>> findByAnnotationType(@PathVariable String tipo) {
        AnnotationType type = null;
        if ("receitas".equals(tipo)){
            type = AnnotationType.INCOME;
        }
        if ("despesas".equals(tipo)){
            type = AnnotationType.EXPENSE;
        }
        List<Annotation> annotations = anotacaoServie.findByTipo(type);
        return ResponseEntity.ok().body(annotations);
    }

    @PostMapping
    public ResponseEntity<Void> save (@RequestBody NewAnnotationForm anotacaoForm) {
        Annotation annotation = anotacaoForm.toEntity();
        anotacaoServie.save(annotation);
        URI uri = URI.create(format("receitas/%s", annotation.getId() ));
        return ResponseEntity.created(uri).build();
    }


}
