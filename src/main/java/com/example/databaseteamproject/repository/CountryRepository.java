package com.example.databaseteamproject.repository;

import com.example.databaseteamproject.entity.Bucket;
import com.example.databaseteamproject.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, String> {

    @Override
    Optional<Country> findById(String countryName);
}
