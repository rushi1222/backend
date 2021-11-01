package com.farm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "farming_tips")
public class FarmingTip {

	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tipid;
	
    private String fertilizers;
 
    private String crop;
    
    private String season;
    
    public FarmingTip()
    {
    }
    
    public FarmingTip(int tipid, String fertilizers, String crop, String season) {
        super();
        this.tipid = tipid;
        this.fertilizers = fertilizers;
        this.crop = crop;
        this.season = season;
    }
    
    
    public int getTipid() {
        return tipid;
    }
    public void setTipid(int tipid) {
        this.tipid = tipid;
    }
    public String getFertilizers() {
        return fertilizers;
    }
    public void setFertilizers(String fertilizers) {
        this.fertilizers = fertilizers;
    }
    public String getCrop() {
        return crop;
    }
    public void setCrop(String crop) {
        this.crop = crop;
    }
    public String getSeason() {
        return season;
    }
    public void setSeason(String season) {
        this.season = season;
    }
    
    
    @Override    public String toString() {
        return "FarmingTip [tipid=" + tipid + ", fertilizers=" + fertilizers + ", crop=" + crop + ", season=" + season                + "]";
    }
}
