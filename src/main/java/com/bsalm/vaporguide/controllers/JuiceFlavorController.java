package com.bsalm.vaporguide.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bsalm.vaporguide.entity.JuiceFlavor;
import com.bsalm.vaporguide.services.JuiceFlavorService;


@RestController
@RequestMapping(value="/juiceflavor")
public class JuiceFlavorController {

	@Autowired
	private JuiceFlavorService juiceFlavorService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<JuiceFlavor> getAllJuiceFlavors() {
		return juiceFlavorService.findAll();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public JuiceFlavor getJuiceFlavor(@PathVariable Integer id) {
		return juiceFlavorService.findById(id);
	}
}
