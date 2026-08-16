package com.anagabriella.restaurante.repository;
import com.anagabriella.restaurante.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
