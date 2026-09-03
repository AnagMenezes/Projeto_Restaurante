package com.anagabriella.restaurante.controller;
import com.anagabriella.restaurante.entity.Categoria;
import com.anagabriella.restaurante.service.CategoriaService;

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
@RequestMapping("/categoria") ///mapeamento de requisições
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public Categoria cadastrarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.cadastrarCategoria(categoria);
    }

    @GetMapping("/{id}")
    public Optional<Categoria> buscarCategoriaPorId(@PathVariable Integer id) {
        return categoriaService.buscarCategoriaPorId(id);
    }

    @GetMapping
    public List<Categoria> buscarTodasCategorias() {
        return categoriaService.buscarTodasCategorias();
    }

    @PutMapping
    public Categoria atualizarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.atualizarCategoria(categoria);
    }

    @DeleteMapping
    public void apagarAdmin(@RequestBody Categoria categoria) {
        categoriaService.apagarCategoria(categoria);
    }
}