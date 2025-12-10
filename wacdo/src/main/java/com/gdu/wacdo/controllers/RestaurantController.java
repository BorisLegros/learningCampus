package com.gdu.wacdo.controllers;

import com.gdu.wacdo.models.Restaurant;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RestaurantController {

    @GetMapping("/restaurant")
    public List<Restaurant> getRestaurant(){
        Restaurant r1 = new Restaurant(1L, "ENTREE", "36 rue de la faim", 31313, "Fritte-sur-Mer");
        Restaurant r2 = new Restaurant(2L, "PLAT", "36 rue de la faim", 31313, "Fritte-sur-Mer");
        Restaurant r3 = new Restaurant(3L, "FROMMAGE", "36 rue de la faim", 31313, "Fritte-sur-Mer");
        Restaurant r4 = new Restaurant(4L, "DESSERT", "36 rue de la faim", 31313, "Fritte-sur-Mer");

        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(r1);
        restaurants.add(r2);
        restaurants.add(r3);
        restaurants.add(r4);

        return restaurants;
    }

    @PostMapping("/restaurant")
    public Restaurant addRestaurant(@RequestBody Map<String, String> data){
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

        // TODO : save restaurant ???
        return restaurant;
    }
}
