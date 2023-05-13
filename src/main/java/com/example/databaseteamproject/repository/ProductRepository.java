package com.example.databaseteamproject.repository;

import com.example.databaseteamproject.entity.Bucket;
import com.example.databaseteamproject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {



}
