package com.github.rodrigolim;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Marca extends PanacheEntityBase {
	
	private Long marca_id;
    private String nome;
    private Date data_criacao;
    private Date data_atualizacao;
    
    
    @Id
    @SequenceGenerator(name = "marcaSeq", sequenceName = "marca_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "marcaSeq")
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
	
	@CreationTimestamp
	public Date getData_criacao() {
		return data_criacao;
	}
	
	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}
	
	@UpdateTimestamp
	public Date getData_atualizacao() {
		return data_atualizacao;
	}
	
	public void setData_atualizacao(Date data_atualizacao) {
		this.data_atualizacao = data_atualizacao;
	}
	
    
    
    /*
	@Id
    @SequenceGenerator(name = "marcaSeq", sequenceName = "marca_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "marcaSeq")
	public Long marca_id;
	public String nome;
    
    @CreationTimestamp
    public Date data_criacao;
		
	@UpdateTimestamp
	public Date data_atualizacao;	
	
	*/
	
}
