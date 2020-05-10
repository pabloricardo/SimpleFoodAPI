package com.simple.api.foods.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.api.foods.entities.Food;

@RestController
@RequestMapping(value = "/foods")
public class FoodResource {

}
