package com.cookBook.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cookBook.dao.IngredientDao;
import com.cookBook.domain.Ingredient;

@Repository
public class IngredientDaoImpl extends GeneralDaoImpl<Ingredient, Integer>
		implements IngredientDao {

	
	public IngredientDaoImpl() {
		super(Ingredient.class);
	}

	@PersistenceContext(unitName = "Primary")
	EntityManager em;

	@Transactional
	public Ingredient findIfExist(String ingredientName, int measuringlSystemId) {
		try {
			return (Ingredient) em.createNamedQuery(Ingredient.FIND_IF_EXIST)
					.setParameter("ingredientName", ingredientName)
					.setParameter("id", measuringlSystemId).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Transactional
	public Ingredient findIfExistByName(String ingredientName) {
		try {
			return (Ingredient) em
					.createNamedQuery(Ingredient.FIND_IF_EXIST_BY_NAME)
					.setParameter("ingredientName", ingredientName)
					.setParameter("id", null)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
