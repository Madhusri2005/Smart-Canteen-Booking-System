package com.smartcanteen.home.Controller;

import com.smartcanteen.home.Entity.Menu;
import com.smartcanteen.home.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
@CrossOrigin(origins = "http://localhost:5173") // Ensure this matches your React Port
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/all")
    public List<Menu> getAllFood() {
        return foodRepository.findAll();
    }

    @PostMapping("/add")
    public Menu addFood(@RequestBody Menu item) {
        return foodRepository.save(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Menu> updateFood(@PathVariable Long id, @RequestBody Menu updatedItem) {
        return foodRepository.findById(id)
                .map(item -> {
                    item.setName(updatedItem.getName());
                    item.setPrice(updatedItem.getPrice());
                    item.setCategory(updatedItem.getCategory());
                    item.setImageUrl(updatedItem.getImageUrl());
                    return ResponseEntity.ok(foodRepository.save(item));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable Long id) {
        foodRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}