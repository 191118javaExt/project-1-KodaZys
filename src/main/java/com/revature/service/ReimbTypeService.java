package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.DAO.ReimbTypeDao;
import com.revature.models.ReimbType;

public class ReimbTypeService {

	static ReimbTypeDao rTypeDao = new ReimbTypeDao(); 
	
	// return all ReimbursementTypes (1 - 4)
	public List<ReimbType> getAllReimbTypes() {						// creates empty ArrayList 
		List<ReimbType> rTypes = new ArrayList<ReimbType>();  		
		rTypes = rTypeDao.findAll();								// populates ArrayList by calling the ReimbTypeDao
		return rTypes;												// returns all values => ArrayList from Dao function
	}
	
	public String getById(int id) {
		String type = null;
		type = rTypeDao.findById(id);
		return type;
	}

	public List<ReimbType> getAll(){
		List<ReimbType> types = new ArrayList<ReimbType>();
		types = rTypeDao.findAll();		
		return types;
	}

}
