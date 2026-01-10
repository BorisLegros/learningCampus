package com.gdu.wacdo.controllers;

import com.gdu.wacdo.entities.Restaurant;
import com.gdu.wacdo.generic.AbstractCrudController;
import com.gdu.wacdo.services.RestaurantService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController extends AbstractCrudController<Restaurant, Long, RestaurantService> {
    public RestaurantController(RestaurantService service) { super(service); }
}
