package com.cookBook.service.implementation;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookBook.dao.RecipeDao;
import com.cookBook.domain.Recipe;
import com.cookBook.service.RecipeService;

@Service("recipeService")
public class RecipeServiceImpl implements RecipeService{
	
	@Autowired
	private RecipeDao recipeDao;
	
	public void createRecipe(Recipe recipe) {
		recipeDao.create(recipe);
	}
	
	public void updateRecipe(Recipe recipe) {
		recipeDao.update(recipe);
	}

	public List<Recipe> getAllRecipe() {
		return recipeDao.getAll();
	}

	public List<Recipe> findIfExistByName(String name) {
		return recipeDao.findIfExistByName(name);
	}

	public List<Recipe> getAllByPatrOfName(String partOfName) {
		List<Recipe> listFromDB= recipeDao.getAll();
		for (int i =0; i<listFromDB.size(); i++) {
			if (!isWordsFound(partOfName, listFromDB.get(i).getName()));{
				listFromDB.remove(i);
			}
		}
		return listFromDB;
	}
	
	public boolean isWordsFound(String searchingWords, String recipeName) {
		Pattern pattern = Pattern.compile("[a-z]\\S*", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(searchingWords);
		String regex = "^.*";
		while(matcher.find()){
			regex += matcher.group() + ".*";
		}
		regex+="$";
        return Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(recipeName).find();
    }
	
}
