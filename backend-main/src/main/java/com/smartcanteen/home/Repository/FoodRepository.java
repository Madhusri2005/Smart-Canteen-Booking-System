package com.smartcanteen.home.Repository;

import com.smartcanteen.home.Entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FoodRepository extends JpaRepository<Menu, Long> {
    // Only show items that are marked as available to the students
    List<Menu> findByCategory(String category);
}