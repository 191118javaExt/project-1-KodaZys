package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.ReimbType;
import com.revature.util.ConnectionFactory;

public class ReimbTypeDao implements MainDao<ReimbType, Integer> {
	
	@Override
	public List<ReimbType> findAll() {
		List<ReimbType> rTypes = new ArrayList<ReimbType>();
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT * FROM REIMB_TYPE ORDER BY REIMB_TYPE_ID";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				ReimbType rt = new ReimbType();
				rt.setReimbTypeId(rs.getInt(1));
				rt.setReimbType(rs.getString(2));
				rTypes.add(rt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rTypes;
	}
	
	// Returns just the String word of the Reimb Type 
	public String findById(int id) {
		String type = null;
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT REIMB_TYPE FROM REIMB_TYPE WHERE REIMB_TYPE_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			type = rs.getString(1);			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return type;
	}
	
	// The above method replaces this one.
	@Override
	public ReimbType findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	// DO NOT NEED THIS METHOD 
	@Override
	public ReimbType create(ReimbType rt) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "INSERT INTO REIMB_TYPE (REIMB_TYPE) VALUES(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, rt.getReimbType());
			int numRows = ps.executeUpdate();
			if (numRows == 0) {							// make sure SQL returns num > 0; (means it returned something)
				ResultSet pk = ps.getGeneratedKeys();	// primary keys
				while (pk.next()) {
					rt.setReimbTypeId(pk.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rt;
	}
	
	
	// DO NOT NEED THIS METHOD
	@Override
	public ReimbType update(ReimbType rt) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "UPDATE REIMB_TYPE SET REIMB_TYPE = ? WHERE USER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, rt.getReimbType());
			int numRows = ps.executeUpdate();
			if (numRows == 0) {
				return null;                 //... is ps.execute (a.k.a numRows) returns 0, that signifies NULL
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rt;
	}
}