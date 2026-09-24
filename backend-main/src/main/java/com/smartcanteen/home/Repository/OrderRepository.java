package com.smartcanteen.home.Repository;

import com.smartcanteen.home.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // This allows the History page to show orders only for the logged-in user
    List<Order> findByUserEmail(String userEmail);

}