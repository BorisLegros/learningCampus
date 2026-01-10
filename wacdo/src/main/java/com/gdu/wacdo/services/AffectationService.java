package com.gdu.wacdo.services;

import com.gdu.wacdo.dto.SelectOptionDTO;
import com.gdu.wacdo.entities.Affectation;
import com.gdu.wacdo.generic.AbstractCrudService;
import com.gdu.wacdo.repositories.AffectationRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AffectationService extends AbstractCrudService<Affectation, Long, AffectationRepository> {
    public AffectationService(AffectationRepository repository) {
        super(repository);
    }
    @Override
    protected Affectation saveData(Map<String, String> data) {
        return null;
    }

    @Override
    public SelectOptionDTO toSelectOptionDTO(Affectation item) {
        return new SelectOptionDTO(item.getId(), item.getPoste().getLabel());
    }
}
