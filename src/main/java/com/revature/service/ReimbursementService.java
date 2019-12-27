package com.revature.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.revature.DAO.ReimbursementDao;
import com.revature.models.Reimbursement;

public class ReimbursementService {
	
	Logger log = Logger.getLogger(ReimbursementService.class);
	static ReimbursementDao rd = new ReimbursementDao();
	
	public Reimbursement getReimbById(int id) {
		Reimbursement r = rd.findById(id);
		return r;
	}
	
	public List<Reimbursement> getAllReimbursements(){
		List<Reimbursement> rs = new ArrayList<Reimbursement>();
		rs = rd.findAll();
		return rs;
	}
	
	public List<Reimbursement> getAllPendingReimbursements() {
		List<Reimbursement> rs = new ArrayList<Reimbursement>();
		rs = rd.findAllPending();
		return rs;
	}
	
	public List<Reimbursement> getAllApprovedReimbursements() {
		List<Reimbursement> rs = new ArrayList<Reimbursement>();
		rs = rd.findAllApproved();
		return rs;
	}
	
	public List<Reimbursement> getAllDeniedReimbursements() {
		List<Reimbursement> rs = new ArrayList<Reimbursement>();
		rs = rd.findAllDenied();
		return rs;
	}
	
	public List<Reimbursement> getAllResolvedReimbursements() {
		List<Reimbursement> rs = new ArrayList<Reimbursement>();
		rs = rd.findAllResolved();
		return rs;
	}
	
	public List<Reimbursement> getAllCreatedByAuthorId(int authorId) {
		List<Reimbursement> rs = new ArrayList<Reimbursement>();
		rs = rd.findByAuthorId(authorId);
		return rs;
	}
	
	public List<Reimbursement> getAllResolvedByResolverId(int resolverId) {
		List<Reimbursement> rs = new ArrayList<Reimbursement>();
		rs = rd.findByResolverId(resolverId);
		return rs;
	}
	
}

