package com.gdu.wacdo.repositories;

import com.gdu.wacdo.entities.Affectation;
import com.gdu.wacdo.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AffectationRepository extends JpaRepository<Affectation, Long> {
    List<Affectation> findAllByRestaurantInAndDateFinIsNull(List<Restaurant> restaurants);
}
