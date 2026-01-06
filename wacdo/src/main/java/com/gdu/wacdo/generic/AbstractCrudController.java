package com.gdu.wacdo.generic;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public abstract class AbstractCrudController<T, ID, S extends AbstractCrudService<T, ID, ?>> {
    protected final S service;

    public AbstractCrudController(S service) {
        this.service = service;
    }

    @GetMapping
    public List<T> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public T get(@PathVariable ID id) { return service.getById(id); }

    @PostMapping
    public T add(@RequestBody Map<String, String> data) { return service.save(data); }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable ID id) { return service.deleteById(id); }
}
