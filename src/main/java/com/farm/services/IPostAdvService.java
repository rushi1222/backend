package com.farm.services;

import java.util.List;

import com.farm.entity.PostAdvertisement;

public interface IPostAdvService {
	
	public List<PostAdvertisement> getAllAdv();
	public PostAdvertisement saveAllAdv(PostAdvertisement postAdvertisement);
	public void updateAdv(PostAdvertisement postAdvertisement, int cropId);
	public void deleteAdvById(int cropId);
	public PostAdvertisement findAdvById(int cropId);
	

}
