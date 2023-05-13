package com.example.databaseteamproject.service;


import com.example.databaseteamproject.entity.DeliveryService;
import com.example.databaseteamproject.payload.ApiResponse;
import com.example.databaseteamproject.payload.DeliveryServiceDto;
import com.example.databaseteamproject.repository.DeliveryServiceRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeliveryServiceService {

    @Autowired
    DeliveryServiceRepository qaRepository;

    public List<DeliveryService> getAll(){
        return qaRepository.findAll();

    }

    public DeliveryService getById(String id){
        Optional<DeliveryService> byId = qaRepository.findById(id);
        return byId.orElse(null);
    }

    public ApiResponse addQA(@Valid DeliveryServiceDto deliveryServiceDto){
        DeliveryService deliveryService = new DeliveryService();
        deliveryService.setDeliveryName(deliveryServiceDto.getDeliveryName());
        deliveryService.setPrice(deliveryServiceDto.getPrice());
        DeliveryService save = qaRepository.save(deliveryService);

        return new ApiResponse("saved with id: "+save.getDeliveryName(), true);
    }


    public ApiResponse deleteQA(String id){

        Optional<DeliveryService> byId = qaRepository.findById(id);
        if (byId.isEmpty()) {
            return new ApiResponse("no element with such id", false);
        }

        qaRepository.deleteById(id);
        return new ApiResponse("deleted", true);

    }

}
