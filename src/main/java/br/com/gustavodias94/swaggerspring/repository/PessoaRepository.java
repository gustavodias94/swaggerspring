package br.com.gustavodias94.swaggerspring.repository;

import br.com.gustavodias94.swaggerspring.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
