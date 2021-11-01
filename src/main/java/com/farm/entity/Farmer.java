package com.farm.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "farmer_details")
public class Farmer {

	
	@Id
	private long farmerid;
	
	private String farmername;
	
	private String farmeraddress;
	
	private long farmmobileno;
	
	
	public Farmer() {

	}


	public Farmer(long farmerid, String farmername, String farmeraddress, long farmmobileno) {
		super();
		this.farmerid = farmerid;
		this.farmername = farmername;
		this.farmeraddress = farmeraddress;
		this.farmmobileno = farmmobileno;
	}


	public long getFarmerid() {
		return farmerid;
	}


	public void setFarmerid(long farmerid) {
		this.farmerid = farmerid;
	}


	public String getFarmername() {
		return farmername;
	}


	public void setFarmername(String farmername) {
		this.farmername = farmername;
	}


	public String getFarmeraddress() {
		return farmeraddress;
	}


	public void setFarmeraddress(String farmeraddress) {
		this.farmeraddress = farmeraddress;
	}


	public long getFarmmobileno() {
		return farmmobileno;
	}


	public void setFarmmobileno(long farmmobileno) {
		this.farmmobileno = farmmobileno;
	}


	@Override
	public String toString() {
		return "Farmer [farmerid=" + farmerid + ", farmername=" + farmername + ", farmeraddress=" + farmeraddress
				+ ", farmmobileno=" + farmmobileno + "]";
	}

}
