package com.upc.edu.BackEndTripStore.service.impl;

import com.upc.edu.BackEndTripStore.model.Order;
import com.upc.edu.BackEndTripStore.repository.OrderRepository;
import com.upc.edu.BackEndTripStore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(int id, Order order) {
        Order orderToUpdate = orderRepository.findById(id).orElse(null);
        if (orderToUpdate != null) {
            orderToUpdate.setOrderDate(order.getOrderDate());
            orderToUpdate.setWaitingTime(order.getWaitingTime());
            orderToUpdate.setOrderStatus(order.getOrderStatus());
            orderToUpdate.setTotalPrice(order.getTotalPrice());
            orderToUpdate.setPaymentMethod(order.getPaymentMethod());
            orderToUpdate.setPaymentAmount(order.getPaymentAmount());
            orderToUpdate.setCartItems(order.getCartItems());
            return orderRepository.save(orderToUpdate);
        } else {
            return null;
        }
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}
