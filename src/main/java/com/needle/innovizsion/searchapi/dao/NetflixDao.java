package com.needle.innovizsion.searchapi.dao;


import com.needle.innovizsion.searchapi.model.Netflix;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NetflixDao extends JpaRepository<Netflix, String> , NetflixCustomDao {

//    List<Object[]> getAll(NetflixData netflixData, int pageNo);
	
}
