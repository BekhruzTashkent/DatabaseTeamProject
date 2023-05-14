package com.example.databaseteamproject.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "shipment")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer agreementId;

    private String approved;

    private String date;

    private boolean certified = true;

    private String shipmentType;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private Store store;
}
