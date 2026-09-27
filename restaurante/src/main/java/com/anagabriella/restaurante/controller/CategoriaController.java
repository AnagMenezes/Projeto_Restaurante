package com.anagabriella.restaurante.controller;
import com.anagabriella.restaurante.entity.Categoria;
import com.anagabriella.restaurante.service.CategoriaService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
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

@PutMapping("/{id}")
public Categoria atualizarCategoria(
        @PathVariable Integer id,
        @RequestBody Categoria categoria) {

    categoria.setId(id);

    return categoriaService.atualizarCategoria(id, categoria);
}

@DeleteMapping("/{id}")
    public void deletarCategoria(@PathVariable Integer id) {
        categoriaService.deletarCategoria(id);
}
}