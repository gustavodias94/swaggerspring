package br.com.gustavodias94.swaggerspring.services.impl;

import br.com.gustavodias94.swaggerspring.model.Pessoa;
import br.com.gustavodias94.swaggerspring.repository.PessoaRepository;
import br.com.gustavodias94.swaggerspring.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PessoaServiceImpl implements PessoaService{

    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    //Esse é o metodo que a controller chama para listar todas as pessoas.
    @Override
    public List<Pessoa> buscarTodasPessoas() {
        return (List<Pessoa>) pessoaRepository.findAll();
    }


    // Esse é o metodo que a controller chama para cadastrar uma pessoa no banco de dados.
    @Override
    @Transactional
    public Pessoa cadastrarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }


    // Esse é o metodo que a controller chama para deletar uma pessoa do banco de dados.
    @Override
    @Transactional
    public void deletarPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }

    // Esse é o metodo que a controller chama para atualizar uma pessoa do banco de dados.
    @Override
    @Transactional
    public Pessoa atualizarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }


}


/*

Dentro da PessoaRepository, estamos extendendo o CrudRepository que contém alguns métodos que o Spring já nos disponibiliza.
Note que não existe na classe PessoaRespository os métodos findAll() e save(), eles são providos pela interface CrudRepository do SpringData.
*/
