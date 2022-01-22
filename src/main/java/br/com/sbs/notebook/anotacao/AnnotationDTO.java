package br.com.sbs.notebook.anotacao;

import java.time.LocalDate;
import java.util.List;

public class AnnotationDTO {

    private String description;
    private Double value;
    private LocalDate date;

    public AnnotationDTO() {
    }

    public AnnotationDTO(Annotation annotation) {
        this.description = annotation.getDescription();
        this.value = annotation.getValue();
        this.date = annotation.getDate();
    }

    public List<AnnotationDTO> fromEntity(List<Annotation> annotations){
        return annotations.stream().map(AnnotationDTO::new).toList();
    }

    public String getDescription() {
        return description;
    }

    public Double getValue() {
        return value;
    }

    public LocalDate getDate() {
        return date;
    }
}
