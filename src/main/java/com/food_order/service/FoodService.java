package com.food_order.service;

import java.util.*;

import org.springframework.stereotype.Service;

//import java.util.List;
//import java.util.Optional;

import com.food_order.model.Food;
import com.food_order.repository.FoodRepository;

@Service
public class FoodService {
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository _foodRepo){
        this.foodRepository = _foodRepo;
    }

    public Food addFood(Food food){
        return foodRepository.save(food);
    }

    public List<Food> getAllFoods(){
        return foodRepository.findAll();
    }

    public Optional<Food> getFoodByName(String name){
        return foodRepository.findByName(name);
    }
}
