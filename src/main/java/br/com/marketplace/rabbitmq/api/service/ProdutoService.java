package br.com.marketplace.rabbitmq.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marketplace.rabbitmq.api.domain.entity.Produto;
import br.com.marketplace.rabbitmq.api.exception.ProductNotFoundException;
import br.com.marketplace.rabbitmq.api.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto pesquisarPorCodigo(Long codigo) {
        return produtoRepository.findByCodigo(codigo)
            .orElseThrow(ProductNotFoundException::new);
    }

}
