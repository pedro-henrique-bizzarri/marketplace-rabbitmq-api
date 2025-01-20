package br.com.marketplace.rabbitmq.api.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marketplace.rabbitmq.api.domain.entity.ItemPedido;
import br.com.marketplace.rabbitmq.api.domain.entity.Pagamento;
import br.com.marketplace.rabbitmq.api.domain.entity.Pedido;
import br.com.marketplace.rabbitmq.api.domain.entity.Produto;
import br.com.marketplace.rabbitmq.api.domain.entity.Usuario;
import br.com.marketplace.rabbitmq.api.domain.enums.StatusPedidoEnum;
import br.com.marketplace.rabbitmq.api.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PagamentoService pagamentoService;
    
    @Autowired
    private PedidoRepository pedidoRepository;

    public Pagamento finalizar(Pagamento pagamento){
        preenchePedido(pagamento);
        pagamento.setPedido(
            pedidoRepository.save(pagamento.getPedido()));

        preencheUsuario(pagamento.getUsuario());
        pagamentoService.realizarPagamento(pagamento);

        return pagamento;
    }

    private void preencheItems(Pedido pedido){
        for (ItemPedido item : pedido.getItens()) {
            Produto produto = produtoService.pesquisarPorCodigo(item.getProduto().getCodigo());
            item.setProduto(produto);
            item.setPedido(pedido);
        }
    }

    private void preenchePedido(Pagamento pagamento) {
        preencheItems(pagamento.getPedido());
        pagamento.getPedido().setDataPedido(new Date());
        pagamento.getPedido().setStatus(StatusPedidoEnum.AGUARDANDO_PAGAMENTO);
        pagamento.getPedido().setTotal(calculaTotal(pagamento.getPedido().getItens()));
    } 

    private void preencheUsuario(Usuario usuario) {
        Usuario pesquisado = usuarioService.pesquisarPorCodigo(usuario.getCodigo());
        usuario.setCodigo(pesquisado.getCodigo());
        usuario.setNome(pesquisado.getNome()); 
        usuario.setCpf(pesquisado.getCpf());
        usuario.setDataCriacao(pesquisado.getDataCriacao());
    }

    private double calculaTotal(List<ItemPedido> items){
        double total = 0;
        for (ItemPedido item : items) {
            total += (item.getProduto().getPreco() * item.getQuantidade());
        }

        return total;
    }

}
