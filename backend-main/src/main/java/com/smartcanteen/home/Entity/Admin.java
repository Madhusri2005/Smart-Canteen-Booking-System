package com.smartcanteen.home.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Change 'name' to 'canteenName' to match your React state
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String role = "ADMIN";
}