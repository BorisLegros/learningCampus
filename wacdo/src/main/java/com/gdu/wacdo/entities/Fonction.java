package com.gdu.wacdo.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonManagedReference("poste-affectations")
    @OneToMany(mappedBy = "poste")
    private List<Affectation> affectations;
}
