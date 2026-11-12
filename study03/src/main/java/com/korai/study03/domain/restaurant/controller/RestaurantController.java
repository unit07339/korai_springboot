package com.korai.study03.domain.restaurant.controller;

import com.korai.study03.domain.restaurant.dto.RestaurantCreateRequest;
import com.korai.study03.domain.restaurant.dto.RestaurantResponse;
import com.korai.study03.domain.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public RestaurantResponse create(@RequestBody RestaurantCreateRequest request) {
        System.out.println(request);
        RestaurantResponse restaurantResponse = restaurantService.create(request);
        return restaurantResponse;
    }
}
