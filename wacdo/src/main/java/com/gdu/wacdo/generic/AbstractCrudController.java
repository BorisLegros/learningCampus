package com.gdu.wacdo.generic;

import com.gdu.wacdo.dto.SelectOptionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
public abstract class AbstractCrudController<T, ID, S extends AbstractCrudService<T, ID, ?>> {
    protected final S service;

    public AbstractCrudController(S service) {
        this.service = service;
    }

    @GetMapping
    public List<AbstractIndexDTO> getAll() { return service.getAllIndexDTO(); }

    @GetMapping("/{id}")
    public T get(@PathVariable ID id) { return service.getById(id); }

    @PostMapping
    public T add(@RequestBody Map<String, String> data) { return service.save(data); }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable ID id) { return service.deleteById(id); }

    @GetMapping("/selectList")
    public List<SelectOptionDTO> getSelectList () { return service.getAllForSelect(); }

    @PostMapping("/filtered")
    public List<AbstractIndexDTO> getFiltered(@RequestBody Map<String, String> filter) {
        return service.getFiltered(filter);
    }
}
