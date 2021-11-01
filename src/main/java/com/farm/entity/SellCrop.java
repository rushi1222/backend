package com.farm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "sell_crops")
public class SellCrop {

	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sellcropid;
	
	private String soldby;
	
	private String cropname;
	
	private float quantity;
	
	private float price;
	
	@JsonIgnore    
	@OneToOne    
	private Farmer farmer;
	
	
	public SellCrop() {
		
	}


	public SellCrop(int sellcropid, String soldby, String cropname, float quantity, float price, Farmer farmer) {
		super();
		this.sellcropid = sellcropid;
		this.soldby = soldby;
		this.cropname = cropname;
		this.quantity = quantity;
		this.price = price;
		this.farmer = farmer;
	}


	public int getSellcropid() {
		return sellcropid;
	}


	public void setSellcropid(int sellcropid) {
		this.sellcropid = sellcropid;
	}


	public String getSoldby() {
		return soldby;
	}


	public void setSoldby(String soldby) {
		this.soldby = soldby;
	}


	public String getCropname() {
		return cropname;
	}


	public void setCropname(String cropname) {
		this.cropname = cropname;
	}


	public float getQuantity() {
		return quantity;
	}


	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public Farmer getFarmer() {
		return farmer;
	}


	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}


	@Override
	public String toString() {
		return "SellCrop [sellcropid=" + sellcropid + ", soldby=" + soldby + ", cropname=" + cropname + ", quantity="
				+ quantity + ", price=" + price + ", farmer=" + farmer + "]";
	}
	
}
