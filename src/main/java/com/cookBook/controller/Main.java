package com.cookBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cookBook.service.IngredientAndAmountService;
import com.cookBook.service.IngredientService;
import com.cookBook.service.MeasuringSystemService;
import com.cookBook.service.RecipeService;

public class Main {

	@Autowired
	public static IngredientService ingredientService;

	public static void main(String[] args) {

		ConfigurableApplicationContext con = new ClassPathXmlApplicationContext(
				"META-INF/appContext.xml");
		RecipeService recipeService = (RecipeService) con
				.getBean("recipeService");
		MeasuringSystemService measuringSystemService = (MeasuringSystemService) con
				.getBean("measuringSystemService");
		IngredientService ingredientService = (IngredientService) con
				.getBean("ingredientService");
		IngredientAndAmountService ingredientAndAmountService = (IngredientAndAmountService) con
				.getBean("ingredientAndAmountService");

		JamieoliverScan s = new JamieoliverScan(recipeService,
				measuringSystemService, ingredientService,
				ingredientAndAmountService); // ½
		s.start();

		// Pattern pattern = Pattern.compile("(\\w|,| )*");
		// Matcher matcher = pattern.matcher("fdmsn       gm,23ds,,");
		// System.out.print(matcher.matches());

		// List<Ingredient> ingredientNames =
		// ingredientService.getAllIngredient();
		//
		// Filter filter = new Filter();
		//
		// for (int i = 0; i < ingredientNames.size(); i++) {
		// Ingredient ingredient = new Ingredient();
		// ingredient.setIngredientName(filter.deleteAfterComa(ingredientNames.get(i).getIngredientName()));
		// ingredientService.update(ingredient);
		// }

	}

}
