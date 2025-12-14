package com.gdu.wacdo.controllers;

import com.gdu.wacdo.entities.Fonction;
import com.gdu.wacdo.services.FonctionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class FonctionController {
    private final FonctionService fonctionService;

    public FonctionController(FonctionService fonctionService) {
        this.fonctionService = fonctionService;
    }

    @GetMapping("/fonction")
    public List<Fonction> getAllFonction() {
        return fonctionService.getAll();
    }

    @GetMapping("/fonction/{id}")
    public Fonction getFonction(@PathVariable Long id) {
        return fonctionService.getById(id);
    }

    @PostMapping("/fonction")
    public Fonction addFonction(@RequestBody Map<String, String> data) {
        return fonctionService.save(data);
    }
}
