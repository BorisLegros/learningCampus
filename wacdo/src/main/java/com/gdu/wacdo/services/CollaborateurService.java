package com.gdu.wacdo.services;

import com.gdu.wacdo.generic.AbstractCrudService;
import com.gdu.wacdo.entities.Collaborateur;
import com.gdu.wacdo.repositories.CollaborateurRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Service
@Slf4j
public class CollaborateurService extends AbstractCrudService<Collaborateur, Long, CollaborateurRepository> {
    public CollaborateurService(CollaborateurRepository service) {
        super(service);
    }

    @Override
    protected Collaborateur saveData(Map<String, String> data) {
        // recuperation
        String firstname = data.get("firstname");
        String lastname = data.get("lastname");
        String email = data.get("zipcode");
        Date embauch = new Date();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            embauch = dateFormat.parse(data.get("dateEmbauche"));
        } catch (Exception e) {
            log.error(e.toString());
        }
        boolean admin = Boolean.parseBoolean(data.get("isAdmin"));
        String pwd = data.get("password");

        // construction
        Collaborateur collaborateur = new Collaborateur();
        collaborateur.setFirstname(firstname);
        collaborateur.setLastname(lastname);
        collaborateur.setEmail(email);
        collaborateur.setDateEmbauche(embauch);
        collaborateur.setIsAdmin(admin);
        collaborateur.setPassword(pwd);

        return collaborateur;
    }
}
