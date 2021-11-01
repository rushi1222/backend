package com.farm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "complaints")
public class Complaint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int complaintid;
	
	private String complaint;

	public Complaint()
	{
		
	}
	public Complaint(int complaintid, String complaint) {
		super();
		this.complaintid = complaintid;
		this.complaint = complaint;
	}

	public int getComplaintid() {
		return complaintid;
	}

	public void setComplaintid(int complaintid) {
		this.complaintid = complaintid;
	}

	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	@Override
	public String toString() {
		return "Complaint [complaintid=" + complaintid + ", complaint=" + complaint + "]";
	}
	
	


}
