package com.example.databaseteamproject.entity;


import com.example.databaseteamproject.entity.template.IdClass;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MainUser{

    @Id
    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String address;

    private String phoneNumber;

}
