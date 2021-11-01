package com.farm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farm.entity.Complaint;
import com.farm.services.IComplaintService;

@RestController
@RequestMapping("/farm")
@CrossOrigin
public class ComplaintController {

	List<Complaint> complaints = new ArrayList<Complaint>();
	
	@Autowired
	IComplaintService complaintService;
	
	// TO VIEW ALL COMPLAINTS 
		@GetMapping(path = "/complaints", produces = { "application/json" })
		public ResponseEntity<List<Complaint>> getComplaints() {
			List<Complaint> complaintList = complaintService.getAllComplaints();
			return new ResponseEntity<List<Complaint>>(complaintList, HttpStatus.OK);
		}
		
	// TO ADD A COMPLAINT
		@PostMapping(path = "/complaints", consumes = { "application/json" })
		public ResponseEntity<Complaint> saveComplaints(@RequestBody Complaint complaint) {

			Complaint newComplaint = complaintService.saveComplaints(complaint);

			return new ResponseEntity<Complaint>(newComplaint, HttpStatus.OK);

		}
		
		// TO UPDATE A COMPLAINT	
		@PutMapping(path = "/complaints/update/{complaintid}", consumes = { "application/json" })
		public ResponseEntity<List<Complaint>> updateComplaint(@PathVariable("complaintid") int complaintid, @RequestBody Complaint complaints)
		{
			complaintService.updateComplaint(complaints, complaintid);
			List<Complaint> complaintList = complaintService.getAllComplaints();

			return new ResponseEntity<List<Complaint>>(complaintList, HttpStatus.OK);
		}

		// TO DELETE A COMPLAINT	
		@DeleteMapping("/complaints/delete/{complaintid}")
		public ResponseEntity<List<Complaint>> deleteComplaintById(@PathVariable("complaintid") int complaintid) {
			Complaint complaints = complaintService.findComplaintById(complaintid);

			if (complaints == null) {
				return new ResponseEntity<List<Complaint>>(HttpStatus.NOT_FOUND);
			} else {
				complaintService.deleteComplaintById(complaintid);
			}
			List<Complaint> complaintsList = complaintService.getAllComplaints();
			return new ResponseEntity<List<Complaint>>(complaintsList, HttpStatus.OK);
		}


	
}
