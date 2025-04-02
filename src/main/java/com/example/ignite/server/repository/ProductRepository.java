package com.example.ignite.server.repository;

import com.example.ignite.server.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA Repository for accessing Product data from the database.
 */

public interface ProductRepository extends MongoRepository<Product, Long> {
}
