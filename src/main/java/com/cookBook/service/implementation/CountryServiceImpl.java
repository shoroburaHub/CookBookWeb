package com.cookBook.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookBook.dao.CountryDao;
import com.cookBook.domain.Country;
import com.cookBook.service.CountryService;

@Service("countryService")
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryDao countryDao;
	
	public Country create(String name) {
		Country country = countryDao.findIfExist(name);
		if (country == null){
			country = new Country(name);
			countryDao.create(country);
		}
		return country;
	}

}
