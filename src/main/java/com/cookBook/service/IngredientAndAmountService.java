package com.cookBook.service;

import java.util.Set;

import com.cookBook.domain.Ingredient;
import com.cookBook.domain.IngredientAndAmount;

public interface IngredientAndAmountService {
	IngredientAndAmount create(double amount, Ingredient ingredient);
	void deleteAll(Set<IngredientAndAmount> ingredientAndAmount);
}
