package br.com.sbs.notebook.anotacao;

import java.time.LocalDate;

public record AnotacaoForm(String descricao, Double valor, LocalDate data, TipoAnotacao tipo) {

    public Anotacao toEntity() {
        return new Anotacao(descricao, valor, data, tipo);
    }
}
