package br.com.sbs.notebook.anotacao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@RestController
@RequestMapping
public class AnnotationController {

    private final AnnotationService annotationsService;

    public AnnotationController(AnnotationService annotationsService) {
        this.annotationsService = annotationsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AnnotationDTO>> findAllAnnotations() {
        List<Annotation> annotations = annotationsService.findAll();
        return ResponseEntity.ok().body(new AnnotationDTO().fromEntity(annotations));
    }

    @GetMapping("/receitas")
    public ResponseEntity<List<AnnotationDTO>> findAllIncomes() {
        List<Annotation> annotations = annotationsService.findByTipo(AnnotationType.INCOME);
        return ResponseEntity.ok().body(new AnnotationDTO().fromEntity(annotations));
    }

    @GetMapping("/receitas/{id}")
    public ResponseEntity<AnnotationDTO> findIncomeById(@PathVariable Long id) {
        Annotation annotation = annotationsService.findIncomeById(id)
                .orElseThrow(() -> new RuntimeException("Objeto não encontrado"));
        return ResponseEntity.ok().body(new AnnotationDTO().fromEntity(annotation));
    }

    @PostMapping("/receitas")
    public ResponseEntity<Void> save(@RequestBody NewAnnotationForm anotacaoForm) {
        Annotation annotation = anotacaoForm.toEntity();
        annotation.setAnnotationType(AnnotationType.INCOME);
        annotationsService.save(annotation);
        URI uri = URI.create(format("receitas/%s", annotation.getId() ));
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/receitas/{id}")
    public ResponseEntity<AnnotationDTO> update(@RequestBody NewAnnotationForm newAnnotationForm, @PathVariable Long id) {
        Annotation incomeById = annotationsService.findIncomeById(id)
                .orElseThrow(()-> new RuntimeException("Não encontrado"));
        return ResponseEntity.noContent().build();
    }












    @GetMapping("/despesas")
    public ResponseEntity<List<AnnotationDTO>> findAllExpenses() {
        List<Annotation> annotations = annotationsService.findByTipo(AnnotationType.EXPENSE);
        return ResponseEntity.ok().body(new AnnotationDTO().fromEntity(annotations));
    }


}
