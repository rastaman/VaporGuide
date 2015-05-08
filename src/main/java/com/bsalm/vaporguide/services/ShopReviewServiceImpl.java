package com.bsalm.vaporguide.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bsalm.vaporguide.entity.ShopReview;
import com.bsalm.vaporguide.exceptions.ShopReviewNotFoundException;
import com.bsalm.vaporguide.repositories.ShopReviewRepository;

@Service
public class ShopReviewServiceImpl implements ShopReviewService {
	
	@Resource
	private ShopReviewRepository shopReviewRepository;

	@Transactional
	public ShopReview create(ShopReview shopReview) {
		ShopReview createdShopReview = shopReview;
		return shopReviewRepository.save(createdShopReview);
	}
	
	@Transactional
	public ShopReview findById(int id) {
		return shopReviewRepository.findOne(id);
	}
	
	@Transactional
	public List<ShopReview> findByName(String name) {
		//return shopReviewRepository.findByName(name);
		return null;
	}

	@Transactional(rollbackFor=ShopReviewNotFoundException.class)
	public ShopReview delete(int id) throws ShopReviewNotFoundException 
	{
		ShopReview deletedShopReview = shopReviewRepository.findOne(id);
		
		if (deletedShopReview == null)
			throw new ShopReviewNotFoundException();
		
		shopReviewRepository.delete(deletedShopReview);
		return deletedShopReview;
	}

	@Transactional
	public List<ShopReview> findAll() {
		return shopReviewRepository.findAll();
	}

	@Transactional(rollbackFor=ShopReviewNotFoundException.class)
	public ShopReview update(ShopReview shopReview) throws ShopReviewNotFoundException 
	{
		ShopReview updatedShopReview = shopReviewRepository.findOne(shopReview.getId());
		
		if (updatedShopReview == null)
			throw new ShopReviewNotFoundException();
		
		//set fields here
		
		shopReviewRepository.save(updatedShopReview);
		
		return updatedShopReview;
	}
	
}
