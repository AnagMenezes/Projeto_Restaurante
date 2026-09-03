package com.anagabriella.restaurante.controller;
import com.anagabriella.restaurante.entity.ItemPedido;
import com.anagabriella.restaurante.service.ItemPedidoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itempedido") ///mapeamento de requisições
public class ItemPedidoController {

    private final ItemPedidoService itempedidoService;

    public ItemPedidoController(ItemPedidoService itempedidoService) {
        this.itempedidoService = itempedidoService;
    }

    @PostMapping
    public ItemPedido cadastrarItemPedido(@RequestBody ItemPedido itempedido) {
        return itempedidoService.cadastrarItemPedido(itempedido);
    }

    @GetMapping("/{id}")
    public Optional<ItemPedido> buscarItemPedidoPorId(@PathVariable Integer id) {
        return itempedidoService.buscarItemPedidoPorId(id);
    }

    @GetMapping
    public List<ItemPedido> buscarTodosItemPedido() {
        return itempedidoService.buscarTodosItemPedido();
    }

    @PutMapping
    public ItemPedido atualizarItemPedido(@RequestBody ItemPedido itempedido) {
        return itempedidoService.atualizarItemPedido(itempedido);
    }

    @DeleteMapping
    public void apagarItemPedido(@RequestBody ItemPedido itempedido) {
        itempedidoService.apagarItemPedido(itempedido);
    }
}