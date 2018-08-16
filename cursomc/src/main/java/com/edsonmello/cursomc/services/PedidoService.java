package com.edsonmello.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edsonmello.cursomc.domain.Pedido;
import com.edsonmello.cursomc.repositories.PedidoRepository;
import com.edsonmello.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository PedidoRep;
	
	public Pedido buscarPorId(Integer id) {
		
		Optional<Pedido> obj = PedidoRep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));			
	}

}
