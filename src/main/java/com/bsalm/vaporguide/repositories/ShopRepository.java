package com.bsalm.vaporguide.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bsalm.vaporguide.entity.JuiceReview;
import com.bsalm.vaporguide.entity.Shop;

public interface ShopRepository extends JpaRepository<Shop, Integer> {

//	@Query("SELECT p FROM Album p WHERE LOWER(p.name) = LOWER(:name) and p.artist_id = :artistId")
//	public List<Album> findByName(@Param("name") String name, @Param("artistId") int artistId);
//	
//	@Query("SELECT p FROM Album p WHERE p.artist.id = :id")
//	public List<Album> findByArtist(@Param("id") int id);
	
}