package com.example.ignite.server.repository;

import com.example.ignite.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA Repository for accessing User data from the database.
 */

public interface UserRepository extends MongoRepository<User, Long> {}
