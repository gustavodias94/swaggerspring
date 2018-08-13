package br.com.gustavodias94.swaggerspring.services;

import br.com.gustavodias94.swaggerspring.model.Pessoa;

import java.util.List;

public interface PessoaService {

    List<Pessoa> buscarTodasPessoas();

    Pessoa cadastrarPessoa(Pessoa pessoa);

    void deletarPessoa(Long id);

    Pessoa atualizarPessoa(Pessoa pessoa);
}
