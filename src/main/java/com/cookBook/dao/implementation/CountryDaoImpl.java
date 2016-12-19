package com.cookBook.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cookBook.dao.CountryDao;
import com.cookBook.domain.Country;

@Repository
public class CountryDaoImpl extends GeneralDaoImpl<Country, Integer> implements
		CountryDao {

	public CountryDaoImpl() {
		super(Country.class);
	}

	@PersistenceContext(unitName = "Primary")
	EntityManager em;

	@Transactional
	public Country findIfExist(String countryName) {
		try {
			return (Country) em.createNamedQuery(Country.FIND_IF_EXIST)
					.setParameter("countryName", countryName).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
