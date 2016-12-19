package com.cookBook.service.implementation;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookBook.dao.IngredientAndAmountDao;
import com.cookBook.domain.Ingredient;
import com.cookBook.domain.IngredientAndAmount;
import com.cookBook.service.IngredientAndAmountService;

@Service("ingredientAndAmountService")
public class IngredientAndAmountServiceImpl implements IngredientAndAmountService{

	@Autowired
	private IngredientAndAmountDao ingredientAndAmountDao;
	
	public IngredientAndAmount create(double amount, Ingredient ingredient) {
		IngredientAndAmount ingredientAndAmount = new IngredientAndAmount(ingredient, amount);
		ingredientAndAmountDao.create(ingredientAndAmount);
		return ingredientAndAmount;
	}

	public void deleteAll(Set<IngredientAndAmount> ingredientAndAmount) {
		for (IngredientAndAmount ingredientAndAmount2 : ingredientAndAmount) {
			ingredientAndAmountDao.delete(ingredientAndAmount2);
		}
		
	}

	
}
