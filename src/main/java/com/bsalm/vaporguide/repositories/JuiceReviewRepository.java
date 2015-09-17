package com.bsalm.vaporguide.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bsalm.vaporguide.entity.JuiceReview;

public interface JuiceReviewRepository extends JpaRepository<JuiceReview, Integer> {
	
	@Query("SELECT p FROM JuiceReview p WHERE p.juice_id = :juice_id")
	public List<JuiceReview> findByJuiceId(@Param("juice_id") int juice_id);
	
	@Query("SELECT p FROM JuiceReview p WHERE p.user_id = :user_id ORDER BY created_datetime DESC")
	public List<JuiceReview> findByUserId(@Param("user_id") int user_id);
	
	@Query("SELECT p FROM JuiceReview p WHERE p.user_id = :user_id AND p.juice_id = :juice_id")
	public List<JuiceReview> findByUserIdAndJuiceId(@Param("user_id") int user_id, @Param("juice_id") int juice_id);
	
}