package com.example.databaseteamproject.controller;

import com.example.databaseteamproject.entity.Country;
import com.example.databaseteamproject.payload.ApiResponse;
import com.example.databaseteamproject.payload.CountryDto;
import com.example.databaseteamproject.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/country")
public class CountryController {
    @Autowired
    CountryService roomService;

    @GetMapping
    public HttpEntity<?> findAll(){
        List<Country> all = roomService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public HttpEntity<?> getById(@PathVariable String id){
        Country byId = roomService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody CountryDto roomDTO){
        ApiResponse apiResponse = roomService.addQA(roomDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteQA(@PathVariable String id){
        ApiResponse apiResponse = roomService.deleteQA(id);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
