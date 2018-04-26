package br.com.gustavodias94.swaggerspring.controllers;


import br.com.gustavodias94.swaggerspring.model.Pessoa;
import br.com.gustavodias94.swaggerspring.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoas", produces = MediaType.APPLICATION_JSON_VALUE)
public class PessoaController {

    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    //Esse Método é um GET - Ele solicita para camada de Servico que busque todas as pessoas
    @GetMapping(path = "/buscar", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Pessoa>> listarTodasPessoas(){
        HttpStatus httpStatus = HttpStatus.OK;
        List<Pessoa> listaPessoas = null;
        try {
            listaPessoas = pessoaService.buscarTodasPessoas();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(listaPessoas,httpStatus);
    }


    // Esse Método é um POST - Ele envia para camada de Servico uma pessoa para cadastrar
    @PostMapping(path = "/cadastrar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pessoa> cadastraPessoa(@RequestBody Pessoa pessoa){
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            pessoaService.cadastrarPessoa(pessoa);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(httpStatus);
    }
}
