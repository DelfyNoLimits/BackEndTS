package com.upc.edu.BackEndTripStore.service.impl;

import com.upc.edu.BackEndTripStore.model.ShoppingCart;
import com.upc.edu.BackEndTripStore.repository.ShoppingCartRepository;
import com.upc.edu.BackEndTripStore.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public List<ShoppingCart> getAllShoppingCarts() {
        return shoppingCartRepository.findAll();
    }

    @Override
    public ShoppingCart getShoppingCartById(int id) {
        return shoppingCartRepository.findById(id).orElse(null);
    }

    @Override
    public ShoppingCart getShoppingCartByUserId(int id) {
        return shoppingCartRepository.findByUser_Id(id);
    }

    @Override
    public ShoppingCart saveShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void deleteShoppingCart(int id) {
        shoppingCartRepository.deleteById(id);
    }

    @Override
    public boolean existsByUser_Id(int id) {
        return shoppingCartRepository.existsByUser_Id(id);
    }
}
