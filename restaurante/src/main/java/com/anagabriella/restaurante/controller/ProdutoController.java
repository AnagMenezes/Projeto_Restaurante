package com.anagabriella.restaurante.controller;
import com.anagabriella.restaurante.entity.Produto;
import com.anagabriella.restaurante.service.ProdutoService;

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
@RequestMapping("/produtos") ///mapeamento de requisições
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public Produto cadastrarProduto(@RequestBody Produto produto) {
        return produtoService.cadastrarProduto(produto);
    }

    @GetMapping("/{id}")
    public Optional<Produto> buscarProdutoPorId(@PathVariable Integer id) {
        return produtoService.buscaProdutoPorId(id);
    }

    @GetMapping
    public List<Produto> buscarTodosProdutos() {
        return produtoService.buscarTodosProdutos();
    }

    @PutMapping
    public Produto atualizarProduto(@RequestBody Produto produto) {
        return produtoService.atualizarProduto(produto);
    }

    @DeleteMapping
    public void apagarProduto(@RequestBody Produto produto) {
        produtoService.apagarProduto(produto);
    }
}