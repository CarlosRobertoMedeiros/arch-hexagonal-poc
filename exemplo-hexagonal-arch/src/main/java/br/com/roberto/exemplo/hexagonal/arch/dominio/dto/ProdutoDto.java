package br.com.roberto.exemplo.hexagonal.arch.dominio.dto;

import java.util.UUID;

import br.com.roberto.exemplo.hexagonal.arch.dominio.Produto;

public class ProdutoDto {
	private String sku;
	private String nome;
	private Double preco;
	private Double quantidade;

	public ProdutoDto(String sku, String nome, Double preco, Double quantidade) {
		super();
		this.sku = sku;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public String getSku() {
		return sku;
	}

	public String getNome() {
		return nome;
	}

	public Double getPreco() {
		return preco;
	}

	public Double getQuantidade() {
		return quantidade;
	}
	
	public Produto toProduto() {
		return new Produto(UUID.randomUUID(), this.sku, this.nome, this.preco, this.quantidade);
	}

}
