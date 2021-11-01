package com.farm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.farm.entity.Supplier;
import com.farm.exception.SupplierNotFoundException;
import com.farm.repository.ISupplierRepository;

@Service
public class SupplierService implements ISupplierService {

	@Autowired
	ISupplierRepository suprepo;
	
	@Override 
	public List<Supplier> getAllSuppliers() {
		// TODO Auto-generated method stub
		return suprepo.findAll();
	}

	@Override 
	public Supplier saveSuppliers(Supplier supplier) {
		// TODO Auto-generated method stub
		Supplier newSuppliers = suprepo.save(supplier);
		return newSuppliers;
	}
	
	

	@Override 
	public Supplier findSupplierById(long supplierid) {
		// TODO Auto-generated method stub
		Optional<Supplier> supplier = suprepo.findById(supplierid);

		if (supplier.isEmpty() || supplier == null) {
			throw new SupplierNotFoundException("Supplier Not Found For The Given Supplier ID : " + supplierid);
		}
		return supplier.get();

	}
	
	@Override 
	public void deleteSupplierById(long supplierid) {
		// TODO Auto-generated method stub
		suprepo.deleteById(supplierid);
	}
	

	 
	    
	    
	    @Override    
	    public Supplier getSupplierById(long supplierid) {
	        // TODO Auto-generated method stub        
	    	return suprepo.findById(supplierid).get();
	    }
	    
	    
	    @Override
	    public void updateSupplier(Supplier supplier, long supplierid) {
	    // TODO Auto-generated method stub
	    	suprepo.updateSupplierById(supplier.getSuppliername(), supplier.getSupplieraddress(), supplier.getSupmobileno(),supplierid);
	    }

		@Override
		public void updateSuppliers(Supplier suppliers, long supplierid) {
			// TODO Auto-generated method stub
			suprepo.updateSupplierById(suppliers.getSuppliername(), suppliers.getSupplieraddress(), suppliers.getSupmobileno(),supplierid);
		}
	    
	    
	  
}
