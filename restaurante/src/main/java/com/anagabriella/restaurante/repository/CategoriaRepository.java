package com.anagabriella.restaurante.repository;
import com.anagabriella.restaurante.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
