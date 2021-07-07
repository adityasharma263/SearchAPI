package com.needle.innovizsion.searchapi.model;

public enum Genre {
	Dramas("Dramas"), 
	InternationalMovies("International Movies"), 
	RomanticMovies("Romantic Movies");
	
	private Genre(String name) {
		this.name = name;
	}

	public String getGenre() {
		return name;
	}

	private String name;
	

}
