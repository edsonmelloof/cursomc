package com.edsonmello.cursomc;

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
import com.edsonmello.cursomc.domain.Produto;
import com.edsonmello.cursomc.domain.enums.TipoCliente;
import com.edsonmello.cursomc.repositories.CategoriaRepository;
import com.edsonmello.cursomc.repositories.CidadeRepository;
import com.edsonmello.cursomc.repositories.ClienteRepository;
import com.edsonmello.cursomc.repositories.EnderecoRepository;
import com.edsonmello.cursomc.repositories.EstadoRepository;
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
		
		
				
	}
}
