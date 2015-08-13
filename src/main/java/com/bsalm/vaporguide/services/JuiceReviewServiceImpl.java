package com.bsalm.vaporguide.services;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bsalm.vaporguide.entity.JuiceReview;
import com.bsalm.vaporguide.exceptions.JuiceReviewNotFoundException;
import com.bsalm.vaporguide.repositories.JuiceReviewRepository;

@Service
public class JuiceReviewServiceImpl implements JuiceReviewService {
	
	@Resource
	private JuiceReviewRepository juiceReviewRepository;
	
	@Transactional
	public JuiceReview findById(int id) {
		return juiceReviewRepository.findOne(id);
	}
	
	@Override
	@Transactional
	public List<JuiceReview> findByJuiceId(int id) {
		return juiceReviewRepository.findByJuiceId(id);
	}
	
	@Override
	@Transactional
	public List<JuiceReview> findByUserId(int id) {
		return juiceReviewRepository.findByUserId(id);
	}
	
	@Override
	@Transactional
	public List<JuiceReview> findByUserIdAndJuiceId(int userId, int juiceId) {
		return juiceReviewRepository.findByUserIdAndJuiceId(userId, juiceId);
	}
	
	@Transactional
	public List<JuiceReview> findAll() {
		return juiceReviewRepository.findAll();
	}
	
	@Transactional(rollbackFor=JuiceReviewNotFoundException.class)
	public JuiceReview delete(int id) throws JuiceReviewNotFoundException 
	{
		JuiceReview deletedJuiceReview = juiceReviewRepository.findOne(id);
		
		if (deletedJuiceReview == null)
			throw new JuiceReviewNotFoundException();
		
		juiceReviewRepository.delete(deletedJuiceReview);
		return deletedJuiceReview;
	}
	
	@Transactional
	public JuiceReview create(JuiceReview juiceReview) throws JuiceReviewNotFoundException {
		
		//check if user has already reviewed this juice - attempt update instead
		List<JuiceReview> results = findByUserIdAndJuiceId(juiceReview.getUser_id(), juiceReview.getJuice_id());
		if(results.size() > 0){
			juiceReview.setId(results.get(0).getId()); //get the Id of the existing review and set it
			return update(juiceReview);
		}
		
		JuiceReview createdJuiceReview = juiceReview;
		createdJuiceReview = trimData(createdJuiceReview);
		
		return juiceReviewRepository.save(createdJuiceReview);
	}

	@Transactional(rollbackFor=JuiceReviewNotFoundException.class)
	public JuiceReview update(JuiceReview juiceReview) throws JuiceReviewNotFoundException 
	{
		JuiceReview updatedJuiceReview = juiceReviewRepository.findOne(juiceReview.getId());
		
		if (updatedJuiceReview == null)
			throw new JuiceReviewNotFoundException();
		
		updatedJuiceReview.setRating(juiceReview.getRating());
		updatedJuiceReview.setReview(juiceReview.getReview());
		
		updatedJuiceReview.setFlavor(juiceReview.getFlavor());
		updatedJuiceReview.setVapor(juiceReview.getVapor());
		updatedJuiceReview.setThroat(juiceReview.getThroat());
		updatedJuiceReview.setWorth(juiceReview.getWorth());
		
		updatedJuiceReview.setVg(juiceReview.getVg());
		updatedJuiceReview.setPg(juiceReview.getPg());
		updatedJuiceReview.setNic(juiceReview.getNic());
		updatedJuiceReview.setSteep(juiceReview.getSteep());
		
		updatedJuiceReview.setFlavorOneId(juiceReview.getFlavorOneId());
		updatedJuiceReview.setFlavorTwoId(juiceReview.getFlavorTwoId());
		updatedJuiceReview.setFlavorThreeId(juiceReview.getFlavorThreeId());
		
		juiceReviewRepository.save(updatedJuiceReview);
		
		return updatedJuiceReview;
	}
	
	private JuiceReview trimData(JuiceReview inputReview)
	{
		//round decimals
		inputReview.setVg(roundDecimal(inputReview.getVg()));
		inputReview.setPg(roundDecimal(inputReview.getPg()));
		inputReview.setNic(roundDecimal(inputReview.getNic()));
		inputReview.setSteep(roundDecimal(inputReview.getSteep()));
		
		return inputReview;
	}
	
	private double roundDecimal(double inputNumber){
		return (double) Math.round(inputNumber * 10)/10 ;
	}
}
