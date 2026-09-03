package com.anagabriella.restaurante.repository;
import com.anagabriella.restaurante.entity.Produto;
///esse repositorio vai trabalhar com essa entity
import org.springframework.data.jpa.repository.JpaRepository;
///spring data jpa

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}

