package com.example.databaseteamproject.repository;

import com.example.databaseteamproject.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, String> {

//    Optional<MainUser> findByUsername(String username);

}
