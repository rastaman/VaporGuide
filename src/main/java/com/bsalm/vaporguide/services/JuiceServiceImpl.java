package com.bsalm.vaporguide.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bsalm.vaporguide.entity.Juice;
import com.bsalm.vaporguide.exceptions.JuiceNotFoundException;
import com.bsalm.vaporguide.repositories.JuiceRepository;

@Service
public class JuiceServiceImpl implements JuiceService {
	
	@Resource
	private JuiceRepository juiceRepository;

	@Transactional
	public Juice create(Juice juice) {
		Juice createdJuice = juice;
		return juiceRepository.save(createdJuice);
	}
	
	@Transactional
	public Juice findById(int id) {
		return juiceRepository.findOne(id);
	}
	
	@Transactional
	public List<Juice> findByName(String name) {
		//return juiceRepository.findByName(name);
		return null;
	}

	@Transactional(rollbackFor=JuiceNotFoundException.class)
	public Juice delete(int id) throws JuiceNotFoundException 
	{
		Juice deletedJuice = juiceRepository.findOne(id);
		
		if (deletedJuice == null)
			throw new JuiceNotFoundException();
		
		juiceRepository.delete(deletedJuice);
		return deletedJuice;
	}

	@Transactional
	public List<Juice> findAll() {
		return juiceRepository.findAll();
	}

	@Transactional(rollbackFor=JuiceNotFoundException.class)
	public Juice update(Juice juice) throws JuiceNotFoundException 
	{
		Juice updatedJuice = juiceRepository.findOne(juice.getId());
		
		if (updatedJuice == null)
			throw new JuiceNotFoundException();
		
		//set fields
		
		juiceRepository.save(updatedJuice);
		
		return updatedJuice;
	}
	
}
