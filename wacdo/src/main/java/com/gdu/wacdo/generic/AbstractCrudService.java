package com.gdu.wacdo.generic;

import com.gdu.wacdo.dto.SelectOptionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public abstract class AbstractCrudService <T, ID, R extends JpaRepository<T, ID>> {
    protected final R repository;

    public AbstractCrudService(R repository) {
        this.repository = repository;
    }

    public T save(Map<String, String> data) {
        log.info("new entity : {}", data);
        T entity = saveData(data);
        try {
            entity = repository.save(entity);
            log.info("Entity saved : {}", entity);
        } catch (Exception e) {
            log.warn("Save failure : {}", e);
            entity = null;
        }

        return entity;
    }

    protected abstract T saveData(Map<String, String> data);

    public T getById(ID id) {
        return repository.findById(id).orElse(null);
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public boolean deleteById(ID id) {
        repository.deleteById(id);
        return !repository.existsById(id);
    }

    // use for HTML select options
    // return [{value: <id>, text: <String>}, ...]
    public List<SelectOptionDTO> getAllForSelect() {
        List<SelectOptionDTO> rtn = new ArrayList<>();

        for(T item : this.getAll()) {
            rtn.add(toSelectOptionDTO(item));
        }

        return rtn;
    }

    public abstract SelectOptionDTO toSelectOptionDTO(T item);
}
