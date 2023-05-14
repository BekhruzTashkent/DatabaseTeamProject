package com.example.databaseteamproject.payload;

import lombok.Data;

import java.util.List;

@Data
public class OperationDto {

    private String productName;

    private String storeUsername;

    private String supplierUsername;

    public OperationDto(Integer id, List<ProductDto> productDTOs) {

    }
}
