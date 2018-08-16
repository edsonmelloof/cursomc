package com.edsonmello.cursomc.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;


import com.edsonmello.cursomc.domain.Categoria;

public class CategoriaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Campo é obrigatório")
	@Length(min=5, max=80, message="O é obrigatório tamanho deve ser entre 5 e 80 caracteres.")
	private String descricao;
	
	public CategoriaDTO() {}
	
	public CategoriaDTO(Categoria obj) {
		id = obj.getId();
		descricao = obj.getDescricao();		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
