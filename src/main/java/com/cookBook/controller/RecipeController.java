package com.cookBook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cookBook.domain.Recipe;
import com.cookBook.service.RecipeService;

@Controller
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
	@RequestMapping(value = "/showAllRecipes")
	public String getAllRecipes(Model model) {
		List<Recipe> recipes = recipeService.getAllRecipe();
		model.addAttribute("allRecipes", recipes);
		return "recipe-all";
	}
	@RequestMapping(value = "/searchRecipe", method = RequestMethod.POST)
	public String findResipeByName(@RequestParam(value = "name") String name, Model model){
		List<Recipe> recipes = (List<Recipe>) recipeService.getAllByPatrOfName(name);
		model.addAttribute("Recipes", recipes);
		return "recipe-resultsearch";
	}
}
