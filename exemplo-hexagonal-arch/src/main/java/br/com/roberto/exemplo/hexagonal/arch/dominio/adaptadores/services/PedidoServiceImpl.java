package br.com.roberto.exemplo.hexagonal.arch.dominio.adaptadores.services;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import br.com.roberto.exemplo.hexagonal.arch.dominio.Produto;
import br.com.roberto.exemplo.hexagonal.arch.dominio.dto.EstoqueDto;
import br.com.roberto.exemplo.hexagonal.arch.dominio.dto.ProdutoDto;
import br.com.roberto.exemplo.hexagonal.arch.dominio.portas.interfaces.ProdutoServicePort;
import br.com.roberto.exemplo.hexagonal.arch.dominio.portas.repositories.ProdutoRepositoryPort;

public class PedidoServiceImpl implements ProdutoServicePort {

	private final ProdutoRepositoryPort produtoRepositoryPort;

	public PedidoServiceImpl(ProdutoRepositoryPort produtoRepositoryPort) {
		this.produtoRepositoryPort = produtoRepositoryPort;
	}

	@Override
	public void criarProduto(ProdutoDto produtoDto) {
		Produto produto = produtoDto.toProduto();
		this.produtoRepositoryPort.salvar(produto);
	}

	@Override
	public List<ProdutoDto> buscarProdutos() {
		List<Produto> produtos = this.produtoRepositoryPort.buscarTodos();
		List<ProdutoDto> produtosDto = produtos.stream().map(Produto::toProdutoDto).collect(Collectors.toList());
		return produtosDto;

	}

	@Override
	public void atualizarEstoque(String sku, EstoqueDto estoqueDto) {
		Produto produto = this.produtoRepositoryPort.buscarPeloSku(sku);

		if (Objects.isNull(produto))
			throw new RuntimeException("Produto não Encontrado! ");// TODO: ProdutoNotFoundException

		produto.autalizarEstoque(estoqueDto.getQuantidade());
		this.produtoRepositoryPort.salvar(produto);
	}

}
