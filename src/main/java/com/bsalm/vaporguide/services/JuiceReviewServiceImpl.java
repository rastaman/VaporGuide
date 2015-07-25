package com.bsalm.vaporguide.services;

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
	public JuiceReview create(JuiceReview juiceReview) {
		JuiceReview createdJuiceReview = juiceReview;
		return juiceReviewRepository.save(createdJuiceReview);
	}
	
	@Transactional
	public JuiceReview findById(int id) {
		return juiceReviewRepository.findOne(id);
	}
	
	@Transactional
	public List<JuiceReview> findByJuiceId(int id) {
		return juiceReviewRepository.findByJuiceId(id);
	}
	
	@Override
	public List<JuiceReview> findByUserId(int id) {
		return juiceReviewRepository.findByUserId(id);
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
	public List<JuiceReview> findAll() {
		return juiceReviewRepository.findAll();
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
		updatedJuiceReview.setWorth(juiceReview.getSteep());
		
//		updatedJuiceReview.setFlavorOne(juiceReview.getFlavorOne());
//		updatedJuiceReview.setFlavorTwo(juiceReview.getFlavorTwo());
//		updatedJuiceReview.setFlavorTwo(juiceReview.getFlavorThree());
		
		juiceReviewRepository.save(updatedJuiceReview);
		
		return updatedJuiceReview;
	}
}
