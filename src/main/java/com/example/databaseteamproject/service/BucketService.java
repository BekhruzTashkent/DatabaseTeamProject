package com.example.databaseteamproject.service;


import com.example.databaseteamproject.entity.Bucket;
import com.example.databaseteamproject.entity.Product;
import com.example.databaseteamproject.entity.Store;
import com.example.databaseteamproject.entity.Supplier;
import com.example.databaseteamproject.payload.ApiResponse;
import com.example.databaseteamproject.payload.BucketDto;
import com.example.databaseteamproject.repository.BucketRepository;
import com.example.databaseteamproject.repository.ProductRepository;
import com.example.databaseteamproject.repository.StoreRepository;
import com.example.databaseteamproject.repository.SupplierRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BucketService {

    @Autowired
    BucketRepository bucketRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    StoreRepository storeRepository;

    public List<Bucket> getAll(){
        return bucketRepository.findAll();

    }

    public Bucket getById(Integer id){
        Optional<Bucket> byId = bucketRepository.findById(id);
        return byId.orElse(null);
    }

    public ApiResponse addQA(@Valid BucketDto bucketDto){

        Optional<Product> byId = productRepository.findById(bucketDto.getProductId());
        if(byId.isEmpty()){
            return new ApiResponse("no such product", false);
        }

        Optional<Supplier> byId1 = supplierRepository.findById(bucketDto.getSupplierUsername());
        if(byId1.isEmpty()){
            return new ApiResponse("no such supplier", false);
        }

        Optional<Store> byId2 = storeRepository.findById(bucketDto.getStoreUsername());
        if(byId2.isEmpty()){
            return new ApiResponse("no such store", false);
        }

        Bucket bucket = new Bucket();
        bucket.setProduct(byId.get());
        bucket.setSupplier(byId1.get());
        bucket.setStore(byId2.get());
        Bucket save = bucketRepository.save(bucket);

        return new ApiResponse("saved with id: "+save.getId(), true);
    }

    public ApiResponse deleteQA(Integer id){

        Optional<Bucket> byId = bucketRepository.findById(id);
        if (byId.isEmpty()) {
            return new ApiResponse("no element with such id", false);
        }

        bucketRepository.deleteById(id);
        return new ApiResponse("deleted", true);

    }

}
