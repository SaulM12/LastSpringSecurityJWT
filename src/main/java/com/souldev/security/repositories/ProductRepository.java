package com.souldev.security.repositories;

import com.souldev.security.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
    
    
}
