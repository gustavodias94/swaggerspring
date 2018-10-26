package br.com.gustavodias94.swaggerspring.controllers;


import br.com.gustavodias94.swaggerspring.model.Pessoa;
import br.com.gustavodias94.swaggerspring.services.PessoaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa", produces = MediaType.APPLICATION_JSON_VALUE)
public class PessoaController {

    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping(path = "/lista", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Recupera uma lista de pessoas cadastrada", notes = "Endpoit para listar as pessoas cadastrada")
    public ResponseEntity<List<Pessoa>> listarTodasPessoas(){
        HttpStatus httpStatus = HttpStatus.OK;
        List<Pessoa> listaPessoas = null;
        try {
            listaPessoas = pessoaService.buscarTodasPessoas();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (listaPessoas != null)
            return new ResponseEntity<>(listaPessoas,httpStatus);
        return new ResponseEntity<>(httpStatus);
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Endpoint para cadastrar uma pessoa", notes = "Endpoint para cadastrar uma pessoa")
    public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody Pessoa pessoaJson){
        HttpStatus httpStatus = HttpStatus.OK;
        Pessoa pessoa = null;
        try {
            pessoa = pessoaService.cadastrarPessoa(pessoaJson);
        } catch (Exception e) {
            e.printStackTrace();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        if (pessoa != null)
            return new ResponseEntity<>(pessoa, httpStatus);
        return new ResponseEntity<>(httpStatus);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Endpoint para apagar uma pessoa", notes = "Endpoint para apagar uma pessoa")
    public ResponseEntity<Pessoa> deletarPessoa(@PathVariable Long id){
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            pessoaService.deletarPessoa(id);
        } catch (Exception e) {
            e.printStackTrace();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(httpStatus);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Endpoint para atualizar os dados de uma pessoa", notes = "Endpoint para atualizar os dados de uma pessoa")
    public ResponseEntity<Pessoa> atualizarPessoa(@RequestBody Pessoa pessoaJson){
        HttpStatus httpStatus = HttpStatus.OK;
        Pessoa pessoa = null;
        try {
            pessoa = pessoaService.atualizarPessoa(pessoaJson);
        } catch (Exception e) {
            e.printStackTrace();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        if (pessoa != null)
            return new ResponseEntity<>(pessoa, httpStatus);
        return new ResponseEntity<>(httpStatus);
    }

}
