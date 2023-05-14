package com.example.databaseteamproject.payload;

import lombok.Data;

import java.security.Timestamp;

@Data
public class ShipmentDetailDto {

    private String certified;

    private String distance;

    private String time;

    private Integer agreementId;

}
