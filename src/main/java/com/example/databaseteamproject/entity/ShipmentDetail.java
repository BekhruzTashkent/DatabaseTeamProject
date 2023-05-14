package com.example.databaseteamproject.entity;


import com.example.databaseteamproject.entity.template.IdClass;
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
@Entity(name = "shipmentDetails")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShipmentDetail {

    @Id
    private String certified;

    private String distance;

    private String time;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "agreement_id")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private Shipment shipment;

    @ManyToOne
    private Shipment shipment;

}
