package com.gdu.wacdo.services;

import com.gdu.wacdo.entities.Affectation;
import com.gdu.wacdo.generic.AbstractCrudService;
import com.gdu.wacdo.repositories.AffectationRepository;
import com.gdu.wacdo.repositories.CollaborateurRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AffectationService extends AbstractCrudService<Affectation, Long, AffectationRepository> {
    public AffectationService(AffectationRepository service) {
        super(service);
    }
    @Override
    protected Affectation saveData(Map<String, String> data) {
        return null;
    }
}
