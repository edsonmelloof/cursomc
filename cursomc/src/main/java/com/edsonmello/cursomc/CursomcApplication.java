package com.edsonmello.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edsonmello.cursomc.domain.Categoria;
import com.edsonmello.cursomc.domain.Cidade;
import com.edsonmello.cursomc.domain.Cliente;
import com.edsonmello.cursomc.domain.Endereco;
import com.edsonmello.cursomc.domain.Estado;
import com.edsonmello.cursomc.domain.ItemPedido;
import com.edsonmello.cursomc.domain.Pagamento;
import com.edsonmello.cursomc.domain.PagamentoComBoleto;
import com.edsonmello.cursomc.domain.PagamentoComCartao;
import com.edsonmello.cursomc.domain.Pedido;
import com.edsonmello.cursomc.domain.Produto;
import com.edsonmello.cursomc.domain.enums.EstadoPagamento;
import com.edsonmello.cursomc.domain.enums.TipoCliente;
import com.edsonmello.cursomc.repositories.CategoriaRepository;
import com.edsonmello.cursomc.repositories.CidadeRepository;
import com.edsonmello.cursomc.repositories.ClienteRepository;
import com.edsonmello.cursomc.repositories.EnderecoRepository;
import com.edsonmello.cursomc.repositories.EstadoRepository;
import com.edsonmello.cursomc.repositories.ItemPedidoRepository;
import com.edsonmello.cursomc.repositories.PagamentoRepository;
import com.edsonmello.cursomc.repositories.PedidoRepository;
import com.edsonmello.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired	
	private CategoriaRepository catRepository;
	
	@Autowired	
	private ProdutoRepository prodRepository;
	
	@Autowired	
	private CidadeRepository cidRepository;
	
	@Autowired	
	private EstadoRepository estRepository;
	
	@Autowired	
	private ClienteRepository cliRepository;
	
	@Autowired	
	private EnderecoRepository endRepository;
	
	@Autowired	
	private PedidoRepository pedRepository;
	
	@Autowired	
	private PagamentoRepository pagRepository;
	
	@Autowired	
	private ItemPedidoRepository itemPedidoRepository;


	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto prod1 =  new Produto(null, "Computador", 2000.00);
		Produto prod2 =  new Produto(null, "Impressora", 800.00);
		Produto prod3 =  new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod2));
		
		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategorias().addAll(Arrays.asList(cat1));
				
		catRepository.saveAll(Arrays.asList(cat1, cat2));
		prodRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
		
		Estado est1 =  new Estado(null, "Minas Gerais");
		Estado est2 =  new Estado(null, "São Paulo");
		
		Cidade cid1 =  new Cidade(null, "Uberlândia", est1);
		Cidade cid2 =  new Cidade(null, "São Paulo", est2);
		Cidade cid3 =  new Cidade(null, "Campinas", est2);
		
		estRepository.saveAll(Arrays.asList(est1, est2));
		cidRepository.saveAll(Arrays.asList(cid1, cid2, cid3)); 
		
		
		Cliente cli1 =  new Cliente(null, "Maria Silva", "maria@gmail.com", "29592843805", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("(16)99728-7515","(16)98225-0970"));
		
		Endereco e1 =  new Endereco(null, "Rua Flores", "300", "Apot 3", "Jardim", "15.900-000", cli1, cid1);
		Endereco e2 =  new Endereco(null, "Av. Mattos", "105", "Apot 30", "Centro", "11.710-000", cli1, cid2);
		
		cli1.getEndereco().addAll(Arrays.asList(e1, e2));
		
		cliRepository.saveAll(Arrays.asList(cli1));		
		endRepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido ped1 =  new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 =  new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pgto1 =  new PagamentoComCartao(null, EstadoPagamento.QUITADO , ped1, 6);
		ped1.setPagamento(pgto1);
		
		Pagamento pgto2 =  new PagamentoComBoleto(null, EstadoPagamento.PENDENTE , ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pgto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedRepository.saveAll(Arrays.asList(ped1, ped2));
		pagRepository.saveAll(Arrays.asList(pgto1, pgto2));	
		
		ItemPedido ip1 = new ItemPedido(ped1, prod1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, prod3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, prod2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		prod1.getItens().addAll(Arrays.asList(ip1));
		prod2.getItens().addAll(Arrays.asList(ip3));
		prod3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		
	}
}
