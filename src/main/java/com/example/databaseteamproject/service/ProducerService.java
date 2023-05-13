package com.example.databaseteamproject.service;


import com.example.databaseteamproject.entity.Country;
import com.example.databaseteamproject.entity.Producer;
import com.example.databaseteamproject.payload.ProducerDto;
import com.example.databaseteamproject.repository.CountryRepository;
import com.example.databaseteamproject.repository.ProducerRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.example.databaseteamproject.payload.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProducerService {

    @Autowired
    ProducerRepository producerRepository;

    @Autowired
    CountryRepository countryRepository;

    public List<Producer> getAll(){
        return producerRepository.findAll();

    }

    public Producer getById(String id){
        Optional<Producer> byId = producerRepository.findById(id);
        return byId.orElse(null);
    }

    public ApiResponse addQA(@Valid ProducerDto producerDto){

        Optional<Country> byId = countryRepository.findById(producerDto.getCountryName());
        if(byId.isEmpty()){
            return new ApiResponse("no such Country", false);
        }

        Producer producer = new Producer();
        producer.setCompanyName(producerDto.getCompanyName());
        producer.setCompanyAddress(producerDto.getCompanyAddress());
        producer.setCountry(byId.get());
        Producer save = producerRepository.save(producer);

        return new ApiResponse("saved with id: "+save.getCountryName(), true);
    }


    public ApiResponse deleteQA(String companyName){

        Optional<Producer> byId = producerRepository.findById(companyName);
        if (byId.isEmpty()) {
            return new ApiResponse("no element with such id", false);
        }

        producerRepository.deleteById(companyName);
        return new ApiResponse("deleted", true);

    }

}
