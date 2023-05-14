package com.example.databaseteamproject.entity;


import com.example.databaseteamproject.entity.template.IdClass;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "producer")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Producer {

    @Id
    private String companyName;

    private String countryName;

    private String companyAddress;

    @ManyToOne
    Country country;

//    @OneToMany(mappedBy = "producer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Category> categoryList;


}
