package com.anagabriella.restaurante.service;
import org.springframework.stereotype.Service;
import com.anagabriella.restaurante.entity.ItemPedido;
import com.anagabriella.restaurante.entity.Produto;
import com.anagabriella.restaurante.repository.ItemPedidoRepository;
import com.anagabriella.restaurante.repository.ProdutoRepository;

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

        validarProduto(
                itemPedido.getProduto().getId(),
                itemPedido.getQuantidade()
        );

        return itemPedidoRepository.save(itemPedido);
    }

    public Optional<ItemPedido> buscarItemPedidoPorId(Integer id) {
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
    
    public ItemPedido verificarExistenciaItemPedido(Integer id) {

        Optional<ItemPedido> item = itemPedidoRepository.findById(id);

        if (item.isEmpty()) {
            throw new IllegalArgumentException("ItemPedido não encontrado");
        }

        return item.get();
    }

    public Produto verificarExistenciaProduto(Integer id) {

        Optional<Produto> produto = produtoRepository.findById(id);

        if (produto.isEmpty()) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }

        return produto.get();
    }

    public void validarProduto(Integer id, Integer quantidade) {

        Produto produto = verificarExistenciaProduto(id);

        ItemPedido item = new ItemPedido();
        item.validarQuantidade(quantidade);

        if (!produto.getDisponivel()) {
            throw new IllegalArgumentException("Produto indisponível.");
        }
    }
}
