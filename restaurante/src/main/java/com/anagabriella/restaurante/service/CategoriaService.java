package com.anagabriella.restaurante.service;
import org.springframework.stereotype.Service;
import com.anagabriella.restaurante.entity.Categoria;
import com.anagabriella.restaurante.repository.CategoriaRepository;
import java.util.Optional;
import java.util.List;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
}

    public Categoria cadastrarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
}

    public Optional<Categoria> buscarCategoriaPorId(Integer id) {
        return categoriaRepository.findById(id);
}

    public void deletarCategoria(Integer id) {
        categoriaRepository.deleteById(id);
}

    public Categoria atualizarCategoria(Integer id, Categoria categoria) {

    Categoria categoriaExistente = categoriaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Categoria não encontrada."));

    categoriaExistente.setNome(categoria.getNome());

    return categoriaRepository.save(categoriaExistente);
}

    public List<Categoria> buscarTodasCategorias() {
        return categoriaRepository.findAll();
}
}
