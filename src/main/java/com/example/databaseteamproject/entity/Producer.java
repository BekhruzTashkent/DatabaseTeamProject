package com.example.databaseteamproject.entity;


import com.example.databaseteamproject.entity.template.IdClass;
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
@Entity(name = "producer")
public class Producer {

    @Id
    private String companyName;

    private String countryName;

    private String companyAddress;

    @ManyToOne
    Country country;

    @ManyToMany
    @JoinTable(
            name = "produces",
            joinColumns = @JoinColumn(name = "company_name"),
            inverseJoinColumns = @JoinColumn(name = "section_id"))
    private Set<Category> category = new HashSet<>();


}
