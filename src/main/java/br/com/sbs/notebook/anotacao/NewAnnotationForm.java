package br.com.sbs.notebook.anotacao;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

public record NewAnnotationForm(@NotBlank String description, BigDecimal value, LocalDate date) {

    public Annotation toEntity() {
        return new Annotation(description, value, date);
    }
}
