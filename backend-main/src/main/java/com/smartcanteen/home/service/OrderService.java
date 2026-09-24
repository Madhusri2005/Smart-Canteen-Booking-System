package com.smartcanteen.home.Service;

import com.smartcanteen.home.Entity.Order;
import com.smartcanteen.home.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order placeOrder(Order order) {
        // Automatically set status to PAID when saved
        order.setStatus("PAID");

        // Generate a Token Number (e.g., TK-482)
        String token = "TK-" + (100 + new Random().nextInt(900));
        order.setTokenNumber(token);

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrdersByEmail(String email) {
        return orderRepository.findByUserEmail(email);
    }

    public Order updateStatus(Long id, String status) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        return orderRepository.save(order);
    }
}