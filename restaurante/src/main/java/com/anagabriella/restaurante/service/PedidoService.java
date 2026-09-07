package com.anagabriella.restaurante.service;
import org.springframework.stereotype.Service;
import com.anagabriella.restaurante.entity.Pedido;
import com.anagabriella.restaurante.entity.Produto;
import com.anagabriella.restaurante.entity.ItemPedido;
import com.anagabriella.restaurante.repository.PedidoRepository;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ItemPedidoService itemPedidoService;

   public PedidoService(
        PedidoRepository pedidoRepository,
        ItemPedidoService itemPedidoService) {

    this.pedidoRepository = pedidoRepository;
    this.itemPedidoService = itemPedidoService;
}

public Pedido cadastrarPedido(Pedido pedido) {
    return pedidoRepository.save(pedido);
}

public Optional<Pedido> buscarPedidoPorId(Integer id) {
    return pedidoRepository.findById(id);
}

public void apagarPedido(Pedido pedido) {
    pedidoRepository.delete(pedido);
}

public Pedido atualizarPedido(Pedido pedido) {
    return pedidoRepository.save(pedido);
}

public List<Pedido> buscarTodosPedidos() {
    return pedidoRepository.findAll();
}

public Pedido verificarExistenciaPedido(Integer id) {

    Optional<Pedido> pedido = pedidoRepository.findById(id);

    if (pedido.isEmpty()) {
    throw new IllegalArgumentException("Pedido inexistente.");
    }
    return pedido.get();
}

public Pedido adicionarItem(Integer idPedido, ItemPedido novoItem) { 

    Pedido pedido = verificarExistenciaPedido(idPedido);

    Produto produto = itemPedidoService.validarProduto(
            novoItem.getProduto().getId(),
            novoItem.getQuantidade()
    );

    novoItem.setPrecoUnitario(produto.getPreco());

    novoItem.setPedido(pedido);

    pedido.getItens().add(novoItem);

    pedido.atualizarValorTotal();

    return pedidoRepository.save(pedido);
}

}







