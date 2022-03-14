package com.github.rodrigolim.entity;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.*;

import static javax.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@Entity
@NoArgsConstructor
@Table(name = "PESSOA", schema = "CADASTRO")
public class Pessoa extends BaseEntity {
	
	@Id
	@Column(name = "PESSOA_ID")
	@GeneratedValue(strategy = IDENTITY)
	private Long pessoa_id;
	
	@NotBlank(message="Nome Obrigatório")
	@Column(name = "NOME", length = 100, nullable = false)
    private String nome;
	
	@NotBlank(message="Nome Obrigatório")
	@Column(name = "SOBRENOME", length = 100, nullable = false)
    private String sobreNome;
	
	@Column(name = "RG", length = 50, nullable = false, unique = true)
	private String rg;
	
	@Column(name = "CPF", length = 50, nullable = false, unique = true)
	private String cpf;
	
	@Column(name = "SEXO", length = 1, nullable = false)
    private String sexo;
	
	@Column(name = "DATA_NASCIMENTO")
	private Date dataNascimento;

	@Column(name = "ENDERECO", length = 100)
    private String endereco;
  
	@Column(name = "UF", length = 2)
	private String uf;
	
	@Column(name = "CIDADE", length = 50)
    private String cidade;
	
	@Column(name = "PAIS", length = 50)
    private String pais;
	
	@Column(name = "CELULAR", length = 20)
    private String celular;
 
	@Column(name = "EMAIL", length = 50)
	private String email; 	
}
