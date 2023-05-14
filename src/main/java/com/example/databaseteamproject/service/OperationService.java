package com.example.databaseteamproject.service;


import com.example.databaseteamproject.entity.Operation;
import com.example.databaseteamproject.entity.Product;
import com.example.databaseteamproject.entity.Store;
import com.example.databaseteamproject.entity.Supplier;
import com.example.databaseteamproject.payload.ApiResponse;
import com.example.databaseteamproject.payload.OperationDto;
import com.example.databaseteamproject.payload.ProductDto;
import com.example.databaseteamproject.repository.BucketRepository;
import com.example.databaseteamproject.repository.ProductRepository;
import com.example.databaseteamproject.repository.StoreRepository;
import com.example.databaseteamproject.repository.SupplierRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OperationService {

    @Autowired
    BucketRepository bucketRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    StoreRepository storeRepository;

    public List<Operation> getAll(){
        return bucketRepository.findAll();

    }

    public Operation getById(Integer id){
        Optional<Operation> byId = bucketRepository.findById(id);
        return byId.orElse(null);
    }

    public ApiResponse addQA(@Valid OperationDto bucketDto){

        Optional<Product> byId = productRepository.findByProductName(bucketDto.getProductName());
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

        Operation bucket = new Operation();
        bucket.setProduct(byId.get());
        bucket.setSupplier(byId1.get());
        bucket.setStore(byId2.get());
        Operation save = bucketRepository.save(bucket);

        return new ApiResponse("saved with id: "+save.getId(), true);
    }


//    public ApiResponse addQA(@Valid OperationDto operationDto) {
//
//        Optional<Product> byId = productRepository.findById(operationDto.getProductId());
//        if (byId.isEmpty()) {
//            return new ApiResponse("no such products", false);
//        }
//
//        Optional<Supplier> byId1 = supplierRepository.findById(operationDto.getSupplierUsername());
//        if (byId1.isEmpty()) {
//            return new ApiResponse("no such supplier", false);
//        }
//
//        Optional<Store> byId2 = storeRepository.findById(operationDto.getStoreUsername());
//        if (byId2.isEmpty()) {
//            return new ApiResponse("no such store", false);
//        }
//
//        Operation operation = new Operation();
//        operation.setSupplier(byId1.get());
//        operation.setStore(byId2.get());
//
//        List<Product> products = new ArrayList<>();
//        products.add(byId.get());
//        operation.setProducts(products);
//
//        Operation save = bucketRepository.save(operation);
//
//        return new ApiResponse("saved with id: " + save.getId(), true);
//    }
//
//
//}

//    public OperationDto addQa(OperationDto operationDTO) {
//
//        Optional<Supplier> byId1 = supplierRepository.findById(operationDTO.getSupplierUsername());
//        if (byId1.isEmpty()) {
//            return null;
//        }
//
//        Optional<Store> byId2 = storeRepository.findById(operationDTO.getStoreUsername());
//        if (byId2.isEmpty()) {
//            return null;
//        }
//        Operation operation = new Operation();
//        operation.setSupplier(byId1.get());
//        operation.setStore(byId2.get());
//
//        List<Product> products = new ArrayList<>();
//
//        for (Long productId : operationDTO.getProductId()) {
//            Product product = productRepository.findById(productId).orElseThrow(() ->
//                    new EntityNotFoundException("Product with id " + productId + " not found"));
//
//            product.setOperation(operation);
//            products.add(product);
//        }
//
//        operation.setProducts(products);
//
//        operation = bucketRepository.save(operation);
//
//        List<ProductDto> productDTOs = products.stream()
//                .map(product -> new ProductDto( product.getProductName(), product.getPrice(), product.getAmount()))
//                .collect(Collectors.toList());
//
//        return new OperationDto(operation.getId(),  productDTOs);
//    }



//    public OperationDto addQa(OperationDto operationDTO) {
//        Optional<Supplier> supplierOpt = supplierRepository.findById(operationDTO.getSupplierUsername());
//        if (supplierOpt.isEmpty()) {
//            throw new EntityNotFoundException("Supplier with username " + operationDTO.getSupplierUsername() + " not found");
//        }
//
//        Optional<Store> storeOpt = storeRepository.findById(operationDTO.getStoreUsername());
//        if (storeOpt.isEmpty()) {
//            throw new EntityNotFoundException("Store with username " + operationDTO.getStoreUsername() + " not found");
//        }
//
//        Operation operation = new Operation();
//        operation.setSupplier(supplierOpt.get());
//        operation.setStore(storeOpt.get());
//
//        List<Product> products = new ArrayList<>();
//
//        for (Long productId : operationDTO.getProductId()) {
//            Product product = productRepository.findById(productId)
//                    .orElseThrow(() -> new EntityNotFoundException("Product with id " + productId + " not found"));
//
//            product.setOperation(operation);
//            products.add(product);
//        }
//
//        operation.setProducts(products);
//
//        operation = bucketRepository.save(operation);
//
//        List<ProductDto> productDTOs = products.stream()
//                .map(product -> new ProductDto(product.getProductName(), product.getPrice(), product.getAmount()))
//                .collect(Collectors.toList());
//
//        return new OperationDto(operation.getId(), productDTOs);
//    }



//    public OperationDto add(OperationDto operationDto) {
//        // Look up the supplier
//        Optional<Supplier> supplierOptional = supplierRepository.findById(operationDto.getSupplierUsername());
//        if (supplierOptional.isEmpty()) {
//            throw new EntityNotFoundException("Supplier with username " + operationDto.getSupplierUsername() + " not found");
//        }
//        Supplier supplier = supplierOptional.get();
//
//        // Look up the store
//        Optional<Store> storeOptional = storeRepository.findById(operationDto.getStoreUsername());
//        if (storeOptional.isEmpty()) {
//            throw new EntityNotFoundException("Store with username " + operationDto.getStoreUsername() + " not found");
//        }
//        Store store = storeOptional.get();
//
//        // Create the new operation entity
//        Operation operation = new Operation();
//        operation.setSupplier(supplier);
//        operation.setStore(store);
//
//        List<Product> products = new ArrayList<>();
//        List<ProductDto> productDtos = new ArrayList<>();
//
//        // Look up and add each product to the operation
//        for (Long productId : operationDto.getProductId()) {
//            Optional<Product> productOptional = productRepository.findById(productId);
//            if (productOptional.isEmpty()) {
//                throw new EntityNotFoundException("Product with ID " + productId + " not found");
//            }
//            Product product = productOptional.get();
//            product.setOperation(operation);
//            products.add(product);
//            productDtos.add(new ProductDto(product.getProductName(), product.getPrice(), product.getAmount()));
//        }
//
//        // Set the products on the operation
//        operation.setProducts(products);
//
//        // Save the new operation entity to the database
//        operation = bucketRepository.save(operation);
//
//        // Return the new operation DTO
//        return new OperationDto(operation.getId(), productDtos);
//    }

    public ApiResponse deleteQA(Integer id){

        Optional<Operation> byId = bucketRepository.findById(id);
        if (byId.isEmpty()) {
            return new ApiResponse("no element with such id", false);
        }

        bucketRepository.deleteById(id);
        return new ApiResponse("deleted", true);

    }

}
