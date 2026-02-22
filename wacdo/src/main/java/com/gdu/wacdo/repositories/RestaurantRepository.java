package com.gdu.wacdo.repositories;

import com.gdu.wacdo.entities.Collaborateur;
import com.gdu.wacdo.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findAllByNameStartingWith(String word);
}
