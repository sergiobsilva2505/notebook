package br.com.sbs.notebook.anotacao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class AnnotationDTO {

    private String description;
    private BigDecimal value;
    private LocalDate date;

    public AnnotationDTO() {
    }

    public AnnotationDTO(Annotation annotation) {
        this.description = annotation.getDescription();
        this.value = annotation.getValue();
        this.date = annotation.getCreatedAt();
    }

    public List<AnnotationDTO> fromEntity(List<Annotation> annotations){
        return annotations.stream().map(AnnotationDTO::new).toList();
    }

    public AnnotationDTO fromEntity(Annotation annotation){
        return new AnnotationDTO(annotation);
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public LocalDate getDate() {
        return date;
    }
}
