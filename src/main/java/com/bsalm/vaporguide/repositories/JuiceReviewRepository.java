package com.bsalm.vaporguide.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bsalm.vaporguide.entity.JuiceReview;

public interface JuiceReviewRepository extends JpaRepository<JuiceReview, Integer> {

//	@Query("SELECT p FROM Album p WHERE LOWER(p.name) = LOWER(:name) and p.artist_id = :artistId")
//	public List<Album> findByName(@Param("name") String name, @Param("artistId") int artistId);
	
	@Query("SELECT p FROM JuiceReview p WHERE p.juice_id = :juice_id")
	public List<JuiceReview> findByJuiceId(@Param("juice_id") int juice_id);
	
}