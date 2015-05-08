package com.bsalm.vaporguide.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bsalm.vaporguide.entity.Shop;
import com.bsalm.vaporguide.exceptions.ShopNotFoundException;
import com.bsalm.vaporguide.repositories.ShopRepository;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Resource
	private ShopRepository shopRepository;

	@Transactional
	public Shop create(Shop shop) {
		Shop createdShop = shop;
		return shopRepository.save(createdShop);
	}
	
	@Transactional
	public Shop findById(int id) {
		return shopRepository.findOne(id);
	}
	
	@Transactional
	public List<Shop> findByName(String name) {
		//return shopRepository.findByName(name);
		return null;
	}

	@Transactional(rollbackFor=ShopNotFoundException.class)
	public Shop delete(int id) throws ShopNotFoundException 
	{
		Shop deletedShop = shopRepository.findOne(id);
		
		if (deletedShop == null)
			throw new ShopNotFoundException();
		
		shopRepository.delete(deletedShop);
		return deletedShop;
	}

	@Transactional
	public List<Shop> findAll() {
		return shopRepository.findAll();
	}

	@Transactional(rollbackFor=ShopNotFoundException.class)
	public Shop update(Shop shop) throws ShopNotFoundException 
	{
		Shop updatedShop = shopRepository.findOne(shop.getId());
		
		if (updatedShop == null)
			throw new ShopNotFoundException();
		
		//set feields here
		
		shopRepository.save(updatedShop);
		
		return updatedShop;
	}
	
}
