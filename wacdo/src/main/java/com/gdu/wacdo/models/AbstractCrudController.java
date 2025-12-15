package com.gdu.wacdo.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
}
