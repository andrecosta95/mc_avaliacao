package com.fiap.avaliacoes.api.reository;

import com.fiap.avaliacoes.api.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyAvaliacaoRepository extends JpaRepository<Avaliacao, Integer>{

}
