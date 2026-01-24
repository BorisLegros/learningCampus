package com.gdu.wacdo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"affectations"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Fonction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;

    @JsonBackReference("poste-affectations")
    @OneToMany(mappedBy = "poste")
    private List<Affectation> affectations;
}
