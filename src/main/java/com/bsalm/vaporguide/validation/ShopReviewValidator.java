package com.bsalm.vaporguide.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bsalm.vaporguide.entity.ShopReview;
import com.bsalm.vaporguide.services.ShopReviewService;

@Component
public class ShopReviewValidator implements Validator {

	@Autowired
	private ShopReviewService shopReviewService;

	@Override
	public boolean supports(Class<?> clazz) {
		return ShopReview.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ShopReview input = (ShopReview) target;

		//required fields
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field is empty.");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genre", "field is empty.");
		
		//check nulls
		if (!(input.getUser_id() instanceof Integer))
			errors.rejectValue("user_id", "invalid type or null");
		if (!(input.getShop_id() instanceof Integer))
			errors.rejectValue("shop_id", "invalid type or null");
		
		if (!(input.getRating() instanceof Integer))
			errors.rejectValue("rating", "invalid type or null");
		if (!(input.getReview() instanceof String))
			errors.rejectValue("review", "invalid type or null");
		
		if (!(input.getAtmosphere() instanceof Integer))
			errors.rejectValue("atmosphere", "invalid type or null");
		if (!(input.getStaff() instanceof Integer))
			errors.rejectValue("staff", "invalid type or null");
		if (!(input.getStock() instanceof Integer))
			errors.rejectValue("stock", "invalid type or null");
		if (!(input.getAdvanced() instanceof Boolean))
			errors.rejectValue("advanced", "invalid type or null");
		if (!(input.getBeginner() instanceof Boolean))
			errors.rejectValue("beginner", "invalid type or null");
		
		if(errors.getErrorCount() != 0){
			return;
		}
		
		//bounds
		if (! integerBetween(1, 10, input.getRating()))
			errors.rejectValue("rating", "value out of bounds");
		if (! integerBetween(0, 4096, input.getReview().length()))
			errors.rejectValue("review", "length out of bounds");
		
		if (! integerBetween(1, 10, input.getAtmosphere()))
			errors.rejectValue("atmosphere", "value out of bounds");
		if (! integerBetween(1, 10, input.getStaff()))
			errors.rejectValue("staff", "value out of bounds");
		if (! integerBetween(1, 10, input.getStock()))
			errors.rejectValue("stock", "value out of bounds");
	
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
