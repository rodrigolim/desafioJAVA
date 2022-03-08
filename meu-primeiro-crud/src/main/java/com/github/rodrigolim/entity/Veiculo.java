package com.github.rodrigolim.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Veiculo extends PanacheEntityBase {
	
	@Id
    @SequenceGenerator(name = "veiculoSeq", sequenceName = "veiculo_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "veiculoSeq")
	private Long veiculo_id;
	
	@Column(nullable = false)
	private boolean ativo;
	
	@Column(length = 10, nullable = false)
    private String categoria;
	
	@Column(length = 20, nullable = false)
    private String chassi;
	
	@Column(length = 7, nullable = false)
    private String placa;
	
	@Column(length = 30, nullable = false)
    private String modelo;
	
	@Column(length = 30, nullable = false)
    private String cor;
	
	@Column(nullable = false)
    private int ano_fabricacao;
	
	@Column(nullable = false)
    private int ano_modelo;
	

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marca_id", nullable = false)
	private Marca marca;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proprietario_id", nullable = false)
	private Proprietario proprietario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pessoa_id", nullable = false)
	private Pessoa pessoa;
	
	@CreationTimestamp
	@Column(nullable = false, name="data_criacao")
	private Date dataCriacao;
		
	@UpdateTimestamp
	@Column(nullable = false, name="data_atualizacao")
	private Date dataAtualizacao;

	public Long getVeiculo_id() {
		return veiculo_id;
	}

	public void setVeiculo_id(Long veiculo_id) {
		this.veiculo_id = veiculo_id;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getAno_fabricacao() {
		return ano_fabricacao;
	}

	public void setAno_fabricacao(int ano_fabricacao) {
		this.ano_fabricacao = ano_fabricacao;
	}

	public int getAno_modelo() {
		return ano_modelo;
	}

	public void setAno_modelo(int ano_modelo) {
		this.ano_modelo = ano_modelo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Date getData_criacao() {
		return dataCriacao;
	}

	public void setData_criacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setData_atualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}	

}
