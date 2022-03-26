package br.com.roberto.exemplo.hexagonal.arch.aplicacao.adaptadores.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.roberto.exemplo.hexagonal.arch.dominio.dto.EstoqueDto;
import br.com.roberto.exemplo.hexagonal.arch.dominio.dto.ProdutoDto;
import br.com.roberto.exemplo.hexagonal.arch.dominio.portas.interfaces.ProdutoServicePort;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
	
	private final ProdutoServicePort produtoServicePort;
	
	public ProdutoController(ProdutoServicePort produtoServicePort) {
		this.produtoServicePort = produtoServicePort;
	}
	
	@PostMapping
	void criarProdutos(@RequestBody ProdutoDto produtoDto) {
		produtoServicePort.criarProduto(produtoDto);	
	}
	
	@GetMapping
	List<ProdutoDto> getProdutos(){
		return produtoServicePort.buscarProdutos();
	}
	
	@PutMapping("/{sku}")
	void atualizarEstoque(@PathVariable String sku, @RequestBody EstoqueDto estoqueDto) {
		produtoServicePort.atualizarEstoque(sku, estoqueDto);	
	}
	
	
	

}
