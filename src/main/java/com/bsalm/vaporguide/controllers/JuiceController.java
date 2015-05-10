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

import com.bsalm.vaporguide.entity.Juice;
import com.bsalm.vaporguide.exceptions.InvalidRequestException;
import com.bsalm.vaporguide.exceptions.JuiceNotFoundException;
import com.bsalm.vaporguide.exceptions.ResourceNotFoundException;
import com.bsalm.vaporguide.services.JuiceService;

@RestController
@RequestMapping(value="/juice")
public class JuiceController {

	@Autowired
	private JuiceService juiceService;
	
//	@Autowired
//	private JuiceValidator juiceValidator;
//
//	@InitBinder
//	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(juiceValidator);
//	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<Juice> getAllJuices() {
		return juiceService.findAll();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Juice juiceListPage(@PathVariable Integer id) {
		return juiceService.findById(id);
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public Juice createJuice(@ModelAttribute @Valid Juice juice,
			BindingResult result) {

		//If there's validation errors
		if (result.hasErrors())
			throw new InvalidRequestException("Error creating juice", result);
		
		return juiceService.create(juice);	
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public Juice editJuice(@ModelAttribute Juice juice, @PathVariable Integer id,
			BindingResult result) {
		
		//If there's validation errors
		if (result.hasErrors())
			throw new InvalidRequestException("Error updating juice", result);

		//call update service
		Juice updatedJuice;
		try {
			updatedJuice = juiceService.update(juice);
		} catch (JuiceNotFoundException e) {
			throw new ResourceNotFoundException("Unable to update juice with ID = "+ id
					+". No such juice exists.");
		}

		return updatedJuice;
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public Juice deleteJuice(@PathVariable Integer id)
	{	
		//call delete service
		Juice deletedJuice;
		try {
			deletedJuice = juiceService.delete(id);
		} catch (JuiceNotFoundException e) {
			throw new ResourceNotFoundException("Unable to delete juice with ID = "+ id
					+". No such juice exists.");
		}

		return deletedJuice;
	}

}
