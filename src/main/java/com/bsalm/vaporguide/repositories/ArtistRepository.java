package com.bsalm.vaporguide.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bsalm.vaporguide.entity.Shop;


public interface ArtistRepository extends JpaRepository<Shop, Integer> {


}