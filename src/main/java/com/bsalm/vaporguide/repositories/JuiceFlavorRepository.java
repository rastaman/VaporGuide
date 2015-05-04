package com.bsalm.vaporguide.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bsalm.vaporguide.entity.JuiceFlavor;

public interface JuiceFlavorRepository extends JpaRepository<JuiceFlavor, Integer> {
	
}