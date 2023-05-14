package com.example.databaseteamproject.entity;


import com.example.databaseteamproject.entity.template.IdClass;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "supplier")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Supplier{

    @Id
    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String address;

    private String phoneNumber;

    private String organizationNumber;


//    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Operation> operations;

//    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Product> productList;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    Product product;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "username")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    MainUser mainUser;

//    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    @MapsId
//    @JoinColumn(name = "username")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private MainUser mainUser;

}
