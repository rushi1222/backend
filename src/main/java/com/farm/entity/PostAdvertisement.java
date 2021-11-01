package com.farm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="postad_details")

public class PostAdvertisement {
	
	@Id
	private int cropId;
	private String cropName;
	private int requiredQuantity;
	private String postedby;
	private long contactno;
	
	@JsonIgnore    
	@OneToOne    
	private Supplier supplier;
	
	
	public PostAdvertisement() {
		
	}


	

	public long getContactno() {
		return contactno;
	}




	public void setContactno(long contactno) {
		this.contactno = contactno;
	}




	public PostAdvertisement(int cropId, String cropName, int requiredQuantity, String postedby, long contactno,
			Supplier supplier) {
		super();
		this.cropId = cropId;
		this.cropName = cropName;
		this.requiredQuantity = requiredQuantity;
		this.postedby = postedby;
		this.contactno = contactno;
		this.supplier = supplier;
	}




	public int getCropId() {
		return cropId;
	}


	public void setCropId(int cropId) {
		this.cropId = cropId;
	}


	public String getCropName() {
		return cropName;
	}


	public void setCropName(String cropName) {
		this.cropName = cropName;
	}


	public int getRequiredQuantity() {
		return requiredQuantity;
	}


	public void setRequiredQuantity(int requiredQuantity) {
		this.requiredQuantity = requiredQuantity;
	}


	public String getPostedby() {
		return postedby;
	}


	public void setPostedby(String postedby) {
		this.postedby = postedby;
	}


	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}


	@Override
	public String toString() {
		return "PostAdvertisement [cropId=" + cropId + ", cropName=" + cropName + ", requiredQuantity="
				+ requiredQuantity + ", postedby=" + postedby + ", contactno=" + contactno + ", supplier=" + supplier
				+ "]";
	}

}
