package com.farm.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "supplier_details")
public class Supplier {

	
	@Id
	private long supplierid;
	
	private String suppliername;
	
	private String supplieraddress;
	
	private long supmobileno;
	
	
	
	public Supplier() {

	}



	public Supplier(long supplierid, String suppliername, String supplieraddress, long supmobileno) {
		super();
		this.supplierid = supplierid;
		this.suppliername = suppliername;
		this.supplieraddress = supplieraddress;
		this.supmobileno = supmobileno;
	}



	public long getSupplierid() {
		return supplierid;
	}



	public void setSupplierid(long supplierid) {
		this.supplierid = supplierid;
	}



	public String getSuppliername() {
		return suppliername;
	}



	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}



	public String getSupplieraddress() {
		return supplieraddress;
	}



	public void setSupplieraddress(String supplieraddress) {
		this.supplieraddress = supplieraddress;
	}



	public long getSupmobileno() {
		return supmobileno;
	}



	public void setSupmobileno(long supmobileno) {
		this.supmobileno = supmobileno;
	}



	@Override
	public String toString() {
		return "Supplier [supplierid=" + supplierid + ", suppliername=" + suppliername + ", supplieraddress="
				+ supplieraddress + ", supmobileno=" + supmobileno + "]";
	}

	

}
