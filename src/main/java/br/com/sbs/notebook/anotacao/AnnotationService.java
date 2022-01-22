package br.com.sbs.notebook.anotacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnotationService {

    @Autowired
    private AnnotationRepository annotationRepository;

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
        List<Annotation> anotacoes = annotationRepository.findAll();
        boolean hasAlready = hasTheSameAnotion(novaAnnotation, anotacoes);
        if (hasAlready) {
            throw new IllegalArgumentException("Já tem");
        }
        Annotation annotation = annotationRepository.save(novaAnnotation);
        return annotation;
    }

    private boolean hasTheSameAnotion(Annotation novaAnnotation, List<Annotation> anotacoes) {
        for (Annotation annotation : anotacoes) {
            if (annotation.equals(novaAnnotation)) {
               return true;
            }
        }
        return false;
    }
}
