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
@Entity(name = "product")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private Integer price;

    private Integer amount;

//    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Bucket> buckets;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "section_id")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    Category category;


//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "operation_id")
//    private Operation operation;

    @ManyToOne
    private Operation operation;

    @ManyToOne
    Category category;

    @ManyToOne
    private Supplier supplier;

}
