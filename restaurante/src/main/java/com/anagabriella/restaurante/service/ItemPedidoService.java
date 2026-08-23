package com.anagabriella.restaurante.service;
import org.springframework.stereotype.Service;
import com.anagabriella.restaurante.entity.ItemPedido;
import com.anagabriella.restaurante.entity.Produto;
import com.anagabriella.restaurante.repository.ItemPedidoRepository;
import com.anagabriella.restaurante.repository.ProdutoRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;
    private final ProdutoRepository produtoRepository;

    public ItemPedidoService(
            ItemPedidoRepository itemPedidoRepository,
            ProdutoRepository produtoRepository) {

        this.itemPedidoRepository = itemPedidoRepository;
        this.produtoRepository = produtoRepository;
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

public ItemPedido verificarExistenciaItemPedido(Long id) {

    Optional<ItemPedido> item = itemPedidoRepository.findById(id); ///a variavel item é uma caixa que pode conter um itmpedido ou estar vazia

   if (item.isEmpty()) {
    throw new IllegalArgumentException("ItemPedido não encontrado");
    }
    return item.get();
    }

public Produto verificarExistenciaProduto(Long id) {

    Optional<Produto> produto = produtoRepository.findById(id);

    if (produto.isEmpty()) {
    throw new IllegalArgumentException("Produto não encontrado.");
    }
    return produto.get();
}
    
public void validarProduto(Long id, Integer quantidade) {

    Produto produto = verificarExistenciaProduto(id);

    ItemPedido item = new ItemPedido();
    item.validarQuantidade(quantidade);

    if (!produto.getDisponivel()) {
        throw new IllegalArgumentException("Produto indisponível.");
    }
}

}














