package com.cookBook.dao;

import com.cookBook.domain.Ingredient;

public interface IngredientDao extends GeneralDao<Ingredient, Integer>{
	
	Ingredient findIfExist(String ingredientName, int measuringlSystemId);
	Ingredient findIfExistByName(String ingredientName);
}
