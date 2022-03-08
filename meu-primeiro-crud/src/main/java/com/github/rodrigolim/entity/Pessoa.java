package com.github.rodrigolim.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;


@Entity
public class Pessoa extends PanacheEntityBase {
	
	@Id
    @SequenceGenerator(name = "pessoaSeq", sequenceName = "pessoa_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "pessoaSeq")
	private Long pessoa_id;
	
	@NotBlank(message="Nome Obrigatório")
	@Column(length = 100, nullable = false)
    private String nome;
	
	@NotBlank(message="Nome Obrigatório")
	@Column(length = 100, nullable = false)
    private String sobreNome;
	
	@Column(length = 50, nullable = false, unique = true)
	private String rg;
	
	@Column(length = 50, nullable = false, unique = true)
	private String cpf;
	
	@Column(length = 1, nullable = false)
    private String sexo;
	
	private Date data_nascimento;

	@Column(length = 100)
    private String endereco;
  
	@Column(length = 2)
	private String uf;
	
	@Column(length = 50)
    private String cidade;
	
	@Column(length = 50)
    private String pais;
	
	@Column(length = 20)
    private String celular;
 
	@Column(length = 50)
	private String email;
	  
	@CreationTimestamp
	@Column(nullable = false)
	private Date data_criacao;
		
	@UpdateTimestamp
	@Column(nullable = false)
	private Date data_atualizacao;

	public Long getPessoa_id() {
		return pessoa_id;
	}

	public void setPessoa_id(Long pessoa_id) {
		this.pessoa_id = pessoa_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}

	public Date getData_atualizacao() {
		return data_atualizacao;
	}

	public void setData_atualizacao(Date data_atualizacao) {
		this.data_atualizacao = data_atualizacao;
	} 	
	
}
