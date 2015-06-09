package com.bsalm.vaporguide.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bsalm.vaporguide.entity.Brand;
import com.bsalm.vaporguide.entity.Juice;
import com.bsalm.vaporguide.entity.JuiceReview;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
	
	@Query("SELECT p FROM Juice p WHERE p.brand_id = :brand_id")
	public List<Juice> findAllJuice(@Param("brand_id") int brand_id);
	
}