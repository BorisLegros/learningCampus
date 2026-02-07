package com.gdu.wacdo.generic;

import com.gdu.wacdo.dto.SelectOptionDTO;
import jakarta.persistence.Entity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public abstract class AbstractCrudService <T, ID, R extends JpaRepository<T, ID>> {
    protected final R repository;
    protected final Class<T> entityClass;
    protected final String entityName;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AbstractCrudService(Class<T> entityClass, R repository) {
        this.repository = repository;
        this.entityClass = entityClass;
        this.entityName = getEntityName(entityClass);
    }

    private String getEntityName(Class<T> entityClass) {
        Entity entityAnnotation = entityClass.getAnnotation(Entity.class);

        if (entityAnnotation != null && !entityAnnotation.name().isEmpty()) {
            return entityAnnotation.name();
        }

        // Sinon utilise le nom de la classe en lowercase
        return entityClass.getSimpleName().toLowerCase();
    }

    public T save(Map<String, String> data) {
        log.info("new entity : {}", data);
        T entity = saveData(data);
        try {
            entity = repository.save(entity);
            log.info("Entity saved : {}", entity);
        } catch (Exception e) {
            log.warn("Save failure : " + e);
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

    public List<AbstractIndexDTO> getAllIndexDTO() {
        return this.listToIndexDTO(this.getAll());
    }

    public List<AbstractIndexDTO> listToIndexDTO (List<T> list) {
        List<AbstractIndexDTO> rtn = new ArrayList<>(list.size());

        for (T item : list) {
            rtn.add(this.toIndexDTO(item));
        }

        return rtn;
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

    public List<AbstractIndexDTO> getFiltered(Map<String, String> filters) {
        StringBuilder sql = new StringBuilder("SELECT * FROM " + this.entityName + " WHERE 1=1");
        List<Object> params = new ArrayList<>();

        filters.forEach((key, value) -> {
            if (value != null && !value.isEmpty()) {
                sql.append(" AND LOWER(").append(key).append(") LIKE LOWER(?)");
                params.add(value + "%");
            }
        });

        List<T> listFiltered = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(this.entityClass), params.toArray());
        return this.listToIndexDTO(listFiltered);
    }

    public abstract SelectOptionDTO toSelectOptionDTO(T item);
    public abstract AbstractIndexDTO toIndexDTO(T item);




//    public interface RestaurantsRepository extends JpaRepository<Restaurant, Long> {
//
//        @Query("""
//       SELECT r FROM Restaurant r
//       WHERE (:name IS NULL OR LOWER(r.name) LIKE LOWER(CONCAT('%', :name, '%')))
//         AND (:zipCode IS NULL OR r.zipCode LIKE CONCAT('%', :zipCode, '%'))
//         AND (:city IS NULL OR LOWER(r.city) LIKE LOWER(CONCAT('%', :city, '%')))
//   """)
//        List<Restaurant> searchRestaurants(@Param("name") String name, @Param("zipCode") String zipCode,
//                                           @Param("city") String city);
//
//    }

}
