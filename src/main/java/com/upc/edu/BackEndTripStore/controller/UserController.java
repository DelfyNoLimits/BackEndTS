package com.upc.edu.BackEndTripStore.controller;

import com.upc.edu.BackEndTripStore.exception.ValidationException;
import com.upc.edu.BackEndTripStore.model.User;
import com.upc.edu.BackEndTripStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tripstore/v1")

public class UserController {
    HttpHeaders headers = new HttpHeaders();
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/authenticate")

    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> credentials) {

        headers.add("Access-Control-Allow-Origin", "*");
        String username = credentials.get("username");
        String password = credentials.get("password");

        User user = userService.getUserByUsernameAndPassword(username, password);

        if (user != null) {
            Map<String, String> response = new HashMap<>();
            response.put("id", String.valueOf(user.getId()));
            response.put("username", user.getUsername());
            response.put("password", user.getPassword());

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @GetMapping("/users")

    public List<User> getAllUsers() {
        headers.add("Access-Control-Allow-Origin", "*");
        return userService.getAllUsers();

    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) { headers.add("Access-Control-Allow-Origin", "*");
        return userService.getUserById(id);
    }
    @PostMapping("/users")
    @Transactional
    public User createUser(@RequestBody  User user) { headers.add("Access-Control-Allow-Origin", "*");
        validateUser(user);
        return userService.createUser(user);
    }
    @PutMapping("users/{id}")
    @Transactional
    public User updateUser(@PathVariable int id, @RequestBody User updatedUser) { headers.add("Access-Control-Allow-Origin", "*");
        validateUser(updatedUser);
        return userService.updateUser(id, updatedUser);
    }
    @DeleteMapping("users/{id}")
    @Transactional
    public void deleteUser(@PathVariable int id) { headers.add("Access-Control-Allow-Origin", "*");

        userService.deleteUser(id);
    }


    // User Post Validation
    public void validateUser(User user) {
        // Validate username, password, name, lastname, email and phone

        // Username Validation
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new ValidationException("Username is required");

        }
       if (user.getUsername().length()>30) {
            throw new ValidationException("Username must not be more than 30 characters");
        }

        // Password Validation
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new ValidationException("Password is required");
        }
      if (user.getPassword().length()>30) {
            throw new ValidationException("Password must not be more than 30 characters");
        }

        // Name Validation
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new ValidationException("Name is required");
        }
        if (user.getName().length()>30) {
            throw new ValidationException("Name must not be more than 30 characters");
        }

        // Lastname Validation
        if (user.getLastname() == null || user.getLastname().trim().isEmpty()) {
            throw new ValidationException("Lastname is required");
        }
        if (user.getLastname().length()>30) {
            throw new ValidationException("Lastname must not be more than 30 characters");
        }

        // Email Validation
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            throw new ValidationException("Email is required");
        }
        if (user.getEmail().length()>50) {
            throw new ValidationException("Email must not be more than 50 characters");
        }

        // Phone Validation
        if (user.getPhone() == null || user.getPhone().trim().isEmpty()) {
            throw new ValidationException("Phone is required");
        }
        if (user.getPhone().length()>9) {
            throw new ValidationException("Phone must not be more than 9 characters");
        }
       // return contador;
    }

}
