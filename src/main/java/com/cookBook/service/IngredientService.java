package com.cookBook.service;

import java.util.List;

import com.cookBook.domain.Ingredient;
import com.cookBook.domain.MeasuringSystem;

public interface IngredientService {
	Ingredient create(String name, MeasuringSystem measuringSystem);
	List<Ingredient> getAllIngredient();
}
