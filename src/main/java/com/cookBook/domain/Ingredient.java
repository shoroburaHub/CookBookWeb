package com.cookBook.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name = Ingredient.FIND_IF_EXIST, query = Ingredient.FIND_IF_EXIST_QUERY),
	@NamedQuery(name = Ingredient.FIND_IF_EXIST_BY_NAME, query = Ingredient.FIND_IF_EXIST_BY_NAME_QUERY)
})
public class Ingredient {
	public static final String FIND_IF_EXIST = "Ingredient.findIfExist";
	public static final String FIND_IF_EXIST_QUERY = "SELECT i FROM Ingredient i WHERE i.ingredientName = :ingredientName AND i.measuringSystem.id = :id";
	public static final String FIND_IF_EXIST_BY_NAME = "Ingredient.findIfExistByName";
	public static final String FIND_IF_EXIST_BY_NAME_QUERY = "SELECT i FROM Ingredient i WHERE i.ingredientName =:ingredientName AND i.measuringSystem.id = :id";
	
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String ingredientName;
	@ManyToOne
	private MeasuringSystem measuringSystem;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ingredient")
	private List<IngredientAndAmount> ingredientAndAmount;

	public Ingredient() {
	}

	public Ingredient(String ingredientName, MeasuringSystem measuringSystem) {
		this.ingredientName = ingredientName;
		this.measuringSystem = measuringSystem;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public MeasuringSystem getMeasuringSystem() {
		return measuringSystem;
	}

	public void setMeasuringlSystem(MeasuringSystem measuringSystem) {
		this.measuringSystem = measuringSystem;
	}

	public List<IngredientAndAmount> getIngredientAndAmount() {
		return ingredientAndAmount;
	}

	public void setIngredientAndAmount(List<IngredientAndAmount> ingredientAndAmount) {
		this.ingredientAndAmount = ingredientAndAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
