package com.cookBook.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = Recipe.FIND_IF_EXIST_BY_NAME, query = Recipe.FIND_IF_EXIST_QUERY_BY_NAME)
})
public class Recipe {
	public static final String FIND_IF_EXIST_BY_NAME = "Recipe.findIfExistByName";
	public static final String FIND_IF_EXIST_QUERY_BY_NAME = "FROM Recipe r WHERE r.name = :name";
	
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String name;
	@Column
	private String urlToRecipe;
	@Column
	private double rating;
	@Column
	private int cookTime;
	@ManyToOne
	@JoinColumn
	private Country country;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "recipe_ingredient_and_amount", joinColumns = 
	@JoinColumn(name = "fk_recipe"), inverseJoinColumns = 
	@JoinColumn(name = "fk_ingredient_and_amount"))
	private Set<IngredientAndAmount> ingredientAndAmount;

	public Recipe() {
	}

	public Recipe(String name, Set<IngredientAndAmount> set){
		this.name = name;
		ingredientAndAmount = set;
	}
	
	public Recipe(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public void setIngredientAndAmountCB(
			Set<IngredientAndAmount> ingredientAndAmount) {
		this.ingredientAndAmount = ingredientAndAmount;
	}

	public Set<IngredientAndAmount> getIngredientAndAmount() {
		return ingredientAndAmount;
	}

	public String getUrlToRecipe() {
		return urlToRecipe;
	}

	public void setUrlToRecipe(String urlToRecipe) {
		this.urlToRecipe = urlToRecipe;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public int getCookTime() {
		return cookTime;
	}

	public void setCookTime(int cookTime) {
		this.cookTime = cookTime;
	}

}
