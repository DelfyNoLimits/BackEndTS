package com.upc.edu.BackEndTripStore.service.impl;

import com.upc.edu.BackEndTripStore.exception.ResourceNotFoundException;
import com.upc.edu.BackEndTripStore.model.User;
import com.upc.edu.BackEndTripStore.repository.UserRepository;
import com.upc.edu.BackEndTripStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    HttpHeaders headers = new HttpHeaders();

    private final UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {headers.add("Access-Control-Allow-Origin", "*");
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {headers.add("Access-Control-Allow-Origin", "*");
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    @Override
    public User createUser(User user) {headers.add("Access-Control-Allow-Origin", "*");
        return userRepository.save(user);
    }

    @Override
    public User updateUser(int id, User updatedUser) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setName(updatedUser.getName());
        existingUser.setLastname(updatedUser.getLastname());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPhone(updatedUser.getPhone());

        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userRepository.delete(userOptional.get());
        } else {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) { headers.add("Access-Control-Allow-Origin", "*");
        return userRepository.findByUsernameAndPassword(username, password);
    }



}
