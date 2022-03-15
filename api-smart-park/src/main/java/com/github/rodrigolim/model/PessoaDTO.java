package com.github.rodrigolim.model;

import java.util.Date;

import lombok.*;

@Setter
@Getter
public class PessoaDTO {
	
	private String nome;
	private String sobreNome;
    private String rg;
    private String cpf;
	private String sexo;
	private Date data_nascimento;
    private String endereco;
	private String uf;
    private String cidade;
    private String pais;
    private String celular;
    private String email;
    
}
