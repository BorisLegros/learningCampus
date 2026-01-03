package com.gdu.wacdo.services;

import com.gdu.wacdo.entities.Fonction;
import com.gdu.wacdo.generic.AbstractCrudService;
import com.gdu.wacdo.repositories.FonctionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class FonctionService extends AbstractCrudService<Fonction, Long, FonctionRepository> {

    public FonctionService(FonctionRepository fonctionRepository) {
        super(fonctionRepository);
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
}
