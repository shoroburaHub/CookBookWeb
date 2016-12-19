package com.cookBook.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cookBook.dao.MeasuringSystemDao;
import com.cookBook.domain.MeasuringSystem;

@Repository
public class MeasuringSystemDaoImpl extends
		GeneralDaoImpl<MeasuringSystem, Integer> implements MeasuringSystemDao {

	
	public MeasuringSystemDaoImpl() {
		super(MeasuringSystem.class);
	}

	@PersistenceContext(unitName = "Primary")
	EntityManager em;

	@Transactional
	public MeasuringSystem findIfExist(String name) {
		try {
			return (MeasuringSystem) em
					.createNamedQuery(MeasuringSystem.FIND_IF_EXIST)
					.setParameter("name", name).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
