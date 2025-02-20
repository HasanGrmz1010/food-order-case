package com.food_order.service;

import com.food_order.model.Food;
import com.food_order.model.Order;
import com.food_order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository _orderRepo) {
        this.orderRepository = _orderRepo;
    }

    public Order createOrder(String customerName, Food food) {
        return orderRepository.save(new Order(customerName, food));
    }

    public List<Order> getOrdersByCustomer(String customerName) {
        return orderRepository.findByCustomerName(customerName);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}