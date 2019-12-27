package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.UserRoles;
import com.revature.util.ConnectionFactory;

public class UserRolesDao implements MainDao <UserRoles, Integer> {
	
	// Returns an ArrayList of all the RoleID's and the associated Titles.
	@Override
	public List<UserRoles> findAll() {
		List<UserRoles> roles = new ArrayList<UserRoles>();
		try(Connection conn = ConnectionFactory.getConnection()) {
			String sql = "SELECT * FROM USER_ROLES ORDER BY USER_ROLE_ID";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				UserRoles ur = new UserRoles();
				ur.setRoleId(rs.getInt(1));
				ur.setRole(rs.getString(2));
				roles.add(ur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roles;
	}
	
	@Override
	public UserRoles findById(Integer id) {
		UserRoles ur = null;
		try(Connection conn = ConnectionFactory.getConnection()) {
			String sql = "SELECT * FROM USER_ROLES WHERE USER_ROLE_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ur = new UserRoles();
				ur.setRoleId(rs.getInt(1));
				ur.setRole(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ur;
	}

	@Override
	public UserRoles create(UserRoles obj) {
		return null;
	}

	@Override
	public UserRoles update(UserRoles obj) {
		return null;
	}

}
