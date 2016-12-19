package com.cookBook.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cookBook.dao.RecipeDao;
import com.cookBook.domain.Recipe;

@Repository
public class RecipeDaoImpl extends GeneralDaoImpl<Recipe, Integer> implements
		RecipeDao {

	public RecipeDaoImpl() {
		super(Recipe.class);
	}

	@PersistenceContext(unitName = "Primary")
	EntityManager em;

	@Transactional
	public Recipe findIfExist() {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Recipe> findIfExistByName(String name) {
		try {
			return em.createNamedQuery(Recipe.FIND_IF_EXIST_BY_NAME)
					.setParameter("name", name).getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

}
