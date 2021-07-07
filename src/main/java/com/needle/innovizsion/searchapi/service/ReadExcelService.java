package com.needle.innovizsion.searchapi.service;



import com.needle.innovizsion.searchapi.model.Netflix;

import java.text.ParseException;
import java.util.List;

public interface ReadExcelService {
	
	List<Netflix> getExcelDataAsList() throws ParseException;

	Integer saveExcelData(List<Netflix> netflix);
}
