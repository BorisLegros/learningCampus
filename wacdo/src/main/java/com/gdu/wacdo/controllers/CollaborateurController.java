package com.gdu.wacdo.controllers;

import com.gdu.wacdo.entities.Collaborateur;
import com.gdu.wacdo.models.AbstractCrudController;
import com.gdu.wacdo.services.CollaborateurService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@RequestMapping("api/collaborateur")
public class CollaborateurController extends AbstractCrudController<Collaborateur, Long, CollaborateurService> {
    public CollaborateurController(CollaborateurService service) {
        super(service);
    }
}
