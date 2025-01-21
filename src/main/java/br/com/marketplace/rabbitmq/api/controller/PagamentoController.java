package br.com.marketplace.rabbitmq.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marketplace.rabbitmq.api.domain.dto.PagamentoResponse;
import br.com.marketplace.rabbitmq.api.service.PagamentoService;

@RestController
@RequestMapping("pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping("/listar")
    public ResponseEntity<List<PagamentoResponse>> listar(){
        return ResponseEntity.ok(pagamentoService.listar()
            .stream().map(pagamento -> new PagamentoResponse(pagamento)).collect(Collectors.toList()));
    }
}
