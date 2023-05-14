package com.example.databaseteamproject.repository;


import com.example.databaseteamproject.entity.Product;
import com.example.databaseteamproject.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

      Optional<Product> findByProductName(String productName);

}
