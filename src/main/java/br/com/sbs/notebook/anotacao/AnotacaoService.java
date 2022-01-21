package br.com.sbs.notebook.anotacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnotacaoService {

    @Autowired
    private AnotacaoRepository anotacaoRepository;

    public AnotacaoService(AnotacaoRepository anotacaoRepository) {
        this.anotacaoRepository = anotacaoRepository;
    }

    public List<Anotacao> findAll() {
        List<Anotacao> anotacoes = anotacaoRepository.findAll();
        return anotacoes;
    }

    public Anotacao save(Anotacao novaAnotacao) {
        Anotacao anotacao = anotacaoRepository.save(novaAnotacao);
        return anotacao;
    }
}
