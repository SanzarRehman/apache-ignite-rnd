package com.example.ignite.server.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class ProductDTO {
    @Id
    private Long id;
    private String name;
    private Double price;
}
