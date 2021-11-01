package com.farm.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.farm.entity.Complaint;
import com.farm.exception.ComplaintNotFoundException;
import com.farm.repository.IComplaintRepository;

@Service
public class ComplaintService implements IComplaintService {
	
	@Autowired
	IComplaintRepository repo;
	
	@Override
	public List<Complaint> getAllComplaints() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Complaint saveComplaints(Complaint complaint) {
		// TODO Auto-generated method stub
		Complaint newComplaints = repo.save(complaint);
		return newComplaints;
	}
	
	@Override
	public void updateComplaint(Complaint complaint, int complaintid) {
		// TODO Auto-generated method stub
		repo.updateComplaintById(complaint.getComplaint(),complaintid);
	}

	@Override
	public Complaint findComplaintById(int complaintid) {
		// TODO Auto-generated method stub
		Optional<Complaint> complaint = repo.findById(complaintid);

		if (complaint.isEmpty() || complaint == null) {
			throw new ComplaintNotFoundException("Complaint Not Found For The Given Complaint ID : " + complaintid);
		}
		return complaint.get();

	}
	
	@Override
	public void deleteComplaintById(int complaintid) {
		// TODO Auto-generated method stub
		repo.deleteById(complaintid);
	}
}
