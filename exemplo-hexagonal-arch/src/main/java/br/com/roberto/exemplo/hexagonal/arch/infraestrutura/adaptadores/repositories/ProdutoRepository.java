package br.com.roberto.exemplo.hexagonal.arch.infraestrutura.adaptadores.repositories;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.roberto.exemplo.hexagonal.arch.dominio.Produto;
import br.com.roberto.exemplo.hexagonal.arch.dominio.portas.repositories.ProdutoRepositoryPort;
import br.com.roberto.exemplo.hexagonal.arch.infraestrutura.adaptadores.entidades.ProdutoEntity;

@Component
public class ProdutoRepository implements ProdutoRepositoryPort {
	
	private final SpringProdutoRepository springProdutoRepository;
	
	public ProdutoRepository(SpringProdutoRepository springProdutoRepository) {
        this.springProdutoRepository = springProdutoRepository;
    }
	
	@Override
	public List<Produto> buscarTodos() {
		List<ProdutoEntity> produtoEntities = this.springProdutoRepository.findAll();
        return produtoEntities.stream().map(ProdutoEntity::toProduto).collect(Collectors.toList());
	}

	@Override
	public Produto buscarPeloSku(String sku) {
		 Optional<ProdutoEntity> produtoEntity = this.springProdutoRepository.findBySku(sku);

	        if (produtoEntity.isPresent())
	            return produtoEntity.get().toProduto();

	        throw new RuntimeException("Produto não existe");
	}

	@Override
	public void salvar(Produto produto) {
		  ProdutoEntity produtoEntity;
	        if (Objects.isNull(produto.getCodigo()))
	            produtoEntity = new ProdutoEntity(produto);
	        else {
	            produtoEntity = this.springProdutoRepository.findById(produto.getCodigo()).get();
	            produtoEntity.atualizar(produto);
	        }

	        this.springProdutoRepository.save(produtoEntity);
	}

}
