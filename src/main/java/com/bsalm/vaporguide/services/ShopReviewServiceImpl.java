package com.bsalm.vaporguide.services;

import java.util.List;

import javax.annotation.Resource;

import org.joda.time.DateTime;
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
	public ShopReview findById(int id) {
		return shopReviewRepository.findOne(id);
	}
	
	@Override
	@Transactional
	public List<ShopReview> findByShopId(int id) {
		return shopReviewRepository.findByShopId(id);
	}
	
	@Override
	@Transactional
	public List<ShopReview> findByUserId(int id) {
		return shopReviewRepository.findByUserId(id);
	}
	
	@Override
	@Transactional
	public List<ShopReview> findByUserIdAndShopId(int userId, int shopId) {
		return shopReviewRepository.findByUserIdAndShopId(userId, shopId);
	}
	
	@Transactional
	public List<ShopReview> findAll() {
		return shopReviewRepository.findAll();
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
	public ShopReview create(ShopReview shopReview) throws ShopReviewNotFoundException {
		
		//check if user has already reviewed this shop - attempt update instead
		List<ShopReview> results = findByUserIdAndShopId(shopReview.getUser_id(), shopReview.getShop_id());
		if(results.size() > 0){
			shopReview.setId(results.get(0).getId()); //get the Id of the existing review and set it
			return update(shopReview);
		}
		
		shopReview.setUpdatedDate(DateTime.now());
		
		return shopReviewRepository.save(shopReview);
	}

	@Transactional(rollbackFor=ShopReviewNotFoundException.class)
	public ShopReview update(ShopReview shopReview) throws ShopReviewNotFoundException 
	{
		ShopReview updatedShopReview = shopReviewRepository.findOne(shopReview.getId());
		
		if (updatedShopReview == null)
			throw new ShopReviewNotFoundException();
	
		shopReview.setUpdatedDate(DateTime.now());
		
		return shopReviewRepository.save(shopReview);
	}
}
