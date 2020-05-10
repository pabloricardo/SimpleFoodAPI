package com.simple.api.foods.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple.api.foods.entities.Food;

public interface FoodRepository extends JpaRepository<Food, Integer>{
	

}
