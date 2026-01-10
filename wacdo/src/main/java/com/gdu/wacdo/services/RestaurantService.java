package com.gdu.wacdo.services;

import com.gdu.wacdo.dto.SelectOptionDTO;
import com.gdu.wacdo.entities.Restaurant;
import com.gdu.wacdo.generic.AbstractCrudService;
import com.gdu.wacdo.repositories.RestaurantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class RestaurantService extends AbstractCrudService<Restaurant, Long, RestaurantRepository> {
    public RestaurantService(RestaurantRepository repository) { super(repository); }

    @Override
    public Restaurant saveData(Map<String, String> data) {
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

        return restaurant;
    }

    @Override
    public SelectOptionDTO toSelectOptionDTO(Restaurant item) {
        return new SelectOptionDTO(item.getId(), item.getName());
    }
}
