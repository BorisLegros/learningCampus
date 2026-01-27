package com.gdu.wacdo.dto;

import com.gdu.wacdo.entities.Collaborateur;
import com.gdu.wacdo.generic.AbstractIndexDTO;
import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class CollaborateurDTO extends AbstractIndexDTO {
    public Long id;
    public String firstname;
    public String lastname;
    public String email;
    public Date dateEmbauche;
    public Boolean isAdmin;
    public String password;

    public CollaborateurDTO (Collaborateur origin) {
        this.id = origin.getId();
        this.firstname = origin.getFirstname();
        this.lastname = origin.getLastname();
        this.email = origin.getEmail();
        this.dateEmbauche = origin.getDateEmbauche();
        this.isAdmin = origin.getIsAdmin();
        this.password = origin.getPassword();
    }
}
