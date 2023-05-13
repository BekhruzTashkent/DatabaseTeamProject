package com.example.databaseteamproject.service;


import com.example.databaseteamproject.entity.Country;
import com.example.databaseteamproject.payload.ApiResponse;
import com.example.databaseteamproject.payload.CountryDto;
import com.example.databaseteamproject.repository.CountryRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService {

    @Autowired
    CountryRepository countryRepository;

    public List<Country> getAll(){
        return countryRepository.findAll();

    }

    public Country getById(String id){
        Optional<Country> byId = countryRepository.findById(id);
        return byId.orElse(null);
    }

    public ApiResponse addQA(@Valid CountryDto countryDto){
        Country country = new Country();
        country.setCountyName(countryDto.getCountryName());
        country.setCountryIndex(countryDto.getCountryIndex());
        Country save = countryRepository.save(country);

        return new ApiResponse("saved with id: "+save.getCountyName(), true);
    }


    public ApiResponse deleteQA(String id){

        Optional<Country> byId = countryRepository.findById(id);
        if (byId.isEmpty()) {
            return new ApiResponse("no element with such id", false);
        }

        countryRepository.deleteById(id);
        return new ApiResponse("deleted", true);

    }

}
