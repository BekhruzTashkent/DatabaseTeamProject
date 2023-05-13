package com.example.databaseteamproject.controller;

import com.example.databaseteamproject.entity.Store;
import com.example.databaseteamproject.payload.ApiResponse;
import com.example.databaseteamproject.payload.StoreDto;
import com.example.databaseteamproject.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/store")
public class StoreController {
    @Autowired
    StoreService roomService;

    @GetMapping
    public HttpEntity<?> findAll(){
        List<Store> all = roomService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public HttpEntity<?> getById(@PathVariable String id){
        Store byId = roomService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody StoreDto roomDTO){
        ApiResponse apiResponse = roomService.addStore(roomDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteQA(@PathVariable String id){
        ApiResponse apiResponse = roomService.deleteStore(id);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
