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
public class Proprietario extends PanacheEntityBase {
	
	@Id
    @SequenceGenerator(name = "proprietarioSeq", sequenceName = "proprietario_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "proprietarioSeq")
	private Long proprietario_id;
	
	@NotBlank(message="Nome Obrigatório")
	@Column(length = 100, nullable = false)
    private String nome;
	
	@Column(length = 1, nullable = false)
    private String tipo;
  
	@Column(length = 50, unique = true)
	private String cnpj;
	
	@Column(length = 50, unique = true)
    private String cpf;
	
	@Column(length = 100)
    private String endereco;
  
	@Column(length = 2)
	private String uf;
	
	@Column(length = 50)
    private String cidade;
	
	@Column(length = 50)
    private String pais;
	
	@Column(length = 20)
    private String telefone;
	
	@Column(length = 50)
    private String email;

	@CreationTimestamp
	@Column(nullable = false)
	private Date data_criacao;
	
	@UpdateTimestamp
	@Column(nullable = false)
    private Date data_atualizacao;

	public Long getProprietario_id() {
		return proprietario_id;
	}

	public void setProprietario_id(Long proprietario_id) {
		this.proprietario_id = proprietario_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
