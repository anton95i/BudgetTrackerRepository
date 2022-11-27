package com.backendbudgettracker.backendbudgettracker.repository;

import com.backendbudgettracker.backendbudgettracker.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}