package com.bsalm.vaporguide.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bsalm.vaporguide.entity.Brand;
import com.bsalm.vaporguide.entity.Juice;
import com.bsalm.vaporguide.entity.JuiceFlavor;
import com.bsalm.vaporguide.services.BrandService;
import com.bsalm.vaporguide.services.JuiceFlavorService;


@RestController
@RequestMapping(value="/brand")
public class BrandController {

	@Autowired
	private BrandService brandService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<Brand> getAllBrands() {
		return brandService.findAll();
	}
	
	@RequestMapping(value="/juice/{brand_id}", method=RequestMethod.GET)
	public List<Juice> getBrandsJuice(@PathVariable Integer brand_id) {
		return brandService.findAllJuice(brand_id);
	}

	//TODO function to get brands that have a juice
	
	//TODO function to get brands that have hardware
	
	//TODO function to get brands that have 'other'

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Brand getBrand(@PathVariable Integer id) {
		return brandService.findById(id);
	}
}
