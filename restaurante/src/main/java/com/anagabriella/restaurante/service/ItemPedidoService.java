package com.anagabriella.restaurante.service;
import org.springframework.stereotype.Service;
import com.anagabriella.restaurante.entity.ItemPedido;
import com.anagabriella.restaurante.repository.ItemPedidoRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoService {
    private final ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
}

public ItemPedido cadastrarItemPedido(ItemPedido itemPedido) {
    return itemPedidoRepository.save(itemPedido);
}

public Optional<ItemPedido> buscarItemPedidoPorId(Long id) {
    return itemPedidoRepository.findById(id);
}

public void apagarItemPedido(ItemPedido itemPedido) {
    itemPedidoRepository.delete(itemPedido);
}

public ItemPedido atualizarItemPedido(ItemPedido itemPedido) {
    return itemPedidoRepository.save(itemPedido);
}

public List<ItemPedido> buscarTodosItemPedido() {
    return itemPedidoRepository.findAll();
}
}
