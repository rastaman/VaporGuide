package com.bsalm.vaporguide.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bsalm.vaporguide.entity.ShopReview;
import com.bsalm.vaporguide.exceptions.InvalidRequestException;
import com.bsalm.vaporguide.exceptions.ShopReviewNotFoundException;
import com.bsalm.vaporguide.exceptions.ResourceNotFoundException;
import com.bsalm.vaporguide.services.ShopReviewService;
import com.bsalm.vaporguide.validation.ShopReviewValidator;

@RestController
@RequestMapping(value="/shopreview")
public class ShopReviewController {

	@Autowired
	private ShopReviewService shopReviewService;
	
	@Autowired
	private ShopReviewValidator shopReviewValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(shopReviewValidator);
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<ShopReview> getAllShopReviews() {
		return shopReviewService.findAll();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ShopReview getShopReview(@PathVariable Integer id) {
		return shopReviewService.findById(id);
	}
	
	@RequestMapping(value="/shop/{id}", method=RequestMethod.GET)
	public List<ShopReview> getShopReviewsByShopId(@PathVariable Integer id) {
		return shopReviewService.findByShopId(id);
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public List<ShopReview> getShopReviewsByUserId(@PathVariable Integer id) {
		return shopReviewService.findByUserId(id);
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public ShopReview createShopReview(@ModelAttribute @Valid ShopReview shopReview,
			BindingResult result) {

		//If there's validation errors
		if (result.hasErrors())
			throw new InvalidRequestException("Error creating shopReview", result);
		
		//call update service
		ShopReview createdShopReview;
		try {
			createdShopReview = shopReviewService.create(shopReview);
		} catch (ShopReviewNotFoundException e) {
			throw new ResourceNotFoundException("Unable to create shopReview - "
					+ "Error retrieving shop for update.");
		}

		return createdShopReview;
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ShopReview editShopReview(@ModelAttribute @Valid ShopReview shopReview, @PathVariable Integer id,
			BindingResult result) {
		
		//If there's validation errors
		if (result.hasErrors())
			throw new InvalidRequestException("Error updating shopReview", result);

		//call update service
		ShopReview updatedShopReview;
		try {
			updatedShopReview = shopReviewService.update(shopReview);
		} catch (ShopReviewNotFoundException e) {
			throw new ResourceNotFoundException("Unable to update shopReview with ID = "+ id
					+". No such shopReview exists.");
		}

		return updatedShopReview;
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ShopReview deleteShopReview(@PathVariable Integer id)
	{	
		//call delete service
		ShopReview deletedShopReview;
		try {
			deletedShopReview = shopReviewService.delete(id);
		} catch (ShopReviewNotFoundException e) {
			throw new ResourceNotFoundException("Unable to delete shopReview with ID = "+ id
					+". No such shopReview exists.");
		}

		return deletedShopReview;
	}

}
