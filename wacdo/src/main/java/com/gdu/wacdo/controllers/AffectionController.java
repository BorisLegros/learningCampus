package com.gdu.wacdo.controllers;

import com.gdu.wacdo.entities.Affectation;
import com.gdu.wacdo.generic.AbstractCrudController;
import com.gdu.wacdo.generic.AbstractIndexDTO;
import com.gdu.wacdo.services.AffectationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/affectation")
public class AffectionController extends AbstractCrudController<Affectation, Long, AffectationService> {
    public AffectionController(AffectationService service) {
        super(service);
    }

//    @GetMapping
//    // TODO faire des dto generals
//    public List<AbstractIndexDTO> getAllDTO() { return service.getAllIndexDTO(); }
}
