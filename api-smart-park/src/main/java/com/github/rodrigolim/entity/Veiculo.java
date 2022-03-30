package com.github.rodrigolim.entity;

import javax.persistence.*;
import lombok.*;

import com.github.rodrigolim.model.TipoCategoria;

import static javax.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@Entity
@NoArgsConstructor
@Table(name = "VEICULO", schema = "CADASTRO")
public class Veiculo extends BaseEntity {
	
	@Id
	@Column(name = "VEICULO_ID")
	@GeneratedValue(strategy = IDENTITY)
	private Long veiculo_id;
	
	@Column(name = "ATIVO", nullable = false)
	private boolean ativo;
	
	@Column(name = "CATEGORIA", length = 10, nullable = false)
	@Enumerated(value = EnumType.STRING)
    private TipoCategoria categoria;
	
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
