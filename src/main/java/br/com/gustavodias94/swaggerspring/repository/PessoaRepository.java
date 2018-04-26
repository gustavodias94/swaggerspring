package br.com.gustavodias94.swaggerspring.repository;

import br.com.gustavodias94.swaggerspring.model.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long>{
}
