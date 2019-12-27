package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.util.ConnectionFactory;

public class ReimbursementDao implements MainDao<Reimbursement, Integer> {

	//findAllResolved	
	
	// Return ArrayList of all Reimbursements ordered by Time Submitted in Desc. order.
	@Override
	public List<Reimbursement> findAll() {
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getConnection()) {
			String sql = "SELECT * FROM REIMBURSEMENT ORDER BY SUBMITTED DESC";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbId(rs.getInt(1));
				r.setAmount(rs.getDouble(2));
				r.setTimeSubmitted(rs.getString(3));
				r.setTimeResolved(rs.getString(4));
				r.setDescription(rs.getString(5));
				r.setAuthorId(rs.getInt(6));
				r.setResolverId(rs.getInt(7));
				r.setStatusId(rs.getInt(8));
				r.setTypeId(rs.getInt(9));
				reimbs.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}
	

	//Return specific Reimbursement by finding it with Reimb_Id 
	@Override
	public Reimbursement findById(Integer id) {
		Reimbursement r = null;
		try(Connection conn = ConnectionFactory.getConnection()) {
			String sql = "SELECT FROM REIMBURSEMENT WHERE REIMB_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()) {
				r = new Reimbursement();
				r.setReimbId(id);
				r.setAmount(rs.getDouble(2));
				r.setTimeSubmitted(rs.getString(3));
				r.setTimeResolved(rs.getString(4));
				r.setDescription(rs.getString(5));
				r.setAuthorId(rs.getInt(6));
				r.setResolverId(rs.getInt(7));
				r.setStatusId(rs.getInt(8));
				r.setTypeId(rs.getInt(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	// Find all PENDING ==> if STATUS_ID 1 == PENDING
	public List<Reimbursement> findAllPending() {
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getConnection()) {
			String sql = "SELECT * FROM REIMBURSEMENT WHERE STATUS_ID = 1 ORDER BY SUBMITTED DESC";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbId(rs.getInt(1));
				r.setAmount(rs.getDouble(2));
				r.setTimeSubmitted(rs.getString(3));
				r.setTimeResolved(rs.getString(4));
				r.setDescription(rs.getString(5));
				r.setAuthorId(rs.getInt(6));
				r.setResolverId(rs.getInt(7));
				r.setStatusId(rs.getInt(8));
				r.setTypeId(rs.getInt(9));
				reimbs.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}
	
	// Find all PENDING ==> if STATUS_ID 2 == APPROVED && STATUS_ID ==3 Denied;
	public List<Reimbursement> findAllResolved() {
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getConnection()) {
			String sql = "SELECT * FROM REIMBURSEMENT WHERE STATUS_ID = 2 OR STATUS_ID = 3 ORDER BY SUBMITTED DESC";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbId(rs.getInt(1));
				r.setAmount(rs.getDouble(2));
				r.setTimeSubmitted(rs.getString(3));
				r.setTimeResolved(rs.getString(4));
				r.setDescription(rs.getString(5));
				r.setAuthorId(rs.getInt(6));
				r.setResolverId(rs.getInt(7));
				r.setStatusId(rs.getInt(8));
				r.setTypeId(rs.getInt(9));
				reimbs.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

	// Find all APPROVED if STATUS_ID 2 == APPROVED
	public List<Reimbursement> findAllApproved() {
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getConnection()) {
			String sql = "SELECT * FROM REIMBURSEMENT WHERE STATUS_ID = 2 ORDER BY SUBMITTED DESC";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbId(rs.getInt(1));
				r.setAmount(rs.getDouble(2));
				r.setTimeSubmitted(rs.getString(3));
				r.setTimeResolved(rs.getString(4));
				r.setDescription(rs.getString(5));
				r.setAuthorId(rs.getInt(6));
				r.setResolverId(rs.getInt(7));
				r.setStatusId(rs.getInt(8));
				r.setTypeId(rs.getInt(9));
				reimbs.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

	// Find all DENIED if STATUS_ID 3 == DENIED
	public List<Reimbursement> findAllDenied() {
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getConnection()) {
			String sql = "SELECT * FROM REIMBURSEMENT WHERE STATUS_ID = 3 ORDER BY SUBMITTED DESC";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbId(rs.getInt(1));
				r.setAmount(rs.getDouble(2));
				r.setTimeSubmitted(rs.getString(3));
				r.setTimeResolved(rs.getString(4));
				r.setDescription(rs.getString(5));
				r.setAuthorId(rs.getInt(6));
				r.setResolverId(rs.getInt(7));
				r.setStatusId(rs.getInt(8));
				r.setTypeId(rs.getInt(9));
				reimbs.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

	// finds all Reimbs by specific Author ID
	public List<Reimbursement> findByAuthorId(int authorId) {
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getConnection()) {
			String sql = "SELECT * FROM REIMBURSEMENT WHERE AUTHOR_ID = ? ORDER BY SUBMITTED DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,  authorId);
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbId(rs.getInt(1));
				r.setAmount(rs.getDouble(2));
				r.setTimeSubmitted(rs.getString(3));
				r.setTimeResolved(rs.getString(4));
				r.setDescription(rs.getString(5));
				r.setAuthorId(rs.getInt(6));
				r.setResolverId(rs.getInt(7));
				r.setStatusId(rs.getInt(8));
				r.setTypeId(rs.getInt(9));
				reimbs.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}
	
	// finds all Reimbs by specific Resolver ID
	public List<Reimbursement> findByResolverId(int resolverId) {
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getConnection()) {
			String sql = "SELECT * FROM REIMBURSEMENT WHERE RESOLVER_ID = ? ORDER BY SUBMITTED DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, resolverId);
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbId(rs.getInt(1));
				r.setAmount(rs.getDouble(2));
				r.setTimeSubmitted(rs.getString(3));
				r.setTimeResolved(rs.getString(4));
				r.setDescription(rs.getString(5));
				r.setAuthorId(rs.getInt(6));
				r.setResolverId(rs.getInt(7));
				r.setStatusId(rs.getInt(8));
				r.setTypeId(rs.getInt(9));
				reimbs.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}


	// Create a Reimbursement record Object -- store in DB
	@Override
	public Reimbursement create(Reimbursement r) {
		try(Connection conn = ConnectionFactory.getConnection()) {
			String sql = "INSERT INTO REIMBURSEMENT (AMOUNT, SUBMITTED, RESOLVED, DESCRIPTION, RECIEPT, AUTHOR_ID, RESOLVER, STATUS_ID, TYPE_ID)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, r.getAmount());
			ps.setString(2, r.getTimeSubmitted());
			ps.setString(3, r.getTimeResolved());
			ps.setString(4, r.getDescription());
			ps.setInt(5, r.getAuthorId());
			ps.setInt(6, r.getResolverId());
			ps.setInt(7, r.getStatusId());
			ps.setInt(8, r.getTypeId());
			int numRows = ps.executeUpdate();
			if(numRows == 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					r.setReimbId(pk.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public Reimbursement update(Reimbursement obj) {
		// TODO Auto-generated method stub
		return null;
	}

}

