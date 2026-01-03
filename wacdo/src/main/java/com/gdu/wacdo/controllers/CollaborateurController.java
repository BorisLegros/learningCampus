package com.gdu.wacdo.controllers;

import com.gdu.wacdo.entities.Collaborateur;
import com.gdu.wacdo.generic.AbstractCrudController;
import com.gdu.wacdo.services.CollaborateurService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/collaborateur")
public class CollaborateurController extends AbstractCrudController<Collaborateur, Long, CollaborateurService> {
    public CollaborateurController(CollaborateurService service) {
        super(service);
    }
}
