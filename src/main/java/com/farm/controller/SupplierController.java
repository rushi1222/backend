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

import com.farm.entity.Farmer;
import com.farm.entity.LoginDetails;
import com.farm.entity.Registration;
import com.farm.entity.Role;
import com.farm.entity.Supplier;
import com.farm.services.ILoginDetailsService;
import com.farm.services.IFarmerService;
import com.farm.services.ISupplierService;

@RestController
@RequestMapping("/farm")
@CrossOrigin
public class SupplierController {
	
		List<Supplier> suppliers = new ArrayList<Supplier>();
		
		@Autowired
		ISupplierService supplierService;
		
		@Autowired 
		ILoginDetailsService adminLoginService; 
		
		@Autowired 
		IFarmerService farmerService; 
		
		// TO VIEW ALL SUPPLIERS 
			@GetMapping(path = "/suppliers", produces = { "application/json" })
			public ResponseEntity<List<Supplier>> getSuppliers() {
				List<Supplier> supplierList = supplierService.getAllSuppliers();
				return new ResponseEntity<List<Supplier>>(supplierList, HttpStatus.OK);
			}
			
		

		// TO REMOVE A SUPPLIER	
			@DeleteMapping("/suppliers/delete/{supplierid}")
			public ResponseEntity<List<Supplier>> deleteSupplierById(@PathVariable("supplierid") long supplierid) {
				Supplier suppliers = supplierService.findSupplierById(supplierid);

				if (suppliers == null) {
					return new ResponseEntity<List<Supplier>>(HttpStatus.NOT_FOUND);
				} else {
					supplierService.deleteSupplierById(supplierid);
					adminLoginService.deleteLoginDetailsById(supplierid);
				}
				List<Supplier> suppliersList = supplierService.getAllSuppliers();
				return new ResponseEntity<List<Supplier>>(suppliersList, HttpStatus.OK);
			}
			
			
			
			
			// TO GET SUPPLIER DETAILS WHO LOGGED IN
			@GetMapping(path = "/getsupplier/{supplierid}", produces = { "application/json" })
			public ResponseEntity<Supplier> getSupplier(@PathVariable("supplierid")long supplierid) {
				Supplier supplier = supplierService.getSupplierById(supplierid);
			System.out.println("fetching user details....");
			return new ResponseEntity<Supplier>(supplier, HttpStatus.OK);
			}
			
			// TO UPDATE A SUPPLIER DETAILS WHO LOGGED IN
			@PutMapping(path = "/supplier/update/{supplierid}", consumes = { "application/json" })
			public ResponseEntity<Supplier> updateSupplier(@PathVariable("supplierid") long supplierid, @RequestBody Supplier supplier) {
	
				supplierService.updateSupplier(supplier, supplierid);
				Supplier sup = supplierService.getSupplierById(supplierid);

			 return new ResponseEntity<Supplier>(sup, HttpStatus.OK);
			}
			
			
}
