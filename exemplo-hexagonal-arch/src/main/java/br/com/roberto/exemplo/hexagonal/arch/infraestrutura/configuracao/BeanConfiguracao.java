package br.com.roberto.exemplo.hexagonal.arch.infraestrutura.configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.roberto.exemplo.hexagonal.arch.dominio.adaptadores.services.PedidoServiceImpl;
import br.com.roberto.exemplo.hexagonal.arch.dominio.portas.interfaces.ProdutoServicePort;
import br.com.roberto.exemplo.hexagonal.arch.dominio.portas.repositories.ProdutoRepositoryPort;

@Configuration
public class BeanConfiguracao {
	
	@Bean
	ProdutoServicePort produtoServicePort(ProdutoRepositoryPort produtoRepositoryPort) {
		return new PedidoServiceImpl(produtoRepositoryPort);
	}

}
