package com.example.databaseteamproject.controller;

import com.example.databaseteamproject.payload.ApiResponse;
import com.example.databaseteamproject.service.ShipmentDetailService;
import com.example.databaseteamproject.entity.ShipmentDetail;
import com.example.databaseteamproject.payload.ShipmentDetailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shipmentDetail")
public class ShipmentDetailController {
    @Autowired
    ShipmentDetailService roomService;

    @GetMapping
    public HttpEntity<?> findAll(){
        List<ShipmentDetail> all = roomService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public HttpEntity<?> getById(@PathVariable String id){
        ShipmentDetail byId = roomService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody ShipmentDetailDto roomDTO){
        ApiResponse apiResponse = roomService.addQA(roomDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteQA(@PathVariable String id){
        ApiResponse apiResponse = roomService.deleteQA(id);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
