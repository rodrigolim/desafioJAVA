package com.github.rodrigolim.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;

import lombok.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "VEICULO")
public class Veiculo extends BaseEntity {
	
	@Id
    @SequenceGenerator(name = "veiculoSeq", sequenceName = "veiculo_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "veiculoSeq")
	@Column(name = "VEICULO_ID")
	private Long veiculo_id;
	
	@Column(name = "ATIVO", nullable = false)
	private boolean ativo;
	
	@Column(name = "CATEGORIA", length = 10, nullable = false)
    private String categoria;
	
	@Column(name = "CHASSI", length = 20, nullable = false)
    private String chassi;
	
	@Column(name = "PLACA", length = 7, nullable = false)
    private String placa;
	
	@Column(name = "MODELO", length = 30, nullable = false)
    private String modelo;
	
	@Column(name = "COR", length = 30, nullable = false)
    private String cor;
	
	@Column(name = "ANO_FABRICACAO", nullable = false)
    private int anoFabricacao;
	
	@Column(name = "ANO_MODELO", nullable = false)
    private int anoModelo;	

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MARCA_ID", nullable = false)
	private Marca marca;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROPRIETARIO_ID", nullable = false)
	private Proprietario proprietario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PESSOA_ID", nullable = false)
	private Pessoa pessoa;
}
