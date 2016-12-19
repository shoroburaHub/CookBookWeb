package com.cookBook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cookBook.domain.Ingredient;
import com.cookBook.service.IngredientService;

@Controller
public class IngredientController {

	
	@Autowired
	private IngredientService ingredientService;
	
	@RequestMapping(value = "/showAllIngredient")
	public String getAllIngredient(Model model){
		List<Ingredient> ingredients = ingredientService.getAllIngredient();
		model.addAttribute("allIngredients", ingredients);
		return "ingredient-all";
	}
}
