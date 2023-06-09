package com.example.databaseteamproject.payload;

import lombok.Data;

import java.security.Timestamp;

@Data
public class ShipmentDto {

    private String approved;

    private String date;

    private String shipmentType;

    private String storeUsername;

    private String supplierUsername;

}
