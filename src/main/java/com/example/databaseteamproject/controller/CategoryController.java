package com.example.databaseteamproject.controller;

import com.example.databaseteamproject.entity.Category;
import com.example.databaseteamproject.payload.ApiResponse;
import com.example.databaseteamproject.payload.CategoryDto;
import com.example.databaseteamproject.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryService roomService;

    @GetMapping
    public HttpEntity<?> findAll(){
        List<Category> all = roomService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public HttpEntity<?> getById(@PathVariable String id){
        Category byId = roomService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody CategoryDto roomDTO){
        ApiResponse apiResponse = roomService.addQA(roomDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteQA(@PathVariable String id){
        ApiResponse apiResponse = roomService.deleteQA(id);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
