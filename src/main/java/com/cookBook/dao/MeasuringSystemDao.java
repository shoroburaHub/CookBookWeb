package com.cookBook.dao;

import com.cookBook.domain.MeasuringSystem;

public interface MeasuringSystemDao extends GeneralDao<MeasuringSystem, Integer>{
	
	MeasuringSystem findIfExist(String name);
}
