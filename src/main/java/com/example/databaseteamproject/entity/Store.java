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
@Entity(name = "store")
public class Store{

    @Id
    private String storeUsername;

    private String storeAddress;

    private String storeNumber;

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Bucket> buckets;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "username")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    MainUser mainUser;

}
