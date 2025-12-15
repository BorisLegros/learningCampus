package com.gdu.wacdo.services;

import com.gdu.wacdo.models.AbstractCrudService;
import com.gdu.wacdo.entities.Collaborateur;
import com.gdu.wacdo.repositories.CollaborateurRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Service
@RequestMapping("/api/collaborateur")
public class CollaborateurService extends AbstractCrudService<Collaborateur, Long, CollaborateurRepository> {
    public CollaborateurService(CollaborateurRepository service) {
        super(service);
    }

    @Override
    protected Collaborateur saveData(Map<String, String> data) {
        return null;
    }
}
