package com.cookBook.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cookBook.dao.IngredientAndAmountDao;
import com.cookBook.domain.IngredientAndAmount;

@Repository
public class IngredientAndAmountDaoImpl extends
		GeneralDaoImpl<IngredientAndAmount, Integer> implements
		IngredientAndAmountDao {

	public IngredientAndAmountDaoImpl() {
		super(IngredientAndAmount.class);
	}

	@PersistenceContext(unitName = "Primary")
	EntityManager em;

	@Transactional
	public IngredientAndAmount findIfExist(int amount, int ingredientId) {
		try {
			return (IngredientAndAmount) em
					.createNamedQuery(IngredientAndAmount.FIND_IF_EXIST)
					.setParameter("amount", amount)
					.setParameter("id", ingredientId).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
