package com.upc.edu.BackEndTripStore.service;

import com.upc.edu.BackEndTripStore.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(int id);
    Order saveOrder(Order order);
    Order updateOrder(int id, Order order);
    void deleteOrder(int id);
}
