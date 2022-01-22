package br.com.sbs.notebook.anotacao;

import java.time.LocalDate;

public record NewAnnotationForm(String description, Double value, LocalDate date, AnnotationType annotationType) {

    public Annotation toEntity() {
        return new Annotation(description, value, date, annotationType);
    }
}
