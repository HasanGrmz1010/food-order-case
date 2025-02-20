package com.food_order.repository;

import com.food_order.model.Food;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long>{
Optional<Food> findByName(String name);
}
