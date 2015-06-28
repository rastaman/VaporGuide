package com.bsalm.vaporguide.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bsalm.vaporguide.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.facebook_id = :facebookId")
	public User findByFacebookId(@Param("facebookId") String facebookId);
	
//	@Query("SELECT p FROM Album p WHERE p.artist.id = :id")
//	public List<Album> findByArtist(@Param("id") int id);
	
}