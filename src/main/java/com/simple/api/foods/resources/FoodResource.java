package com.simple.api.foods.resources;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.api.foods.entities.Food;
import com.simple.api.foods.repositories.FoodRepository;
import com.simple.api.foods.services.FoodService;

@RestController
@RequestMapping(value = "/food")
public class FoodResource {
	
	@Autowired
	private FoodService foodService;

	@GetMapping("")
	public HashMap<String, Object> get() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("Msg", "API Food");
		return map;
	}
	
	@GetMapping("/allFoods")
	public ResponseEntity<List<Food>> findAll(){
		List<Food> list = foodService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "findById/{id}")
	public ResponseEntity<Food> findById(@PathVariable Integer id){
		Food obj = foodService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "findByName/{name}")
	public ResponseEntity<Food> findByName(@PathVariable String name){
		Food obj = foodService.findByName(name);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping("/addFood")
	public ResponseEntity<Food> addFood(@RequestBody Food food) {
		Food obj = foodService.saveFood(food);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping("/addFoods")
	public ResponseEntity<List<Food>> addFoods(@RequestBody List<Food> listFood){
		List<Food> obj = foodService.saveFoods(listFood);
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping("/updateFood")
	public ResponseEntity<Food> updateFood(@RequestBody Food food) {
		Food obj = foodService.updateFood(food);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping("/delteFood/{id}")
	public ResponseEntity<String> deleteFood(@PathVariable Integer id) {
		String obj = foodService.deleteFoodById(id);
		return ResponseEntity.ok().body(obj);
	}
}
