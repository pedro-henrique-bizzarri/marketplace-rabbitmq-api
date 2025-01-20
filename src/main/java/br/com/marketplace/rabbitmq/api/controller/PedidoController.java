package br.com.marketplace.rabbitmq.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marketplace.rabbitmq.api.domain.dto.PagamentoResponse;
import br.com.marketplace.rabbitmq.api.domain.dto.PedidoRequest;
import br.com.marketplace.rabbitmq.api.service.PedidoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("finalizar")
    public ResponseEntity<PagamentoResponse> finalizar(@RequestBody @Valid PedidoRequest request){
        return ResponseEntity.ok(new PagamentoResponse(pedidoService.finalizar(request.toPagamento())));
    }
}
