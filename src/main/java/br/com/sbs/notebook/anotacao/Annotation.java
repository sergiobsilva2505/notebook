package br.com.sbs.notebook.anotacao;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "annotations")
public class Annotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double value;
    private LocalDate createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private AnnotationType annotationType;

    @Deprecated
    public Annotation() {
    }

    public Annotation(String description, Double value, LocalDate createdAt) {
        this.description = description;
        this.value = value;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Double getValue() {
        return value;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public AnnotationType getAnnotationType() {
        return annotationType;
    }

    public void setAnnotationType(AnnotationType annotationType) {
        this.annotationType = annotationType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Annotation annotation = (Annotation) o;
        return Objects.equals(id, annotation.id) && Objects.equals(description, annotation.description) && Objects.equals(createdAt, annotation.createdAt) && annotationType == annotation.annotationType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, createdAt, annotationType);
    }
}
