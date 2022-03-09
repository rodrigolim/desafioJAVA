package com.github.rodrigolim.model.dto;

import com.github.rodrigolim.entity.Marca;
import com.github.rodrigolim.entity.Pessoa;
import com.github.rodrigolim.entity.Proprietario;

public class CadastrarVeiculoDTO {
	
	private boolean ativo;
    private String categoria;
    private String chassi;
    private String placa;
    private String modelo;
    private String cor;
    private int ano_fabricacao;
    private int ano_modelo;
	private Marca marca;
	private Proprietario proprietario;
	private Pessoa pessoa;
	
	
	public boolean getAtivo() {
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

	
	

}
