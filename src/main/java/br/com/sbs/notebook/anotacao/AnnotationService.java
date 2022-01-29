package br.com.sbs.notebook.anotacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnnotationService {

    private final AnnotationRepository annotationRepository;

    public AnnotationService(AnnotationRepository annotationRepository) {
        this.annotationRepository = annotationRepository;
    }

    public List<Annotation> findAll(){
        return annotationRepository.findAll();
    }

    public List<Annotation> findByTipo(AnnotationType type) {
        return annotationRepository.findByAnnotationType(type);
    }

    public Annotation save(Annotation novaAnnotation) {
        boolean exists = annotationRepository.exists(novaAnnotation);
        if (exists) {
            throw new RuntimeException("Já existe");
        }
        Annotation annotation = annotationRepository.save(novaAnnotation);
        return annotation;
    }

    public Optional<Annotation> findIncomeById(Long id){
        return annotationRepository.findByIdAndAnnotationType(id, AnnotationType.INCOME);
    }

    private boolean hasTheSameAnotion(Annotation novaAnnotation, List<Annotation> anotacoes) {
        for (Annotation annotation : anotacoes) {
            if (annotation.equals(novaAnnotation)) {
               return true;
            }
        }
        return false;
    }

    public Optional<Annotation> findById(Long id) {
        return annotationRepository.findById(id);
    }
}
