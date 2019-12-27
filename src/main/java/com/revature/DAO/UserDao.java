package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class UserDao implements MainDao<User, Integer>{

	public List<User> findAll() {  // List of all users in DB
		List<User> users = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getConnection()) {
			String sql = "SELECT * FROM USERS ORDER BY LAST_NAME";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				User u = new User();
				u.setUserId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setFirstName(rs.getString(4));
				u.setLastName(rs.getString(4));
				u.setEmail(rs.getString(5));
				u.setUserRoleId(rs.getInt(6));
				u.setApproved(rs.getInt(7));
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	// Returns and ArrayList of all Managers (Role_ID = 2)
	public List<User> findAllManagers() {
		List<User> managers = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getConnection()) {
			String sql = "SELECT * FROM USERS WHERE ROLE_ID = 2";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User u = new User();
				u.setUserId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setFirstName(rs.getString(4));
				u.setLastName(rs.getString(4));
				u.setEmail(rs.getString(5));
				u.setUserRoleId(rs.getInt(6));
				u.setApproved(rs.getInt(7));
				managers.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return managers;
	}
	
	// Returns and ArrayList of all Employees (Role_ID = 1)
	public List<User> findAllEmployees() {
		List<User> employees = new ArrayList<User>();
		try (Connection conn = ConnectionFactory.getConnection()) {
			String sql = "SELECT * FROM USERS WHERE ROLE_ID = 1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setUserId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setFirstName(rs.getString(4));
				u.setLastName(rs.getString(4));
				u.setEmail(rs.getString(5));
				u.setUserRoleId(rs.getInt(6));
				u.setApproved(rs.getInt(7));
				employees.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
	
	@Override
	public User findById(Integer id) {
		User u = null;
		try(Connection conn = ConnectionFactory.getConnection()) {
			String sql = "SELECT * FROM USERS WHERE USER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u = new User();
				u.setUserId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setFirstName(rs.getString(4));
				u.setLastName(rs.getString(4));
				u.setEmail(rs.getString(5));
				u.setUserRoleId(rs.getInt(6));
				u.setApproved(rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	
	public User findByUsername(String username) {
		User u = null;
		try(Connection conn = ConnectionFactory.getConnection()) {
			String sql = "SELECT * FROM USERS WHERE USERNAME = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u = new User();
				u.setUserId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setFirstName(rs.getString(4));
				u.setLastName(rs.getString(4));
				u.setEmail(rs.getString(5));
				u.setUserRoleId(rs.getInt(6));
				u.setApproved(rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	// This takes User LoginPageServlet Info (username and password)
	public User findByLogin(String username, String password) {
		User u = null;
		try(Connection conn = ConnectionFactory.getConnection()) {
			String sql = "SELECT * FROM USERS WHERE USERNAME = ? AND PW = ?";				// Retrieve User by username and password
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u = new User();
				u.setUserId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setFirstName(rs.getString(4));
				u.setLastName(rs.getString(4));
				u.setEmail(rs.getString(5));
				u.setUserRoleId(rs.getInt(6));
				u.setApproved(rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	// returns created user OR returns Null if user wasn't created in the DB
	@Override
	public User create(User u) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "INSERT INTO USERS (USERNAME, PW, FIRST_NAME, LAST_NAME, EMAIL, ROLE_ID) VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setString(5, u.getEmail());
			ps.setInt(6, u.getUserRoleId());
			int numRows = ps.executeUpdate();
			if (numRows == 0) {				// making sure the sql statement returned something
				ResultSet pk = ps.getGeneratedKeys();	// primary keys
				while (pk.next()) {
					u.setUserId(pk.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	// Returns User if update was successful else if Null, doesn't return anything. (checks numRows)
	@Override
	public User update(User u) {
		try(Connection conn = ConnectionFactory.getConnection()) {
			String sql = "UPDATE USERS SET USERNAME = ?, PW = ?, FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ?, ROLE_ID = ? WHERE USER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setString(5, u.getEmail());
			ps.setInt(6, u.getUserRoleId());
			int numRows = ps.executeUpdate();  // checks either (1) the row count for SQL Data Manipulation Language (DML) statements or *** 0 *** for SQL statements that return nothing
			if (numRows == 0) {
				return null; //... is ps.execute (a.k.a numRows) returns 0, that signifies NULL
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	// Deletes a user
	public void delete(int id) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "DELETE FROM USERS WHERE USER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Perhaps I could get fancy and return all users with pending requests
			// --- No, that would go in the reimbursement DAO....then retrieved in SEVICES!!
}
