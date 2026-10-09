package com.facisaflix.edu.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filme {
	
	@Id @GeneratedValue
	private Long id; 
	
	private String titulo;
	
	private String genero;
	
	private String sinopse;
	
	private String autor;
	
	private Integer anoLancamento;
	
	private Integer duracao;

}
