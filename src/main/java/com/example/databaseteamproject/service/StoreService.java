package com.example.databaseteamproject.service;


import com.example.databaseteamproject.entity.Store;
import com.example.databaseteamproject.payload.ApiResponse;
import com.example.databaseteamproject.payload.StoreDto;
import com.example.databaseteamproject.repository.StoreRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreService {

    @Autowired
    StoreRepository qaRepository;

    public List<Store> getAll(){
        return qaRepository.findAll();

    }

    public Store getById(String id){
        Optional<Store> byId = qaRepository.findById(id);
        return byId.orElse(null);
    }

    public ApiResponse addStore(@Valid StoreDto storeDto){



        Store qa = new Store();
        qa.setStoreUsername(storeDto.getStoreUsername());
        qa.setStoreAddress(storeDto.getStoreAddress());
        qa.setStoreNumber(storeDto.getStoreNumber());
        Store save = qaRepository.save(qa);

        return new ApiResponse("saved with id: "+save.getStoreUsername(), true);
    }


    public ApiResponse deleteStore(String id){

        Optional<Store> byId = qaRepository.findById(id);
        if (byId.isEmpty()) {
            return new ApiResponse("no element with such id", false);
        }

        qaRepository.deleteById(id);
        return new ApiResponse("deleted", true);

    }

}
