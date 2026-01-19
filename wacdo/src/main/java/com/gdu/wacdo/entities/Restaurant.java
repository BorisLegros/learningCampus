package com.gdu.wacdo.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"affectations"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private int zipcode;
    private String city;

    @JsonManagedReference("restaurant-affectations")
    @OneToMany(mappedBy = "restaurant")
    private List<Affectation> affectations;
}
