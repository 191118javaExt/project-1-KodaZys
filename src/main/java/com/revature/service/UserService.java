package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.DAO.UserDao;
import com.revature.models.User;

public class UserService {


	static UserDao ud = new UserDao();
	
	public User getUserById(int id) {
		User u = ud.findById(id);
		return u;
	}
	
	public List<User> getAllUsers(){
		List<User> us = new ArrayList<User>();
		us = ud.findAll();
		return us;
	}
	
	public List<User> getAllManagers() {
		List<User> us = new ArrayList<User>();
		us = ud.findAllManagers();
		return us;
	}
	
	public List<User> getAllEmployees() {
		List<User> us = new ArrayList<User>();
		us = ud.findAllEmployees();
		return us;
	}
	
	public User getUserByUsername(String username) {
		User u = ud.findByUsername(username);
		return u;
	}	
	
	public User getUserByLogin(String email, String password) {
		User u = ud.findByLogin(email, password);
		return u;
	}
}

//	
//}
