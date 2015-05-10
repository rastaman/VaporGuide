package com.bsalm.vaporguide.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bsalm.vaporguide.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
	
}