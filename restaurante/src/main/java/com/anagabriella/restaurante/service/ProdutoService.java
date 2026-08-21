package com.anagabriella.restaurante.service;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional; ///caso nao exista produto, pedimos para o java retornar algo
import com.anagabriella.restaurante.entity.Produto;
import com.anagabriella.restaurante.repository.ProdutoRepository;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
}


public Produto cadastrarProduto(Produto produto) {
    return produtoRepository.save(produto);
}

public Optional<Produto> buscaProdutoPorId(Long id) {
    return produtoRepository.findById(id);
}

public void apagarProduto(Produto produto) {
    produtoRepository.delete(produto);
}

public Produto atualizarProduto(Produto produto) {
    return produtoRepository.save(produto);
}

public List<Produto> buscarTodosProdutos() {
    return produtoRepository.findAll();
}
}