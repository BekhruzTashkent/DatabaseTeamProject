package com.example.databaseteamproject.controller;

import com.example.databaseteamproject.entity.Operation;
import com.example.databaseteamproject.payload.ApiResponse;
import com.example.databaseteamproject.payload.OperationDto;
import com.example.databaseteamproject.service.OperationService;
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
public class OperationController {


    @Autowired
    OperationService operationService;

    @GetMapping
    public HttpEntity<?> findAll(){
        List<Operation> all = operationService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public HttpEntity<?> getById(@PathVariable Integer id){
        Operation byId = operationService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody OperationDto operationDto){
        ApiResponse apiResponse = operationService.addQA(operationDto);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteQA(@PathVariable Integer id){
        ApiResponse apiResponse = operationService.deleteQA(id);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
