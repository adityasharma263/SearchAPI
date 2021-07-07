package com.needle.innovizsion.searchapi.service.impl;


import com.needle.innovizsion.searchapi.service.ReadExcelService;
import com.needle.innovizsion.searchapi.dao.*;
import com.needle.innovizsion.searchapi.model.*;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReadExcelServiceImpl implements ReadExcelService {
	
	@Value("${app.upload.file:${user.home}}")
	public String EXCEL_FILE_PATH;

	@Autowired
	NetflixDao netflixDao;
	
	@Autowired
	CastDao castDao;
	
	@Autowired
	DirectorDao directorDao;
	
	@Autowired
	CountryDao countryDao;
	
	@Autowired
	ListedInDao listedInDao;

	Workbook workbook;
	
	public List<Netflix> getExcelDataAsList() throws ParseException {

		List<String> list = new ArrayList<String>();

		DataFormatter dataFormatter = new DataFormatter();

		try {
			FileInputStream newFile = new FileInputStream(EXCEL_FILE_PATH);
			workbook = WorkbookFactory.create(newFile);
			
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}

		Sheet sheet = workbook.getSheetAt(0);
		
		int noOfColumns = sheet.getRow(0).getLastCellNum();

		for (Row row : sheet) {
			for(int cn=0; cn<row.getLastCellNum(); cn++) {
			       Cell cell = row.getCell(cn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			       list.add(cell.toString());
			       System.out.println("CELL: " + cn + " --> " + cell.toString());
			   }
		}

		List<Netflix> netflixList = createList(list, noOfColumns);

		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return netflixList;
	}

	private List<Netflix> createList(List<String> excelData, int noOfColumns) {

		List<Netflix> netList = new ArrayList<Netflix>();

		int i = noOfColumns;
		do {
			Netflix net = new Netflix();
			net.setShowId(excelData.get(i));
			net.setType(excelData.get(i+1).equals(Type.movie.getType())?Type.movie:Type.tvshow);
			net.setTitle(excelData.get(i+2));
			
			//Save directors
			
			List<String> directorArray=Arrays.asList(excelData.get(i+3).split(","));
			for(String director:directorArray) {
				Director d = new Director();
				d.setName(director);
				net.getDirector().add(d);
				d.getNetflix().add(net);
				directorDao.save(d);
			}
			
			//Save Cast
			List<String> castArray=Arrays.asList(excelData.get(i+4).split(","));
			for(String cast : castArray) {
				Cast c=new Cast();
				c.setName(cast);
				net.getCast().add(c);
				c.getNetflix().add(net);
				castDao.save(c);
			}
			
			//Save Country
			List<String> countryArray=Arrays.asList(excelData.get(i+5).split(","));
			for(String country : countryArray) {
				Country c=new Country();
				c.setName(country);
				net.getCountry().add(c);
				c.getNetflix().add(net);
				countryDao.save(c);
			}
			
			try {
				Date formattedDate = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(excelData.get(i+6));
				net.setDate(formattedDate);
			}
			catch(Exception e) {
				net.setDate(null);
			}
			net.setYear(excelData.get(i+7));
			net.setRating(excelData.get(i+8));
			
			net.setDuration(Integer.parseInt(excelData.get(i+9).split(" ")[0]));
			net.setDurationType(excelData.get(i+9).split(" ")[1]);
			
			List<String> listedArray=Arrays.asList(excelData.get(i+10).split(","));
			//List<Listed_In> listedList = new ArrayList<>();
			for(String genre : listedArray) {
				ListedIn l=new ListedIn();
				l.setGenre(genre);
				net.getListed_in().add(l);
				l.getNetflix().add(net);
				//listedList.add(l);
				listedInDao.save(l);
			}
			//net.setListed_in(listedList);
			net.setDescription(excelData.get(i+11));
			
			netList.add(net);
			i = i + (noOfColumns);

		} while (i<50);
			return netList;
	}

	@Override
	public Integer saveExcelData(List<Netflix> netflix) {
		netflix = netflixDao.saveAll(netflix);
		return netflix.size();
	}
}
