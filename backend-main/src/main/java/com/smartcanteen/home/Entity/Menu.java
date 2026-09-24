package com.smartcanteen.home.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "menu_items")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private String category;
    // Inside your existing Order class


    @Lob // Use @Lob for large Base64 strings
    @Column(columnDefinition = "LONGTEXT")
    private String imageUrl; // This will store the Base64 string
}