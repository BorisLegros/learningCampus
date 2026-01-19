package com.gdu.wacdo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @JsonBackReference("collaborateur-affectations")
    @ManyToOne
    @JoinColumn(name = "collaborateur_id")
    private Collaborateur collaborateur;

    @JsonBackReference("restaurant-affectations")
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @JsonBackReference("poste-affectations")
    @ManyToOne
    @JoinColumn(name = "poste_id")
    private Fonction poste;
    private Date dateDebut;
    private Date dateFin;
}
