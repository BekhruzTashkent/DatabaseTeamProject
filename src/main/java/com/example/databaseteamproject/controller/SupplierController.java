package com.example.databaseteamproject.controller;

import com.example.databaseteamproject.payload.ApiResponse;
import com.example.databaseteamproject.payload.SupplierDto;
import com.example.databaseteamproject.service.SupplierService;
import com.example.databaseteamproject.entity.Supplier;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/supplier")
public class SupplierController {
    @Autowired
    SupplierService roomService;

    @GetMapping
    public HttpEntity<?> findAll(){
        List<Supplier> all = roomService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public HttpEntity<?> getById(@PathVariable String id){
        Supplier byId = roomService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody SupplierDto roomDTO){
        ApiResponse apiResponse = roomService.addSupplier(roomDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteQA(@PathVariable String id){
        ApiResponse apiResponse = roomService.deleteSupplier(id);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
