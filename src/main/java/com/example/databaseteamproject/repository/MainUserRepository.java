package com.example.databaseteamproject.repository;

import com.example.databaseteamproject.entity.Bucket;
import com.example.databaseteamproject.entity.MainUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainUserRepository extends JpaRepository<MainUser, String> {



}
