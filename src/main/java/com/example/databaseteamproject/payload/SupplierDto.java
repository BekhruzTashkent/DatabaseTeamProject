package com.example.databaseteamproject.payload;

import jakarta.annotation.Nullable;
import lombok.Data;

import java.util.List;

@Data
public class SupplierDto {


    private String username;

    private String organizationNumber;

    private String password;

    private String firstName;

    private String lastName;

    private String address;

    private String phoneNumber;

    @Nullable
    private List<Integer> productId;



}
