package com.cookBook.domain;

import java.util.List;

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
	@NamedQuery(name = IngredientAndAmount.FIND_IF_EXIST, query = IngredientAndAmount.FIND_IF_EXIST_QUERY)
})
public class IngredientAndAmount {
	public static final String FIND_IF_EXIST = "IngredientAndAmount.findIfExist";
	public static final String FIND_IF_EXIST_QUERY = "SELECT i FROM IngredientAndAmount i WHERE i.amount = :amount AND i.ingredient.id = :id";
	
	@Id
	@GeneratedValue
	private int id;
	@Column
	private double amount;
	@ManyToOne
	@JoinColumn
	private Ingredient ingredient;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "recipe_ingredient_and_amount", 
	joinColumns = @JoinColumn(name = "fk_ingredient_and_amount"), 
	inverseJoinColumns = @JoinColumn(name = "fk_recipe"))
	private List<Recipe> recipes;

	public IngredientAndAmount() {
	}

	public IngredientAndAmount(Ingredient indredient, double amount) {
		this.amount = amount;
		this.ingredient = indredient;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
