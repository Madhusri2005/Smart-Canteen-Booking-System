package com.smartcanteen.home.Controller;

import com.smartcanteen.home.Entity.Admin;
import com.smartcanteen.home.dto.LoginRequest;
import com.smartcanteen.home.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody Admin admin) {
        try {
            Admin createdAdmin = adminService.registerAdmin(admin);
            return ResponseEntity.ok(createdAdmin);
        } catch (Exception e) {
            // This will now tell you EXACTLY why it failed in the browser console
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Admin admin = adminService.loginAdmin(loginRequest.getEmail(), loginRequest.getPassword());
        if (admin != null) {
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.status(401).body("Invalid Admin Credentials");
        }
    }
}