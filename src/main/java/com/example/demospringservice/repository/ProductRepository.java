package com.example.demospringservice.repository;

import com.example.demospringservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
