package com.edsonmello.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edsonmello.cursomc.domain.Categoria;
import com.edsonmello.cursomc.repositories.CategoriaRepository;
import com.edsonmello.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRep;
	
	public Categoria find(Integer id) {
		
		Optional<Categoria> obj = categoriaRep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));			
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return categoriaRep.save(obj);		
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return categoriaRep.save(obj);		
	}

}
