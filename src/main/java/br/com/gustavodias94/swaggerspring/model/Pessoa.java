package br.com.gustavodias94.swaggerspring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "TB_PESSOA")
public class Pessoa implements Serializable{

    @Id
    @Column(name = "ID_PESSOA")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPessoa;

    @Column(name = "NO_PESSOA")
    private String nomePessoa;

    @Column(name = "NR_CPF",unique = true)
    private String cpfPessoa;

    @Column(name = "NR_TELEFONE")
    private Long telefonePessoa;

}
