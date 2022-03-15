package com.github.rodrigolim.model;

import lombok.*;

@Setter
@Getter
public class ProprietarioDTO {
	
    private String nome;
    private String tipo;
	private String cnpj;
    private String cpf;
    private String endereco;
	private String uf;
    private String cidade;
    private String pais;
    private String telefone;
    private String email;
 
}
