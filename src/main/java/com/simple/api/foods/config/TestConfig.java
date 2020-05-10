package com.simple.api.foods.config;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.simple.api.foods.entities.Food;
import com.simple.api.foods.repositories.FoodRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
		
	@Autowired
	private FoodRepository foodRepository;

	@Override
	public void run(String... args) throws Exception {
		Food f1 = new Food(null, "Chocolate", "Barra de chocolate", new BigDecimal(4.90));
		Food f2 = new Food(null, "Pizza", "Quatro carnes", new BigDecimal(39.90));

		foodRepository.saveAll(Arrays.asList(f1,f2));
	}
	
	
	
	
}
