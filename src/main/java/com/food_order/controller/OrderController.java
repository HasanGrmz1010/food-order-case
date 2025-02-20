package com.food_order.controller;

import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food_order.service.OrderService;
import com.food_order.model.*;
import com.food_order.service.FoodService;

@RestController
@RequestMapping("/order")

public class OrderController {
    private final OrderService orderService;
    private final FoodService foodService;

    public OrderController(OrderService _orderService, FoodService _foodService){
        this.orderService = _orderService;
        this.foodService = _foodService;
    }

    @PostMapping
    public ResponseEntity<?> CreateOrder(@RequestParam String customerName, @RequestParam String foodName){
        Optional<Food> food = foodService.getFoodByName(foodName);
        if(food.isPresent()){
            return ResponseEntity.ok(orderService.createOrder(customerName, food.get()));
        }
        return ResponseEntity.badRequest().body("FOOD NOT FOUND");
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Order>> getOrdersByCustomer(@RequestParam String customerName) {
        if (customerName != null && !customerName.isEmpty())
        {
            return ResponseEntity.ok(orderService.getOrdersByCustomer(customerName));
        }
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping
    public ResponseEntity<List<Order>> GetAllOrders(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }

}
