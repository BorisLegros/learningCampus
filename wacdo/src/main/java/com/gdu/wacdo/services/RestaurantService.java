package com.gdu.wacdo.services;

import com.gdu.wacdo.entities.Restaurant;
import com.gdu.wacdo.repositories.RestaurantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant save(Map<String, String> data) {
        log.info("nouveau Restaurant : {}", data);

        // recuperation
        String name = data.get("name");
        String address = data.get("address");
        String zipcode = data.get("zipcode");
        String city = data.get("city");

        // verification
        if (name == null || name.trim().isEmpty()) {
            // return error name
        }
        if (address == null || address.trim().isEmpty()) {
            // return error adress
        }
        if (zipcode == null || zipcode.trim().length() != 5) {
            //return error zipcode
        }
        if (city == null || city.trim().isEmpty()) {
            // return error city
        }

        Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        restaurant.setAddress(address);
        restaurant.setZipcode(Integer.parseInt(zipcode));
        restaurant.setCity(city);

        try {
            restaurant = restaurantRepository.save(restaurant);
            log.info("Restaurant enregistré :  {}", restaurant);
        } catch (Exception e) {
            log.info("sauvegarde impossible : {}", e);
            restaurant = null;
        }

        return restaurant;
    }

    public Restaurant getById(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }
}
