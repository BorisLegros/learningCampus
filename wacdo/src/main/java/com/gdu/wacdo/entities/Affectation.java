package com.gdu.wacdo.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"collaborateur", "restaurant", "poste"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Affectation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonManagedReference("collaborateur-affectations")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "collaborateur_id")
    private Collaborateur collaborateur;

    @JsonManagedReference("restaurant-affectations")
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @JsonManagedReference("poste-affectations")
    @ManyToOne
    @JoinColumn(name = "poste_id")
    private Fonction poste;

    private Date dateDebut;
    private Date dateFin;
}
