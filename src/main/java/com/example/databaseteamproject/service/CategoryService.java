package com.example.databaseteamproject.service;


import com.example.databaseteamproject.entity.Category;
import com.example.databaseteamproject.entity.Producer;
import com.example.databaseteamproject.payload.ApiResponse;
import com.example.databaseteamproject.payload.CategoryDto;
import com.example.databaseteamproject.repository.CategoryRepository;
import com.example.databaseteamproject.repository.ProducerRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProducerRepository producerRepository;

    public List<Category> getAll(){
        return categoryRepository.findAll();

    }

    public Category getById(String id){
        Optional<Category> byId = categoryRepository.findById(id);
        return byId.orElse(null);
    }

    public ApiResponse addQA(@Valid CategoryDto categoryDto){

        Optional<Producer> byId = producerRepository.findById(categoryDto.getProducerId());
        if(byId.isEmpty()){
            return new ApiResponse("no such producer", false);
        }

        Category category = new Category();
        category.setSectionId(categoryDto.getSectionId());
        category.setName(categoryDto.getName());
        category.setProducer(byId.get());
        Category save = categoryRepository.save(category);

        return new ApiResponse("saved with id: "+save.getSectionId(), true);
    }


    public ApiResponse deleteQA(String id){

        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isEmpty()) {
            return new ApiResponse("no element with such id", false);
        }

        categoryRepository.deleteById(id);
        return new ApiResponse("deleted", true);

    }

}
