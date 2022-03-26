package br.com.roberto.exemplo.hexagonal.arch.dominio.portas.repositories;

import java.util.List;

import br.com.roberto.exemplo.hexagonal.arch.dominio.Produto;

public interface ProdutoRepositoryPort {

	List<Produto> buscarTodos();

	Produto buscarPeloSku(String sku);

	void salvar(Produto produto);

}
