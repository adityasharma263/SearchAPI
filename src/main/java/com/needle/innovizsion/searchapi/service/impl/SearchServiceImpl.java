package com.needle.innovizsion.searchapi.service.impl;


import com.needle.innovizsion.searchapi.dao.NetflixDao;
import com.needle.innovizsion.searchapi.dto.NetflixData;
import com.needle.innovizsion.searchapi.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	private NetflixDao neflixDao;

	@Override
	public List<Object[]> getAll(NetflixData netflixData, int pageNo) {
		
		List<Object[]> searchResult = neflixDao.getAll(netflixData, pageNo);
		
		return searchResult;
	}
	
}
