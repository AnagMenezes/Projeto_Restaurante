package com.anagabriella.restaurante.controller;
import com.anagabriella.restaurante.entity.Pedido;
import com.anagabriella.restaurante.service.PedidoService;

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
@RequestMapping("/pedido") ///mapeamento de requisições
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public Pedido cadastrarPedido(@RequestBody Pedido pedido) {
        return pedidoService.cadastrarPedido(pedido);
    }

    @GetMapping("/{id}")
    public Optional<Pedido> buscarPedidoPorId(@PathVariable Integer id) {
        return pedidoService.buscarPedidoPorId(id);
    }

    @GetMapping
    public List<Pedido> buscarTodosPedidos() {
        return pedidoService.buscarTodosPedidos();
    }

    @PutMapping
    public Pedido atualizarPedido(@RequestBody Pedido pedido) {
        return pedidoService.atualizarPedido(pedido);
    }

    @DeleteMapping
    public void apagarPedido(@RequestBody Pedido pedido) {
        pedidoService.apagarPedido(pedido);
    }
}