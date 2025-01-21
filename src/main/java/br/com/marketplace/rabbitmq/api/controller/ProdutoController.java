package br.com.marketplace.rabbitmq.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marketplace.rabbitmq.api.domain.entity.Produto;
import br.com.marketplace.rabbitmq.api.service.ProdutoService;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Produto>> listar(){
        return ResponseEntity.ok(produtoService.listar());
    } 
}
