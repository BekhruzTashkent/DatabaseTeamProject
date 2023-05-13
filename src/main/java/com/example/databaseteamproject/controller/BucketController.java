package com.example.databaseteamproject.controller;

import com.example.databaseteamproject.entity.Bucket;
import com.example.databaseteamproject.payload.ApiResponse;
import com.example.databaseteamproject.payload.BucketDto;
import com.example.databaseteamproject.service.BucketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/operation")
public class BucketController {
    @Autowired
    BucketService bucketService;

    @GetMapping
    public HttpEntity<?> findAll(){
        List<Bucket> all = bucketService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public HttpEntity<?> getById(@PathVariable Integer id){
        Bucket byId = bucketService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody BucketDto bucketDto){
        ApiResponse apiResponse = bucketService.addQA(bucketDto);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteQA(@PathVariable Integer id){
        ApiResponse apiResponse = bucketService.deleteQA(id);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
