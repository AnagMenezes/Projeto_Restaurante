package com.anagabriella.restaurante.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.anagabriella.restaurante.entity.Categoria;
import com.anagabriella.restaurante.entity.Produto;
import com.anagabriella.restaurante.repository.CategoriaRepository;
import com.anagabriella.restaurante.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(
            ProdutoRepository produtoRepository,
            CategoriaRepository categoriaRepository) {

        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public Produto cadastrarProduto(Produto produto) {

        Integer categoriaId = produto.getCategoria().getId();

        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada."));

        produto.setCategoria(categoria);

        return produtoRepository.save(produto);
    }

    public Optional<Produto> buscaProdutoPorId(Integer id) {
        return produtoRepository.findById(id);
    }

    public void apagarProduto(Integer id) {
        produtoRepository.deleteById(id);
    }

    public Produto atualizarProduto(Integer id, Produto produto) {

        Produto produtoExistente = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado."));

        produtoExistente.setNome(produto.getNome());
        produtoExistente.setDescricao(produto.getDescricao());
        produtoExistente.setPreco(produto.getPreco());
        produtoExistente.setImagem(produto.getImagem());
        produtoExistente.setDisponivel(produto.getDisponivel());

        Integer categoriaId = produto.getCategoria().getId();

        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada."));

        produtoExistente.setCategoria(categoria);

        return produtoRepository.save(produtoExistente);
    }

    public List<Produto> buscarTodosProdutos() {
        return produtoRepository.findAll();
    }
}