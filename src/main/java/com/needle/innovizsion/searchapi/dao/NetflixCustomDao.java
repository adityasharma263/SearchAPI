package com.needle.innovizsion.searchapi.dao;

import com.needle.innovizsion.searchapi.dto.NetflixData;


import java.util.List;

public interface NetflixCustomDao {
	
	List<Object[]> getAll(NetflixData netflixData, int pageNo);

}
