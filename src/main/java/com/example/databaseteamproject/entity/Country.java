package com.example.databaseteamproject.entity;

import com.example.databaseteamproject.entity.template.IdClass;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Country {

    @Id
    private String countyName;

    private String countryIndex;


}
