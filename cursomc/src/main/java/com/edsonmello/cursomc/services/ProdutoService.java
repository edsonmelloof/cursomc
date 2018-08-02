package com.edsonmello.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edsonmello.cursomc.domain.Produto;
import com.edsonmello.cursomc.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRep;
	
	public Produto buscarPorId(Integer id) {
		
		Optional<Produto> obj = produtoRep.findById(id);
		return obj.orElse(null);
		
		
	}

}
