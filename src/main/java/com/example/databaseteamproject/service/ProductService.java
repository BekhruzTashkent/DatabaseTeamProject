package com.example.databaseteamproject.service;


import com.example.databaseteamproject.entity.Category;
import com.example.databaseteamproject.entity.Product;
import com.example.databaseteamproject.payload.ApiResponse;
import com.example.databaseteamproject.payload.ProductDto;
import com.example.databaseteamproject.repository.CategoryRepository;
import com.example.databaseteamproject.repository.ProducerRepository;
import com.example.databaseteamproject.repository.ProductRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public List<Product> getAll(){
        return productRepository.findAll();

    }

    public Product getById(Integer id){
        Optional<Product> byId = productRepository.findById(id);
        return byId.orElse(null);
    }

    public ApiResponse addQA(@Valid ProductDto productDto){

        Optional<Category> byId = categoryRepository.findById(productDto.getSectionId());
        if(byId.isEmpty()){
            return new ApiResponse("no such category", false);
        }

        Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        product.setAmount(productDto.getAmount());
        product.setCategory(byId.get());
        Product save = productRepository.save(product);

        return new ApiResponse("saved with id: "+save.getId(), true);
    }

    public ApiResponse deleteQA(Integer id){

        Optional<Product> byId = productRepository.findById(id);
        if (byId.isEmpty()) {
            return new ApiResponse("no element with such id", false);
        }

        productRepository.deleteById(id);
        return new ApiResponse("deleted", true);

    }

}
