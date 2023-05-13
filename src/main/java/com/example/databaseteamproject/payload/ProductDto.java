package com.example.databaseteamproject.payload;

import lombok.Data;

@Data
public class ProductDto {

    private String productName;

    private Integer price;

    private Integer amount;

    private String sectionId;

}
