package com.gdu.wacdo.controllers;

import com.gdu.wacdo.entities.Fonction;
import com.gdu.wacdo.generic.AbstractCrudController;
import com.gdu.wacdo.services.FonctionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/fonction")
public class FonctionController extends AbstractCrudController<Fonction, Long, FonctionService> {
    public FonctionController(FonctionService fonctionService) {
        super(fonctionService);
    }

}
