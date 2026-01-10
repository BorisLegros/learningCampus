package com.gdu.wacdo.services;

import com.gdu.wacdo.dto.SelectOptionDTO;
import com.gdu.wacdo.entities.Affectation;
import com.gdu.wacdo.generic.AbstractCrudService;
import com.gdu.wacdo.repositories.AffectationRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class AffectationService extends AbstractCrudService<Affectation, Long, AffectationRepository> {
    private final CollaborateurService collaborateurService;
    private final FonctionService fonctionService;
    private final RestaurantService restaurantService;

    public AffectationService(AffectationRepository repository,
                              CollaborateurService collaborateurService,
                              FonctionService fonctionService,
                              RestaurantService restaurantService) {
        super(repository);
        this.collaborateurService = collaborateurService;
        this.fonctionService = fonctionService;
        this.restaurantService = restaurantService;
    }

    @Override
    protected Affectation saveData(Map<String, String> data) {
        // recuepration
        String collabId = data.get("collaborateur");
        String restoId = data.get("restaurant");
        String fonctionId = data.get("poste");

        // verification ?

        // construction
        Affectation affectation = new Affectation();
        affectation.setCollaborateur(collaborateurService.getById(Long.parseLong(collabId)));
        affectation.setRestaurant(restaurantService.getById(Long.parseLong(restoId)));
        affectation.setPoste(fonctionService.getById(Long.parseLong(fonctionId)));
        affectation.setDateDebut(new Date());

        return affectation;
    }

    @Override
    public SelectOptionDTO toSelectOptionDTO(Affectation item) {
        return new SelectOptionDTO(item.getId(), item.getPoste().getLabel());
    }
}
