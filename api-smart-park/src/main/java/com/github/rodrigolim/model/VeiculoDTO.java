package com.github.rodrigolim.model;

import com.github.rodrigolim.entity.Marca;
import com.github.rodrigolim.entity.Pessoa;
import com.github.rodrigolim.entity.Proprietario;

import lombok.*;

@Setter
@Getter
public class VeiculoDTO {
	
	private boolean ativo;
    private TipoCategoria categoria;
    private String chassi;
    private String placa;
    private String modelo;
    private String cor;
    private int ano_fabricacao;
    private int ano_modelo;
	private Marca marca;
	private Proprietario proprietario;
	private Pessoa pessoa;	

}
