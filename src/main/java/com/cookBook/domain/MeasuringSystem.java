package com.cookBook.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name = MeasuringSystem.FIND_IF_EXIST, query = MeasuringSystem.FIND_IF_EXIST_QUERY)
})
public class MeasuringSystem {
	public static final String FIND_IF_EXIST = "MeasuringSystem.findIfExist";
	public static final String FIND_IF_EXIST_QUERY = "SELECT m FROM MeasuringSystem m WHERE m.name = :name";
	
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String name;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "measuringSystem")
	private List<Ingredient> ingredients;
	
	public MeasuringSystem() {
	}

	public MeasuringSystem(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	
}
