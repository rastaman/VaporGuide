package com.bsalm.vaporguide.validation;

import java.util.List;

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
		
		//check nulls
		if (!(input.getUser_id() instanceof Integer))
			errors.rejectValue("user_id", "invalid type or null");
		if (!(input.getJuice_id() instanceof Integer))
			errors.rejectValue("juice_id", "invalid type or null");
		
		if (!(input.getRating() instanceof Integer))
			errors.rejectValue("rating", "invalid type or null");
		if (!(input.getReview() instanceof String))
			errors.rejectValue("review", "invalid type or null");
		
		if (!(input.getFlavor() instanceof Integer))
			errors.rejectValue("flavor", "invalid type or null");
		if (!(input.getVapor() instanceof Integer))
			errors.rejectValue("vapor", "invalid type or null");
		if (!(input.getThroat() instanceof Integer))
			errors.rejectValue("throat", "invalid type or null");
		if (!(input.getWorth() instanceof Integer))
			errors.rejectValue("worth", "invalid type or null");
	
		if (!(input.getVg() instanceof Double))
			errors.rejectValue("vg", "invalid type or null");
		if (!(input.getPg() instanceof Double))
			errors.rejectValue("pg", "invalid type or null");
		if (!(input.getNic() instanceof Double))
			errors.rejectValue("nic", "invalid type or null");
		if (!(input.getSteep() instanceof Double))
			errors.rejectValue("steep", "invalid type or null");
		
		if (!(input.getFlavorOneId() instanceof Integer))
			errors.rejectValue("flavorOneId", "invalid type or null");
		if (!(input.getFlavorTwoId() instanceof Integer))
			errors.rejectValue("flavorTwoId", "invalid type or null");
		if (!(input.getFlavorThreeId() instanceof Integer))
			errors.rejectValue("flavorThreeId", "invalid type or null");
		
		if(!(errors.getErrorCount() == 0)){
			return;
		}
		
		//bounds
		if (! integerBetween(1, 10, input.getRating()))
			errors.rejectValue("rating", "value out of bounds");
		if (! integerBetween(0, 1024, input.getReview().length()))
			errors.rejectValue("review", "length out of bounds");
		
		if (! integerBetween(1, 10, input.getFlavor()))
			errors.rejectValue("flavor", "value out of bounds");
		if (! integerBetween(1, 10, input.getVapor()))
			errors.rejectValue("vapor", "value out of bounds");
		if (! integerBetween(1, 10, input.getThroat()))
			errors.rejectValue("throat", "value out of bounds");
		if (! integerBetween(1, 10, input.getWorth()))
			errors.rejectValue("worth", "value out of bounds");
	
		if (! doubleBetween(0.0, 100.0, input.getVg()))
			errors.rejectValue("vg", "value out of bounds");
		if (! doubleBetween(0.0, 100.0, input.getPg()))
			errors.rejectValue("pg", "value out of bounds");
		if (! doubleBetween(0.0, 100.0, input.getNic()))
			errors.rejectValue("nic", "value out of bounds");
		if (! doubleBetween(0.0, 100.0, input.getSteep()))
			errors.rejectValue("steep", "value out of bounds");
		
		//TODO: Change to find CURRENT juice flavor count
		if (! integerBetween(1, 19, input.getFlavorOneId()))
			errors.rejectValue("flavorOneId", "value out of bounds");
		if (! integerBetween(1, 19, input.getFlavorTwoId()))
			errors.rejectValue("flavorTwoId", "value out of bounds");
		if (! integerBetween(1, 19, input.getFlavorThreeId()))
			errors.rejectValue("flavorThreeId", "value out of bounds");
		
		//passed validations - check db for duplicates
//		if(errors.getErrorCount() == 0){
//			List<JuiceReview> duplicateNames = juiceReviewService.findByUserIdAndJuiceId(input.getUser_id(), input.getJuice_id());
//
//			if(duplicateNames.size() > 0)
//				errors.rejectValue("name", "already exists."); //TODO change this to some meaningful message
//		}
	}
	
	private boolean integerBetween(int l, int r, int x)
	{
		return x >= l && x <= r;
	}
	
	private boolean doubleBetween(double l, double r, double x)
	{
		return x >= l && x <= r;
	}
}
