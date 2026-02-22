package com.gdu.wacdo.dto;

import com.gdu.wacdo.entities.Affectation;
import com.gdu.wacdo.generic.AbstractIndexDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@AllArgsConstructor
@Slf4j
public class AffectationDTO extends AbstractIndexDTO {
    public long id;
    public String collaborateur;
    public String restaurant;
    public String poste;
    public Date dateDebut;
    public Date dateFin;

    public AffectationDTO (Affectation origin) {
        String collab = origin.getCollaborateur().getLastname() + " " + origin.getCollaborateur().getFirstname();

        this.id = origin.getId();
        this.collaborateur = collab;
        this.restaurant = origin.getRestaurant().getName();
        this.poste = origin.getPoste().getLabel();
        this.dateDebut = origin.getDateDebut();
        this.dateFin = origin.getDateFin();
    }
}
