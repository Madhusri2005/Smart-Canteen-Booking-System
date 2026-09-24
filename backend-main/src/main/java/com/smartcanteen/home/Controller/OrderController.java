package com.smartcanteen.home.Controller;

import com.smartcanteen.home.Entity.Order;
import com.smartcanteen.home.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class OrderController {

    private final OrderService orderService;

    // 1. Place Order (Triggered by Payment.jsx)
    @PostMapping("/place")
    public Order placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }

    // 2. For Preparation Checklist & Analytics Dashboard
    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // 3. For User History Page (Finds orders by logged-in email)
    @GetMapping("/user/{email}")
    public List<Order> getUserOrders(@PathVariable String email) {
        return orderService.getOrdersByEmail(email);
    }

    // 4. For Admin to update status (PAID -> READY -> DELIVERED)
    @PatchMapping("/update-status/{id}")
    public Order updateStatus(@PathVariable Long id, @RequestParam String status) {
        return orderService.updateStatus(id, status);
    }
}