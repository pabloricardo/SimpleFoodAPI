package com.simple.api.foods.resources;

import java.util.HashMap;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.simple.api.foods.entities.Food;
import com.simple.api.foods.repositories.FoodRepository;
import com.simple.api.foods.services.FoodService;

@RestController
@RequestMapping(value = "/food")
@Api(value = "API REST Foods")
@CrossOrigin(origins = "*")
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
	@ApiOperation(value = "Return list foods")
	public ResponseEntity<List<Food>> findAll(){
		List<Food> list = foodService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "findById/{id}")
	@ApiOperation(value = "Return the food as the id passed")
	public ResponseEntity<Food> findById(@PathVariable Integer id){
		Food obj = foodService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "findByName/{name}")
	@ApiOperation(value = "Return the food as the name passed")
	public ResponseEntity<Food> findByName(@PathVariable String name){
		Food obj = foodService.findByName(name);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping("/addFood")
	@ApiOperation(value = "Add food")
	public ResponseEntity<Food> addFood(@RequestBody Food food) {
		Food obj = foodService.saveFood(food);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping("/addFoods")
	@ApiOperation(value = "Add list of food")
	public ResponseEntity<List<Food>> addFoods(@RequestBody List<Food> listFood){
		List<Food> obj = foodService.saveFoods(listFood);
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping("/updateFood")
	@ApiOperation(value = "Update food")
	public ResponseEntity<Food> updateFood(@RequestBody Food food) {
		Food obj = foodService.updateFood(food);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping("/deleteFood/{id}")
	@ApiOperation(value = "Delete the food as the id passed")
	public ResponseEntity<String> deleteFood(@PathVariable Integer id) {
		String obj = foodService.deleteFoodById(id);
		return ResponseEntity.ok().body(obj);
	}
}
