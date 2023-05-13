package com.example.databaseteamproject.entity;


import com.example.databaseteamproject.entity.template.IdClass;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product")
public class Product extends IdClass {

    private String productName;

    private Integer price;

    private Integer amount;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Bucket> buckets;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "section_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Category category;



}
