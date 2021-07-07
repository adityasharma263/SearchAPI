package com.needle.innovizsion.searchapi.controller;


import com.needle.innovizsion.searchapi.dto.NetflixData;
import com.needle.innovizsion.searchapi.model.Netflix;
import com.needle.innovizsion.searchapi.service.ReadExcelService;
import com.needle.innovizsion.searchapi.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SearchApi {
	
	@Autowired
	ReadExcelService readExcelService;
	
	@Autowired
	SearchService searchService;
	
	
	@GetMapping("/saveData")
    public String saveExcelData() {
		List<Netflix> excelDataAsList = null;
		try {
			excelDataAsList = readExcelService.getExcelDataAsList();
			int noOfRecords = readExcelService.saveExcelData(excelDataAsList);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
    	return "saved data to database";
    }
	
	@PostMapping("/search/{pageNo}")
	@ResponseBody
	public List<Object[]> getSearchData(@RequestBody NetflixData netflixData, @PathVariable String pageNo) {
		return searchService.getAll(netflixData, Integer.parseInt(pageNo));
	}
	
	
}
