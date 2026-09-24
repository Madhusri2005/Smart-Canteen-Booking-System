package com.smartcanteen.home.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity // <--- THIS WAS MISSING
@Data
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer qty;
    private Double price;
}