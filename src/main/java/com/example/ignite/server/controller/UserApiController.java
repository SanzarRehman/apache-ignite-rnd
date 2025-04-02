package com.example.ignite.server.controller;

import com.example.ignite.server.dto.UserDTO;
import com.example.ignite.server.entity.Customer;
import com.example.ignite.server.entity.Order;
import com.example.ignite.server.entity.Product;
import com.example.ignite.server.entity.User;
import com.example.ignite.server.service.CustomerService;
import com.example.ignite.server.service.OrderService;
import com.example.ignite.server.service.ProductService;
import com.example.ignite.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
        * REST Controller to handle requests.
 */
@RestController
@RequestMapping("/api")
public class UserApiController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<User> getUsers(@RequestParam Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody UserDTO userDTO) {
        // Check if the ID is provided in the body
        if (userDTO.getId() == 0) {
            return ResponseEntity.badRequest().build(); // Return 400 Bad Request if ID is missing or invalid
        }

        // Find the existing user by ID
        User existingUser = userService.getUserById(userDTO.getId());

        if (existingUser == null) {
            // If user not found, return 404 Not Found
            return ResponseEntity.notFound().build();
        }

        // Update user details
        existingUser.setName(userDTO.getName());
        existingUser.setEmail(userDTO.getEmail());

        // Save updated user
        User updatedUser = userService.saveUser(existingUser);

        return ResponseEntity.ok(updatedUser); // Return updated user
    }

    // User Endpoints
    @PostMapping("/user")
    public ResponseEntity<List<User>> createRandomUsers() {
        Random random = new Random();
        List<User> createdUsers = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            // Create random user data
            long id = random.nextLong(); // Random long ID (can be negative)

            // Ensure the ID is positive
            if (id < 0) {
                id = Math.abs(id);
            }

            String name = "DAN" + (i + 1); // Random name
            String email = "user" + (i + 1) + "@example.com"; // Random email

            // Set user data
            UserDTO userDTO = new UserDTO();
            userDTO.setId(id);
            userDTO.setName(name);
            userDTO.setEmail(email);

            // Create user entity and save it
            User user = new User();
            user.setId(userDTO.getId());
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());

            createdUsers.add(userService.saveUser(user));
        }

        return ResponseEntity.ok(createdUsers);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @GetMapping("/users/db")
    public ResponseEntity<List<User>> getAlldbUsers() {
        return ResponseEntity.ok(userService.getAlldbUsers());
    }

}
