package com.example.databaseteamproject.repository;

import com.example.databaseteamproject.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BucketRepository extends JpaRepository<Operation, Integer> {

}
