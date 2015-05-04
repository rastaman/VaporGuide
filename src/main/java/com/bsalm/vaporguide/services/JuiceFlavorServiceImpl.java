package com.bsalm.vaporguide.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bsalm.vaporguide.entity.JuiceFlavor;
import com.bsalm.vaporguide.repositories.JuiceFlavorRepository;

@Service
public class JuiceFlavorServiceImpl implements JuiceFlavorService {
	
	@Resource
	private JuiceFlavorRepository juiceFlavorRepository;
	
	@Transactional
	public JuiceFlavor findById(int id) {
		return juiceFlavorRepository.findOne(id);
	}

	@Transactional
	public List<JuiceFlavor> findAll() {
		return juiceFlavorRepository.findAll();
	}
	
}
