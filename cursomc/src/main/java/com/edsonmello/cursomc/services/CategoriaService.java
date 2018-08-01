package com.edsonmello.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edsonmello.cursomc.domain.Categoria;
import com.edsonmello.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRep;
	
	public Categoria buscarPorId(Integer id) {
		
		Optional<Categoria> obj = categoriaRep.findById(id);
		return obj.orElse(null);
		
		
	}

}
