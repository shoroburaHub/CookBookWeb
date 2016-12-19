package com.cookBook.dao;

import com.cookBook.domain.Country;

public interface CountryDao extends GeneralDao<Country, Integer>{
	
	Country findIfExist(String countryName);
}
