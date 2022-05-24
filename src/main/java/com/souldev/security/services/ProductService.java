package com.souldev.security.services;

import java.util.List;

import javax.transaction.Transactional;

import com.souldev.security.entities.Product;
import com.souldev.security.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ProductService {
    
    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAll(){
        return this.productRepository.findAll();
    }
    public void create(Product product){
        this.productRepository.save(product);
    }
    
}
