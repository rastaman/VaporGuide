package com.bsalm.vaporguide.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bsalm.vaporguide.entity.ShopReview;

public interface ShopReviewRepository extends JpaRepository<ShopReview, Integer> {

	@Query("SELECT p FROM ShopReview p WHERE p.shop_id = :shop_id")
	public List<ShopReview> findByShopId(@Param("shop_id") int shop_id);
	
	@Query("SELECT p FROM ShopReview p WHERE p.user_id = :user_id ORDER BY created_datetime DESC")
	public List<ShopReview> findByUserId(@Param("user_id") int user_id);
	
	@Query("SELECT p FROM ShopReview p WHERE p.user_id = :user_id AND p.shop_id = :shop_id")
	public List<ShopReview> findByUserIdAndShopId(@Param("user_id") int user_id, @Param("shop_id") int shop_id);
	
}