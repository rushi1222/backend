package com.farm.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.farm.entity.Complaint;

@Service
public interface IComplaintService {

	public List<Complaint> getAllComplaints();
	public Complaint saveComplaints(Complaint complaint);
	public void updateComplaint(Complaint complaint, int complaintid);
	public Complaint findComplaintById(int complaintid);
	public void deleteComplaintById(int complaintid);
}
