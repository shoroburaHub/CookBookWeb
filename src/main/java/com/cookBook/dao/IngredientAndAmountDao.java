package com.cookBook.dao;

import com.cookBook.domain.IngredientAndAmount;

public interface IngredientAndAmountDao extends GeneralDao<IngredientAndAmount, Integer>{
	
	IngredientAndAmount findIfExist(int amount, int ingredientId);
}
