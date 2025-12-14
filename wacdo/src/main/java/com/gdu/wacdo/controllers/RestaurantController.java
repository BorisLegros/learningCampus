package com.gdu.wacdo.controllers;

import com.gdu.wacdo.entities.Restaurant;
import com.gdu.wacdo.services.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/restaurant")
    public List<Restaurant> getAllRestaurant(){
        return restaurantService.getAll();
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant getRestaurant(@PathVariable Long id) {
        return restaurantService.getById(id);
    }

    @PostMapping("/restaurant")
    public Restaurant addRestaurant(@RequestBody Map<String, String> data){
        return restaurantService.save(data);
    }
}
