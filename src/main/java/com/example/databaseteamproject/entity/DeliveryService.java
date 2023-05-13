package com.example.databaseteamproject.entity;


import com.example.databaseteamproject.entity.template.IdClass;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DeliveryService{

    @Id
    private String deliveryName;

    private String price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "certified")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    ShipmentDetail shipmentDetail;

}
