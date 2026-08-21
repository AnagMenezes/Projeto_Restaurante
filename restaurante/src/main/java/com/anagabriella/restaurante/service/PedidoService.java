package com.anagabriella.restaurante.service;
import org.springframework.stereotype.Service;
import com.anagabriella.restaurante.entity.Pedido;
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

public Optional<Pedido> buscarPedidoPorId(Long id) {
    return pedidoRepository.findById(id);
}

public void apagarPedido(Pedido pedido) {
    pedidoRepository.delete(pedido);
}

public Pedido atualizarPedido(Pedido pedido) {
    return pedidoRepository.save(pedido);
}

public List<Pedido> buscarTodosPedido() {
    return pedidoRepository.findAll();
}
}
