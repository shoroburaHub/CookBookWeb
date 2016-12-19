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
	@NamedQuery(name = Country.FIND_IF_EXIST, query = Country.FIND_IF_EXIST_QUERY)
})
public class Country {
	public static final String FIND_IF_EXIST = "Country.findIfExist";
	public static final String FIND_IF_EXIST_QUERY = "SELECT c FROM Country c WHERE c.countryName = :countryName";
	
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String countryName;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "country")
	private List<Recipe> recipes;

	public Country() {
	}

	public Country(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
