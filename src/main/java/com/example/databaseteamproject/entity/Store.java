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
@Entity(name = "store")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Store{

    @Id
    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String storeAddress;

    private String storeNumber;

//    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Operation> operations;

//    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    @MapsId
//    @JoinColumn(name = "username")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    MainUser mainUser;

}
