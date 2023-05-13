package com.example.databaseteamproject.entity;


import com.example.databaseteamproject.entity.template.IdClass;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "category")
public class Category {

    @Id
    private String sectionId;

    private String name;


    @ManyToMany(mappedBy = "category")
    private Set<Producer> producerSet = new HashSet<>();


}
