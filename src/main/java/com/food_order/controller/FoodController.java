package com.food_order.controller;

import com.food_order.model.Food;
import com.food_order.service.FoodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/food")

public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService _foodService){
        this.foodService = _foodService;
    }

    @PostMapping
    public ResponseEntity<Food> addFood(@RequestBody Food food) {
        return ResponseEntity.ok(foodService.addFood(food));
    }

    @GetMapping
    public ResponseEntity<List<Food>> getAllFoods() {
        return ResponseEntity.ok(foodService.getAllFoods());
    }
}
