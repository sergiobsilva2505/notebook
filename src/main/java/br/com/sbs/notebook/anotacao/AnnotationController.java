package br.com.sbs.notebook.anotacao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static java.lang.String.format;

@RestController
@RequestMapping
public class AnnotationController {

    private final AnnotationService annotationsService;
    private final AnnotationRepository annotationsRepository;

    public AnnotationController(AnnotationService annotationsService, AnnotationRepository annotationsRepository) {
        this.annotationsService = annotationsService;
        this.annotationsRepository = annotationsRepository;
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
    public ResponseEntity<List<AnnotationDTO>> findIncomeById( Long id) {
        List<Annotation> annotations = annotationsService.findByTipo(AnnotationType.INCOME);
        return ResponseEntity.ok().body(new AnnotationDTO().fromEntity(annotations));
    }

    @GetMapping("/despesas")
    public ResponseEntity<List<AnnotationDTO>> findAllExpenses() {
        List<Annotation> annotations = annotationsService.findByTipo(AnnotationType.EXPENSE);
        return ResponseEntity.ok().body(new AnnotationDTO().fromEntity(annotations));
    }

    @PostMapping("/receitas")
    public ResponseEntity<Void> save (@RequestBody NewAnnotationForm anotacaoForm) {
        Annotation annotation = anotacaoForm.toEntity();
        annotation.setAnnotationType(AnnotationType.INCOME);
        annotationsService.save(annotation);
        URI uri = URI.create(format("receitas/%s", annotation.getId() ));
        return ResponseEntity.created(uri).build();
    }
}
