package com.smartcanteen.home.service;

import com.smartcanteen.home.Entity.Admin;
import com.smartcanteen.home.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin registerAdmin(Admin admin) {
        // Check if admin already exists
        if(adminRepository.findByEmail(admin.getEmail()).isPresent()) {
            throw new RuntimeException("Admin with this email already exists!");
        }
        return adminRepository.save(admin);
    }

    public Admin loginAdmin(String email, String password) {
        return adminRepository.findByEmail(email)
                .filter(admin -> admin.getPassword().equals(password))
                .orElse(null);
    }
}