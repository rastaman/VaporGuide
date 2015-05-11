package com.bsalm.vaporguide.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bsalm.vaporguide.entity.Shop;
import com.bsalm.vaporguide.exceptions.InvalidRequestException;
import com.bsalm.vaporguide.exceptions.ShopNotFoundException;
import com.bsalm.vaporguide.exceptions.ResourceNotFoundException;
import com.bsalm.vaporguide.services.ShopService;

@RestController
@RequestMapping(value="/shop")
public class ShopController {

	@Autowired
	private ShopService shopService;
	
//	@Autowired
//	private ShopValidator shopValidator;
//
//	@InitBinder
//	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(shopValidator);
//	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<Shop> getAllShops() {
		return shopService.findAll();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Shop shopListPage(@PathVariable Integer id) {
		return shopService.findById(id);
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public Shop createShop(@ModelAttribute @Valid Shop shop,
			BindingResult result) {

		//If there's validation errors
		if (result.hasErrors())
			throw new InvalidRequestException("Error creating shop", result);
		
		return shopService.create(shop);	
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public Shop editShop(@ModelAttribute Shop shop, @PathVariable Integer id,
			BindingResult result) {
		
		//If there's validation errors
		if (result.hasErrors())
			throw new InvalidRequestException("Error updating shop", result);

		//call update service
		Shop updatedShop;
		try {
			updatedShop = shopService.update(shop);
		} catch (ShopNotFoundException e) {
			throw new ResourceNotFoundException("Unable to update shop with ID = "+ id
					+". No such shop exists.");
		}

		return updatedShop;
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public Shop deleteShop(@PathVariable Integer id)
	{	
		//call delete service
		Shop deletedShop;
		try {
			deletedShop = shopService.delete(id);
		} catch (ShopNotFoundException e) {
			throw new ResourceNotFoundException("Unable to delete shop with ID = "+ id
					+". No such shop exists.");
		}

		return deletedShop;
	}

}
