package com.edsonmello.cursomc.domain;

import javax.persistence.Entity;

import com.edsonmello.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDasParcelas;
	
	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDasParcelas) {
		super(id, estado, pedido);
		this.numeroDasParcelas = numeroDasParcelas;
	}

	public Integer getNumeroDasParcelas() {
		return numeroDasParcelas;
	}

	public void setNumeroDasParcelas(Integer numeroDasParcelas) {
		this.numeroDasParcelas = numeroDasParcelas;
	}
	
	
	

}
