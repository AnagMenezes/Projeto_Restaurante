package com.anagabriella.restaurante.service;
import org.springframework.stereotype.Service;
import com.anagabriella.restaurante.entity.Pedido;
import com.anagabriella.restaurante.entity.ItemPedido;
import com.anagabriella.restaurante.repository.PedidoRepository;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
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

    novoItem.setPedido(pedido);

    pedido.getItens().add(novoItem); 

    return pedidoRepository.save(pedido);
}

/*public Pedido atualizarStatus(Long idPedido, String novoStatus) {
    Pedido pedido = verificarExistenciaPedido(idPedido);

    pedido.setStatus(novoStatus);

    return pedidoRepository.save(pedido);*/
}







