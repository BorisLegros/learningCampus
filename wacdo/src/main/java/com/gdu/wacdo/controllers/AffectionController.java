package com.gdu.wacdo.controllers;

import com.gdu.wacdo.entities.Affectation;
import com.gdu.wacdo.generic.AbstractCrudController;
import com.gdu.wacdo.services.AffectationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/affectation")
public class AffectionController extends AbstractCrudController<Affectation, Long, AffectationService> {
    public AffectionController(AffectationService service) {
        super(service);
    }
}
