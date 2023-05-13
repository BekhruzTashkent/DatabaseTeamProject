package com.example.databaseteamproject.repository;

import com.example.databaseteamproject.entity.Bucket;
import com.example.databaseteamproject.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {



}
