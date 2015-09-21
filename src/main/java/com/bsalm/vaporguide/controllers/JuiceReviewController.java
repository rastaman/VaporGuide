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

import com.bsalm.vaporguide.entity.JuiceReview;
import com.bsalm.vaporguide.exceptions.InvalidRequestException;
import com.bsalm.vaporguide.exceptions.JuiceReviewNotFoundException;
import com.bsalm.vaporguide.exceptions.ResourceNotFoundException;
import com.bsalm.vaporguide.services.JuiceReviewService;
import com.bsalm.vaporguide.validation.JuiceReviewValidator;

@RestController
@RequestMapping(value="/juicereview")
public class JuiceReviewController {

	@Autowired
	private JuiceReviewService juiceReviewService;
	
	@Autowired
	private JuiceReviewValidator juiceReviewValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(juiceReviewValidator);
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<JuiceReview> getAllJuiceReviews() {
		return juiceReviewService.findAll();
	} 

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public JuiceReview getJuiceReview(@PathVariable Integer id) {
		return juiceReviewService.findById(id);
	}
	
	@RequestMapping(value="/juice/{id}", method=RequestMethod.GET)
	public List<JuiceReview> getJuiceReviewsByJuiceId(@PathVariable Integer id) {
		return juiceReviewService.findByJuiceId(id);
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public List<JuiceReview> getJuiceReviewsByUserId(@PathVariable Integer id) {
		return juiceReviewService.findByUserId(id);
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public JuiceReview createJuiceReview(@ModelAttribute @Valid JuiceReview juiceReview,
			BindingResult result) {

		//If there's validation errors
		if (result.hasErrors())
			throw new InvalidRequestException("Error creating juiceReview", result);
		
		//call update service
		JuiceReview createdJuiceReview;
		try {
			createdJuiceReview = juiceReviewService.create(juiceReview);
		} catch (JuiceReviewNotFoundException e) {
			throw new ResourceNotFoundException("Unable to create juiceReview - "
					+ "Error retrieving juice for update.");
		}

		return createdJuiceReview;
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public JuiceReview editJuiceReview(@ModelAttribute @Valid JuiceReview juiceReview, @PathVariable Integer id,
			BindingResult result) {
		
		//If there's validation errors
		if (result.hasErrors())
			throw new InvalidRequestException("Error updating juiceReview", result);

		//call update service
		JuiceReview updatedJuiceReview;
		try {
			updatedJuiceReview = juiceReviewService.update(juiceReview);
		} catch (JuiceReviewNotFoundException e) {
			throw new ResourceNotFoundException("Unable to update juiceReview with ID = "+ id
					+". No such juiceReview exists.");
		}

		return updatedJuiceReview;
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public JuiceReview deleteJuiceReview(@PathVariable Integer id)
	{	
		//call delete service
		JuiceReview deletedJuiceReview;
		try {
			deletedJuiceReview = juiceReviewService.delete(id);
		} catch (JuiceReviewNotFoundException e) {
			throw new ResourceNotFoundException("Unable to delete juiceReview with ID = "+ id
					+". No such juiceReview exists.");
		}

		return deletedJuiceReview;
	}

}
