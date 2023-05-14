package com.example.databaseteamproject.repository;

import com.example.databaseteamproject.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, String> {

//    Optional<Supplier> findByMainUser_Username(String username);


}
