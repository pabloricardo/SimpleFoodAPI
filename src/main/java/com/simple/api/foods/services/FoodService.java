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
	
}
