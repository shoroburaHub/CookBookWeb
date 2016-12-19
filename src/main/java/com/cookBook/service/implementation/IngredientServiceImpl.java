package com.cookBook.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookBook.dao.IngredientDao;
import com.cookBook.domain.Ingredient;
import com.cookBook.domain.MeasuringSystem;
import com.cookBook.service.IngredientService;

@Service("ingredientService")
public class IngredientServiceImpl implements IngredientService {

	@Autowired
	private IngredientDao ingredientDao;

	public Ingredient create(String name, MeasuringSystem measuringSystem) {
		Ingredient ingredient = null;
		if ((name != null) && (!(name.equals("")))) {
			if (measuringSystem != null) {
				ingredient = ingredientDao.findIfExist(name,
						measuringSystem.getId());
			} else {
				ingredient = ingredientDao.findIfExistByName(name);
			}
			if (ingredient == null) {
				ingredient = new Ingredient(name, measuringSystem);
				ingredientDao.create(ingredient);
			}
		}
		return ingredient;
	}

	public List<Ingredient> getAllIngredient() {
		return ingredientDao.getAll();
	}
}
