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
public class Country {

    @Id
    private String countyName;

    private String countryIndex;


}
