package com.simple.api.foods.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.api.foods.entities.Food;
import com.simple.api.foods.services.FoodService;

@RestController
@RequestMapping(value = "/foods")
public class FoodResource {
	
	@Autowired
	private FoodService foodService;
	
	@GetMapping
	public ResponseEntity<List<Food>> findAll(){
		List<Food> list = foodService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Food> findById(@PathVariable Integer id){
		Food obj = foodService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
