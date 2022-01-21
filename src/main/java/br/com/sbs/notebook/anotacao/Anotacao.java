package br.com.sbs.notebook.anotacao;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "anotacoes")
public class Anotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Double valor;
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private TipoAnotacao tipo;

    @Deprecated
    public Anotacao() {
    }

    public Anotacao(String descricao, Double valor, LocalDate  data, TipoAnotacao tipo) {
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    public TipoAnotacao getTipo() {
        return tipo;
    }
}
