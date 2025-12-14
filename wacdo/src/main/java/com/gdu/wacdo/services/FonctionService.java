package com.gdu.wacdo.services;

import com.gdu.wacdo.entities.Fonction;
import com.gdu.wacdo.repositories.FonctionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class FonctionService {
    private final FonctionRepository fonctionRepository;

    public FonctionService(FonctionRepository fonctionRepository) {
        this.fonctionRepository = fonctionRepository;
    }

    public Fonction save(Map<String, String> data) {
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

        // enregistrement
        try {
            fonction = fonctionRepository.save(fonction);
            log.info("Nouvelle Fonction sauvegardée : {}", fonction);
        } catch (Exception e) {
            log.error("Sauvegarde impossible : {}", e);
            fonction = null;
        }

        return fonction;
    }

    public Fonction getById(Long id) {
        return fonctionRepository.findById(id).orElse(null);
    }

    public List<Fonction> getAll() {
        return fonctionRepository.findAll();
    }
}
