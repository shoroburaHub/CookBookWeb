package com.cookBook.dao;

import java.util.List;

import com.cookBook.domain.Recipe;

public interface RecipeDao extends GeneralDao<Recipe, Integer>{

	Recipe findIfExist();
	List<Recipe> findIfExistByName(String name);
}
