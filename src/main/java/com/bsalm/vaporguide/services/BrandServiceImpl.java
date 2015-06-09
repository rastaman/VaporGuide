package com.bsalm.vaporguide.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bsalm.vaporguide.entity.Brand;
import com.bsalm.vaporguide.entity.Juice;
import com.bsalm.vaporguide.entity.JuiceFlavor;
import com.bsalm.vaporguide.repositories.BrandRepository;
import com.bsalm.vaporguide.repositories.JuiceFlavorRepository;

@Service
public class BrandServiceImpl implements BrandService {
	
	@Resource
	private BrandRepository brandRepository;
	
	@Transactional
	public Brand findById(int id) {
		return brandRepository.findOne(id);
	}

	@Transactional
	public List<Brand> findAll() {
		return brandRepository.findAll();
	}
	
	@Transactional
	public List<Juice> findAllJuice(int brandId) {
		return brandRepository.findAllJuice(brandId);
	}
	
}
