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
	@Column(nullable = false, name="data_criacao")
    private Date dataCriacao;
	
	@UpdateTimestamp
	@Column(nullable = false, name="data_atualizacao")
    private Date dataAtualizacao;    
	 
    
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
	
	
	public Date getDataCriacao() {
		return dataCriacao;
	}
	
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

}
