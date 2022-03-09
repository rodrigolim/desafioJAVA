package com.github.rodrigolim.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "PROPRIETARIO")
public class Proprietario extends BaseEntity {
	
	@Id
    @SequenceGenerator(name = "proprietarioSeq", sequenceName = "proprietario_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "proprietarioSeq")
	@Column(name = "PROPRIETARIO_ID")
	private Long proprietario_id;
	
	@NotBlank(message="Nome Obrigatório")
	@Column(name = "NOME", length = 100, nullable = false)
    private String nome;
	
	@Column(name = "TIPO", length = 1, nullable = false)
    private String tipo;
  
	@Column(name = "CNPJ", length = 50, unique = true)
	private String cnpj;
	
	@Column(name = "CPF", length = 50, unique = true)
    private String cpf;
	
	@Column(name = "ENDERECO", length = 100)
    private String endereco;
  
	@Column(name = "UF", length = 2)
	private String uf;
	
	@Column(name = "CIDADE", length = 50)
    private String cidade;
	
	@Column(name = "PAIS", length = 50)
    private String pais;
	
	@Column(name = "TELEFONE", length = 20)
    private String telefone;
	
	@Column(name = "EMAIL", length = 50)
    private String email;	
	
}
