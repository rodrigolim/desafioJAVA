package com.github.rodrigolim.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@Entity
@NoArgsConstructor
@Table(name = "MARCA")
public class Marca extends BaseEntity {
	
	@Id
    @SequenceGenerator(name = "marcaSeq", sequenceName = "marca_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "marcaSeq")
	@Column(name = "MARCA_ID")
	private Long marca_id;
	
	@NotBlank(message="Nome Obrigatório")
	@Column(name = "NOME", length = 100, nullable = false)
    private String nome;
}
