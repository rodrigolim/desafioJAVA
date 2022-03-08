package com.github.rodrigolim.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Marca extends PanacheEntityBase {
	
	@Id
    @SequenceGenerator(name = "marcaSeq", sequenceName = "marca_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "marcaSeq")
	private Long marca_id;
	
	@NotBlank(message="Nome Obrigatório")
	@Column(length = 100, nullable = false)
    private String nome;
	
	@CreationTimestamp
	@Column(nullable = false)
    private Date data_criacao;
	
	@UpdateTimestamp
	@Column(nullable = false)
    private Date data_atualizacao;    
	 
    
	public Long getMarca_id() {
		return marca_id;
	}
    
	public void setMarca_id(Long marca_id) {
		this.marca_id = marca_id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
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
