package com.smartcanteen.home.Entity;

import java.util.*;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "canteen_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;

    private Double totalAmount;
    private String pickupTime;
    private String transactionId; // The UTR entered by user
    private String status;        // PENDING, PAID, PREPARING, READY, COMPLETED
    private String tokenNumber;   // Generated only after Admin clicks 'Confirm'

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id") // This links the tables correctly in MySQL
    private List<OrderItem> items;
}