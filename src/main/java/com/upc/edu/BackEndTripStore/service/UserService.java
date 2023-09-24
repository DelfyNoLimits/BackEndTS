package com.upc.edu.BackEndTripStore.service;

import com.upc.edu.BackEndTripStore.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(int id);
    User createUser(User user);
    User updateUser(int id, User updatedUser);
    void deleteUser(int id);
    User getUserByUsernameAndPassword(String username, String password);
}
