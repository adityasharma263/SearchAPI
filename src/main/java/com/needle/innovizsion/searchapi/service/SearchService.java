package com.needle.innovizsion.searchapi.service;


import com.needle.innovizsion.searchapi.dto.NetflixData;


import java.util.List;

public interface SearchService {

	List<Object[]> getAll(NetflixData netflixData , int pageNo);
}
