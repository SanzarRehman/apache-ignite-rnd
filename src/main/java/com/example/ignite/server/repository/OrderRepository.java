package com.example.ignite.server.repository;

import com.example.ignite.server.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA Repository for accessing Order data from the database.
 */

public interface OrderRepository extends MongoRepository<Order, Long> {
}

