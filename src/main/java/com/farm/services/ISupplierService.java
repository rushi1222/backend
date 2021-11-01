package com.farm.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.farm.entity.Supplier;

@Service
public interface ISupplierService {

	public List<Supplier> getAllSuppliers();
	public Supplier saveSuppliers(Supplier supplier);
	public void updateSupplier(Supplier supplier, long supplierid);
	public Supplier findSupplierById(long supplierid);
	public void deleteSupplierById(long supplierid);
	public void updateSuppliers(Supplier suppliers, long supplierid);
	
	// public Supplier validateLogin(String supusername, String suppassword);
	 public Supplier getSupplierById(long supplierid);
	
}
