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

//        Optional<MainUser> byUsername = mainUserRepository.findByUsername(storeDto.getUsername());
//        if(byUsername.isPresent()){
//            return new ApiResponse("username already exist", false);
//        }

//        MainUser mainUser = new MainUser();
//        mainUser.setUsername(storeDto.getUsername());
//        mainUser.setPassword(storeDto.getPassword());
//        mainUser.setFirstName(storeDto.getFirstName());
//        mainUser.setLastName(storeDto.getLastName());
//        mainUser.setAddress(storeDto.getAddress());
//        mainUser.setPhoneNumber(storeDto.getPhoneNumber());
//        MainUser save1 = mainUserRepository.save(mainUser);

        Store store = new Store();
        store.setUsername(storeDto.getUsername());
        store.setPassword(storeDto.getPassword());
        store.setFirstName(storeDto.getFirstName());
        store.setLastName(storeDto.getLastName());
        store.setStoreAddress(storeDto.getAddress());
        store.setStoreNumber(storeDto.getOrganizationNumber());
        store.setPhoneNumber(storeDto.getPhoneNumber());
        Store save = qaRepository.save(store);

        return new ApiResponse("saved with id: "+save.getUsername(), true);
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
