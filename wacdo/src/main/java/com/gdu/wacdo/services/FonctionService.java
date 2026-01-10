package com.gdu.wacdo.services;

import com.gdu.wacdo.dto.SelectOptionDTO;
import com.gdu.wacdo.entities.Fonction;
import com.gdu.wacdo.generic.AbstractCrudService;
import com.gdu.wacdo.repositories.FonctionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class FonctionService extends AbstractCrudService<Fonction, Long, FonctionRepository> {

    public FonctionService(FonctionRepository repository) {
        super(repository);
    }

    @Override
    protected Fonction saveData(Map<String, String> data) {
        log.info("nouvelle Fonction : {}", data);

        // recuperation
        String label = data.get("label");

        // verification
        if (label == null || label.trim().isEmpty()) {
            // return label error
        }

        // construction
        Fonction fonction = new Fonction();
        fonction.setLabel(label);

        return fonction;
    }

    @Override
    public SelectOptionDTO toSelectOptionDTO(Fonction item) {
        return new SelectOptionDTO(item.getId(), item.getLabel());
    }
}
