package com.anagabriella.restaurante.service;
import org.springframework.stereotype.Service;
import com.anagabriella.restaurante.entity.Admin;
import com.anagabriella.restaurante.repository.AdminRepository;
import java.util.Optional;
import java.util.List;

@Service
public class AdminService {
     private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
}

public Admin cadastrarAdmin(Admin admin) {
    return adminRepository.save(admin);
}

public Optional<Admin> buscarAdmPorId(Long id) {
    return adminRepository.findById(id);
}

public void apagarAdmin(Admin admin) {
    adminRepository.delete(admin);
}

public Admin atualizarAdmin(Admin admin) {
    return adminRepository.save(admin);
}

public List<Admin> buscarTodosAdm() {
    return adminRepository.findAll();
}
}
