package com.example.databaseteamproject.service;


import com.example.databaseteamproject.entity.Shipment;
import com.example.databaseteamproject.payload.ApiResponse;
import com.example.databaseteamproject.payload.ShipmentDto;
import com.example.databaseteamproject.repository.ShipmentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShipmentService {

    @Autowired
    ShipmentRepository qaRepository;

    public List<Shipment> getAll(){
        return qaRepository.findAll();

    }

    public Shipment getById(Integer id){
        Optional<Shipment> byId = qaRepository.findById(id);
        return byId.orElse(null);
    }

    public ApiResponse addQA(@Valid ShipmentDto shipmentDto){
        Shipment shipment = new Shipment();
        shipment.setApproved(shipmentDto.getApproved());
        shipment.setDate(shipmentDto.getDate());
        shipment.setShipmentType(shipmentDto.getShipmentType());
        Shipment save = qaRepository.save(shipment);

        return new ApiResponse("saved with id: "+save.getAgreementId(), true);
    }

    public ApiResponse deleteQA(Integer id){

        Optional<Shipment> byId = qaRepository.findById(id);
        if (byId.isEmpty()) {
            return new ApiResponse("no element with such id", false);
        }

        qaRepository.deleteById(id);
        return new ApiResponse("deleted", true);

    }

}
