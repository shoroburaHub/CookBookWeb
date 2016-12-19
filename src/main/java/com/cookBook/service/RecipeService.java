package com.cookBook.service;

import java.util.List;

import com.cookBook.domain.Recipe;

public interface RecipeService {
	
	void createRecipe(Recipe recipe);
	void updateRecipe(Recipe recipe);
	List<Recipe> getAllRecipe();
	List<Recipe> findIfExistByName(String name);
	List<Recipe> getAllByPatrOfName(String partOfName);
}
