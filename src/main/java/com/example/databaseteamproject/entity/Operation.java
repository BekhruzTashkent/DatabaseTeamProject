package com.example.databaseteamproject.entity;


import com.example.databaseteamproject.entity.template.IdClass;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "operation")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Operation extends IdClass {

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "product_id")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private Product product;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "supplier_username")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private Supplier supplier;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "store_username")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private Store store;

//    @ManyToOne
//    private Product product;

//    @OneToMany(mappedBy = "operation", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Product> products = new ArrayList<>();

    @ManyToOne
    private Product product;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private Store store;
}