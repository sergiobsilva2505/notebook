package br.com.sbs.notebook.anotacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnotacaoRepository extends JpaRepository<Anotacao, Long> {

}
