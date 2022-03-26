package br.com.roberto.exemplo.hexagonal.arch.dominio.portas.interfaces;

import java.util.List;

import br.com.roberto.exemplo.hexagonal.arch.dominio.dto.EstoqueDto;
import br.com.roberto.exemplo.hexagonal.arch.dominio.dto.ProdutoDto;

public interface ProdutoServicePort {

	List<ProdutoDto> buscarProdutos();

	void criarProduto(ProdutoDto produtoDto);

	void atualizarEstoque(String sku, EstoqueDto estoqueDto);

}
