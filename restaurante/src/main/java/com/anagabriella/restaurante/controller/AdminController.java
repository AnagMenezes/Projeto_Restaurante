package com.anagabriella.restaurante.controller;
import com.anagabriella.restaurante.entity.Admin;
import com.anagabriella.restaurante.service.AdminService;

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
@RequestMapping("/admin") ///mapeamento de requisições
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public Admin cadastrarAdmin(@RequestBody Admin admin) {
        return adminService.cadastrarAdmin(admin);
    }

    @GetMapping("/{id}")
    public Optional<Admin> buscarAdminPorId(@PathVariable Integer id) {
        return adminService.buscarAdminPorId(id);
    }

    @GetMapping
    public List<Admin> buscarTodosAdmin() {
        return adminService.buscarTodosAdmin();
    }

    @PutMapping
    public Admin atualizarAdmin(@RequestBody Admin admin) {
        return adminService.atualizarAdmin(admin);
    }

    @DeleteMapping
    public void apagarAdmin(@RequestBody Admin admin) {
        adminService.apagarAdmin(admin);
    }
}