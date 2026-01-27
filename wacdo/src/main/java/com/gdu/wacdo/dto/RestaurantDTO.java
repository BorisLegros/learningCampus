package com.gdu.wacdo.dto;

import com.gdu.wacdo.entities.Restaurant;
import com.gdu.wacdo.generic.AbstractIndexDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RestaurantDTO extends AbstractIndexDTO {
    public Long id;
    public String name;
    public String adress;
    public int zipcode;
    public String city;

    public RestaurantDTO (Restaurant origin) {
        this.id = origin.getId();
        this.name = origin.getName();
        this.adress = origin.getAddress();
        this.zipcode = origin.getZipcode();
        this.city = origin.getCity();
    }
}
