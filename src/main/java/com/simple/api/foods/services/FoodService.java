package com.simple.api.foods.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.simple.api.foods.entities.Food;
import com.simple.api.foods.repositories.FoodRepository;

@Service
public class FoodService {
	
	@Autowired
	private FoodRepository foodRepository;

	public List<Food> findAll(){
		return foodRepository.findAll();
	}
	
	public Food findById(Integer id) {
		Optional<Food> obj = foodRepository.findById(id);
		return obj.get();
	}
	
	public Food findByName(String name) {
		return foodRepository.findByName(name);
	}
	
	public Food saveFood(Food food) {
		return foodRepository.save(food);
	}
	
	public List<Food> saveFoods(List<Food> Listfoods){
		return foodRepository.saveAll(Listfoods);
	}
	
	public String deleteFoodById(Integer id) {
		foodRepository.deleteById(id);
		return "Food removed!";
	}
	
	public void deleteAllFoods() {
		foodRepository.deleteAll();
	}
	
	public Food updateFood(Food food) {
		Food existingFood = foodRepository.findById(food.getId()).orElse(null);
		existingFood.setName(food.getName());
		existingFood.setDescription(food.getDescription());
		existingFood.setPrice(food.getPrice());
		return foodRepository.save(existingFood);
	}
		
}
