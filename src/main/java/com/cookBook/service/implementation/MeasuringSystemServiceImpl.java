package com.cookBook.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookBook.dao.MeasuringSystemDao;
import com.cookBook.domain.MeasuringSystem;
import com.cookBook.service.MeasuringSystemService;

@Service("measuringSystemService")
public class MeasuringSystemServiceImpl implements MeasuringSystemService{
	
	@Autowired
	private MeasuringSystemDao measurindSystemDao;
	
	public MeasuringSystem create(String name) {
		MeasuringSystem measuringSystem = measurindSystemDao.findIfExist(name);
		if (measuringSystem == null){
			measuringSystem = new MeasuringSystem(name);
			measurindSystemDao.create(measuringSystem);
		}
		return measuringSystem;
	}

}
