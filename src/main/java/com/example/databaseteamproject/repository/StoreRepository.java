package com.example.databaseteamproject.repository;

import com.example.databaseteamproject.entity.Bucket;
import com.example.databaseteamproject.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, String> {



}
