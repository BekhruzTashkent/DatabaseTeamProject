package com.example.databaseteamproject.service;


import com.example.databaseteamproject.entity.Product;
import com.example.databaseteamproject.entity.Supplier;
import com.example.databaseteamproject.payload.ApiResponse;
import com.example.databaseteamproject.payload.SupplierDto;
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


    public List<Supplier> getAll(){
        return supplierRepository.findAll();

    }

    public Supplier getById(String id){
        Optional<Supplier> byId = supplierRepository.findById(id);

        return byId.orElse(null);
    }

    public ApiResponse addSupplier(@Valid SupplierDto supplierDto){

//        Optional<MainUser> byId = mainUserRepository.findById(supplierDto.getUsername());
//        if(byId.isEmpty()){
//            return new ApiResponse("no such account", false);
//        }

//        Optional<Product> byId1 = productRepository.findById(supplierDto.getProductId());
//        if(byId1.isEmpty()){
//            return new ApiResponse("no such product id", false);
//        }


        Supplier supplier = new Supplier();
        supplier.setUsername(supplierDto.getUsername());
        supplier.setAddress(supplierDto.getAddress());
        supplier.setFirstName(supplierDto.getFirstName());
        supplier.setLastName(supplierDto.getLastName());
        supplier.setOrganizationNumber(supplierDto.getOrganizationNumber());
        supplier.setPhoneNumber(supplierDto.getPhoneNumber());

        Supplier save = supplierRepository.save(supplier);

        return new ApiResponse("saved with id: "+save.getUsername(), true);
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
