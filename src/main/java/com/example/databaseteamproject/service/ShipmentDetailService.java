package com.example.databaseteamproject.service;


import com.example.databaseteamproject.entity.Shipment;
import com.example.databaseteamproject.entity.ShipmentDetail;
import com.example.databaseteamproject.payload.ApiResponse;
import com.example.databaseteamproject.payload.ShipmentDetailDto;
import com.example.databaseteamproject.repository.ShipmentDetailRepository;
import com.example.databaseteamproject.repository.ShipmentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShipmentDetailService {

    @Autowired
    ShipmentDetailRepository qaRepository;

    @Autowired
    ShipmentRepository shipmentRepository;

    public List<ShipmentDetail> getAll(){
        return qaRepository.findAll();

    }

    public ShipmentDetail getById(String id){
        Optional<ShipmentDetail> byId = qaRepository.findById(id);
        return byId.orElse(null);
    }

    public ApiResponse addQA(@Valid ShipmentDetailDto shipmentDto){

        Optional<Shipment> byId = shipmentRepository.findById(shipmentDto.getAgreementId());
        if(byId.isEmpty()){
            return new ApiResponse("no such agreement on shipment found", false);
        }

        ShipmentDetail shipment = new ShipmentDetail();
        shipment.setCertified(shipmentDto.getCertified());
        shipment.setDistance(shipmentDto.getDistance());
        shipment.setTime(shipmentDto.getTime());
        shipment.setShipment(byId.get());
        ShipmentDetail save = qaRepository.save(shipment);

        return new ApiResponse("saved with id: "+save.getCertified(), true);
    }

    public ApiResponse deleteQA(String id){

        Optional<ShipmentDetail> byId = qaRepository.findById(id);
        if (byId.isEmpty()) {
            return new ApiResponse("no element with such id", false);
        }

        qaRepository.deleteById(id);
        return new ApiResponse("deleted", true);

    }

}
