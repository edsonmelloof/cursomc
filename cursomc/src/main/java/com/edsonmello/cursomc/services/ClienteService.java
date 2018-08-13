package com.edsonmello.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edsonmello.cursomc.domain.Categoria;
import com.edsonmello.cursomc.domain.Cliente;
import com.edsonmello.cursomc.repositories.ClienteRepository;
import com.edsonmello.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRep;
	
	public Cliente buscarPorId(Integer id) {
		
		Optional<Cliente> obj = clienteRep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));			
	}

}
