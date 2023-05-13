package com.example.databaseteamproject.service;


import com.example.databaseteamproject.entity.Supplier;
import com.example.databaseteamproject.payload.ApiResponse;
import com.example.databaseteamproject.payload.SupplierDto;
import com.example.databaseteamproject.repository.MainUserRepository;
import com.example.databaseteamproject.repository.ProductRepository;
import com.example.databaseteamproject.repository.SupplierRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    MainUserRepository mainUserRepository;

    public List<Supplier> getAll(){
        return supplierRepository.findAll();

    }

    public Supplier getById(String id){
        Optional<Supplier> byId = supplierRepository.findById(id);
        return byId.orElse(null);
    }

    public ApiResponse addSupplier(@Valid SupplierDto supplierDto){
        Supplier supplier = new Supplier();
        supplier.setSupplierUsername(supplierDto.getSupplierUsername());
        supplier.setEmail(supplierDto.getEmail());
        supplier.setPhoneNumber(supplierDto.getPhoneNumber());
        Supplier save = supplierRepository.save(supplier);

        return new ApiResponse("saved with id: "+save.getSupplierUsername(), true);
    }


    public ApiResponse deleteSupplier(String id){

        Optional<Supplier> byId = supplierRepository.findById(id);
        if (byId.isEmpty()) {
            return new ApiResponse("no element with such id", false);
        }

        supplierRepository.deleteById(id);
        return new ApiResponse("deleted", true);

    }

}
