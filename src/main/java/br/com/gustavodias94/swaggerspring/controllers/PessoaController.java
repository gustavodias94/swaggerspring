package br.com.gustavodias94.swaggerspring.controllers;


import br.com.gustavodias94.swaggerspring.model.Pessoa;
import br.com.gustavodias94.swaggerspring.services.PessoaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoas", produces = MediaType.APPLICATION_JSON_VALUE)
public class PessoaController {

    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    //Esse Método é um GET - Ele solicita para camada de Servico que busque todas as pessoas cadastradas
    @GetMapping(path = "/lista", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Recupera uma lista de pessoas cadastrada", notes = "Recupera uma lista de pessoas cadastrada")
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


    // Esse Método é um POST - Ele envia para camada de Servico uma pessoa para persistencia.
    @PostMapping(path = "/cadastro", produces = MediaType.APPLICATION_JSON_VALUE)
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
}
