package com.edsonmello.cursomc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Pedido implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Date instante;
	private Pagamento pagamento;
	
	
	
	@JsonManagedReference	
	@ManyToOne
	@JoinColumn(name="estado_id")
	private Estado estado;
	
	private Cliente cliente;
	
	private Endereco enderecoDeEntrega;
	
	
	public Pedido(){}


	public Pedido(Integer id, Date instante, Pagamento pagamento, Estado estado, Cliente cliente,
			Endereco enderecoDeEntrega) {
		super();
		this.id = id;
		this.instante = instante;
		this.pagamento = pagamento;
		this.estado = estado;
		this.cliente = cliente;
		this.enderecoDeEntrega = enderecoDeEntrega;
	}



	
	
	

	
	
	

}
