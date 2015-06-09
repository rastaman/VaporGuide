package com.bsalm.vaporguide.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bsalm.vaporguide.entity.JuiceReview;
import com.bsalm.vaporguide.services.JuiceReviewService;

@Component
public class JuiceReviewValidator implements Validator {

	@Autowired
	private JuiceReviewService juiceReviewService;

	@Override
	public boolean supports(Class<?> clazz) {
		return JuiceReview.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		JuiceReview input = (JuiceReview) target;

		//required fields
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field is empty.");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genre", "field is empty.");
		
		//bounds
		if (! integerBetween(1, 10, input.getRating()))
			errors.rejectValue("rating", "value out of bounds");
		
		if (! integerBetween(0, 128, input.getReview().length()))
			errors.rejectValue("review", "length out of bounds");
		
		if (! integerBetween(1, 10, input.getFlavor()))
			errors.rejectValue("flavor", "value out of bounds");
		if (! integerBetween(1, 10, input.getVapor()))
			errors.rejectValue("vapor", "value out of bounds");
		if (! integerBetween(1, 10, input.getThroat()))
			errors.rejectValue("throat", "value out of bounds");
		if (! integerBetween(1, 10, input.getWorth()))
			errors.rejectValue("worth", "value out of bounds");
	
		if (! integerBetween(1, 10, input.getVg()))
			errors.rejectValue("vg", "value out of bounds");
		if (! integerBetween(1, 10, input.getPg()))
			errors.rejectValue("pg", "value out of bounds");
		if (! integerBetween(1, 10, input.getNic()))
			errors.rejectValue("nic", "value out of bounds");
		if (! integerBetween(1, 1825, input.getSteep()))
			errors.rejectValue("steep", "value out of bounds");
		
//		input.getFlavorOne();
//		input.getFlavorTwo();
//		input.getFlavorThree();
		
		//passed validations - check db for duplicates
//		if(errors.getErrorCount() == 0){
//			List<JuiceReview> duplicateNames = juiceReviewService.findByName(input.getName());
//
//			if(duplicateNames.size() > 0)
//				errors.rejectValue("name", "already exists.");
//		}
	}
	
	private boolean integerBetween(int l, int r, int x)
	{
		return x >= l && x <= r;
	}
}
