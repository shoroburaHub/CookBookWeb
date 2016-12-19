package com.cookBook.controller;

import com.cookBook.domain.Ingredient;
import com.cookBook.domain.IngredientAndAmount;
import com.cookBook.domain.MeasuringSystem;
import com.cookBook.domain.Recipe;
import com.cookBook.service.IngredientAndAmountService;
import com.cookBook.service.IngredientService;
import com.cookBook.service.MeasuringSystemService;
import com.cookBook.service.RecipeService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class JamieoliverScan {


	// Сайт, куди ми йдем
	private final String siteUrl = "http://www.jamieoliver.com/";

	// Сервіс рецепту для заповнення в бд
	private RecipeService recipeService;

	private MeasuringSystemService measuringSystemService;
	private IngredientService ingredientService;
	private IngredientAndAmountService ingredientAndAmountService;

	public JamieoliverScan(RecipeService recipeService,
			MeasuringSystemService measuringSystemService,
			IngredientService ingredientService,
			IngredientAndAmountService ingredientAndAmountService) {
		
		this.recipeService = recipeService;
		this.measuringSystemService = measuringSystemService;
		this.ingredientService = ingredientService;
		this.ingredientAndAmountService = ingredientAndAmountService;
	
	}

	public void start() {
		List<MeasuringSystem> measuringSystem = new ArrayList<MeasuringSystem>();
		measuringSystem.add(measuringSystemService.create("tablespoons"));
		measuringSystem.add(measuringSystemService.create("handful"));
		measuringSystem.add(measuringSystemService.create("teaspoons"));
		measuringSystem.add(measuringSystemService.create("teaspoon"));
		measuringSystem.add(measuringSystemService.create("handfuls"));
		measuringSystem.add(measuringSystemService.create("ml"));
		measuringSystem.add(measuringSystemService.create("g"));
		measuringSystem.add(measuringSystemService.create("cup"));
		measuringSystem.add(measuringSystemService.create("large pinch"));
		measuringSystem.add(measuringSystemService.create("pinch"));
		measuringSystem.add(measuringSystemService.create("large free range"));
		measuringSystem.add(measuringSystemService.create("free range"));

		// ф показує, скільки унікальних силок було знайдено
		int f = 0;

		// лист ссилок
		List<String> list = new LinkedList<String>();
		list.add(siteUrl);

		for (int i = 0; i < list.size(); i++) {
			// "велекий стрінг"
			Document doc;

			try {

				// під’єднання до сайту
				// один коннект - один рецепт - одна сторінка
				doc = Jsoup.connect(list.get(i)).get();

				// перевірка, чи знайшовся рецепт.
				Recipe recipe = null;


				Set<IngredientAndAmount> set = findIngredientAndAmount(doc,
						measuringSystem);

				if (set.size() != 0) {
					recipe = findRecipe(doc, set);
				}

				if (recipe != null) {
					recipe.setUrlToRecipe(list.get(i));
					recipeService.createRecipe(recipe);
					recipe.setIngredientAndAmountCB(set);
					recipeService.updateRecipe(recipe);
				}

				Elements hrefs = doc.select("a").addClass("level1");
				for (Element href : hrefs) {
					if (href.attr("href").startsWith("/recipes/")
							&& (!(href.attr("href")
									.startsWith("/recipes/search/")))
							&& (!(href.attr("href")
									.startsWith("/recipes/print/")))) {
						String str = siteUrl + href.attr("href").substring(1);
						int j = 0;
						for (String s : list) {
							if (str.equals(s)) {
								j++;
							}
						}
						if (j == 0) {
							list.add(str);
							System.out.println(f++);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Set<IngredientAndAmount> findIngredientAndAmount(Document doc,
			List<MeasuringSystem> measuringSystem) {
		Set<IngredientAndAmount> setIngredientAndAmount = new HashSet<IngredientAndAmount>();
		Elements parseIngredients = doc.select("span");
		for (int i = 0; i < parseIngredients.size(); i++) {
			if (!parseIngredients.get(i).ownText().equalsIgnoreCase("close")
					&& (!parseIngredients.get(i).ownText()
							.equalsIgnoreCase("or")))
				if (parseIngredients.get(i).parent().parent().parent().parent()
						.hasClass("cntr")) {
					if (parseIngredients.get(i).ownText().equals("")
							&& parseIngredients.get(i + 1).ownText().equals("")) {
						break;
					}
					StringTokenizer t = new StringTokenizer(parseIngredients
							.get(i).ownText(), " -;");
					List<String> list = new ArrayList<String>();
					while (t.hasMoreElements()) {
						list.add((String) t.nextElement());
					}
					boolean b = false;
					MeasuringSystem mS = null;
					for (MeasuringSystem mS2 : measuringSystem) {
						for (int j = 0; j < list.size(); j++) {
							if (list.get(j).equalsIgnoreCase(mS2.getName())) {
								mS = mS2;
								list.remove(j);
								b = true;
								break;
							}
						}
						if (b)
							break;
					}
					double amount = 0;
					for (int j = 0; j < list.size(); j++) {
						if (list.get(j).equals("1½")) {
							amount = 1.5;
							list.remove(j);
							break;
						} else if (list.get(j).equals("½")) {
							amount = 0.5;
							list.remove(j);
							break;
						} else if (list.get(j).equals("2½")) {
							amount = 2.5;
							list.remove(j);
							break;
						} else if (list.get(j).equals("3½")) {
							amount = 3.5;
							list.remove(j);
							break;
						} else if (list.get(j).equals("4½")) {
							amount = 4.5;
							list.remove(j);
							break;
						}
						try {
							amount = Double.parseDouble(list.get(j));
							list.remove(j);
							break;
						} catch (NumberFormatException e) {
						}
					}
					String ingredientName = "";
					if (list.size() > 1) {
						for (String st : list) {
							ingredientName += st + " ";
						}
					} else if (list.size() != 0) {
						ingredientName = list.get(0);
					}
					if (!ingredientName.equals("")) {
						Ingredient ingredient = ingredientService.create(
								ingredientName, mS);
						IngredientAndAmount ingredientAndAmount = ingredientAndAmountService
								.create(amount, ingredient);
						setIngredientAndAmount.add(ingredientAndAmount);
					}
				}
		}
		return setIngredientAndAmount;
	}

	public Recipe findRecipe(Document doc, Set<IngredientAndAmount> set) {
		String recipeName = null;

		Elements newsHeadlines = doc.select("h1");
		for (Element element : newsHeadlines) {
			if (element.hasClass("fn")) {
				recipeName = element.ownText();
			}
		}
		if (recipeName != null) {
			Recipe recipe = new Recipe(recipeName);
			return recipe;
		} else
			return null;

	}

}
