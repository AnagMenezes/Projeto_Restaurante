package com.anagabriella.restaurante.repository;
import com.anagabriella.restaurante.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
