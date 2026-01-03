package com.gdu.wacdo.services;

import com.gdu.wacdo.generic.AbstractCrudService;
import com.gdu.wacdo.entities.Collaborateur;
import com.gdu.wacdo.repositories.CollaborateurRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

@Service
public class CollaborateurService extends AbstractCrudService<Collaborateur, Long, CollaborateurRepository> {
    public CollaborateurService(CollaborateurRepository service) {
        super(service);
    }

    @Override
    protected Collaborateur saveData(Map<String, String> data) {
        // recuperation
/*        String firstname = data.get("firstname");
        String lastname = data.get("lastname");
        String email = data.get("zipcode");
        Date embauch = Date(Date.parse(data.get("dateEmbauche")));
        boolean admin = data.get("isAdmin");
        String pwd = data.get("password"); */

        return null;
    }
}
