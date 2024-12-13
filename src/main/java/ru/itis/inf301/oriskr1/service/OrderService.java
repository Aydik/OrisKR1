package ru.itis.inf301.oriskr1.service;

import ru.itis.inf301.oriskr1.model.Order;
import ru.itis.inf301.oriskr1.repository.OrderRepository;

import java.util.List;

public class OrderService {

    private OrderRepository repository;

    public OrderService() {
        repository = new OrderRepository();
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        return repository.findById(id);
    }
}