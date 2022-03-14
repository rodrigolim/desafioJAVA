package com.github.rodrigolim.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.*;

import static javax.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@Entity
@NoArgsConstructor
@Table(name = "MARCA", schema = "CADASTRO")
public class Marca extends BaseEntity {	
	
	@Id
	@Column(name = "MARCA_ID")
	@GeneratedValue(strategy = IDENTITY)
	private Long marca_id;
	
	@NotBlank(message="Nome Obrigatório")
	@Column(name = "NOME", length = 100, nullable = false)
    private String nome;
}
