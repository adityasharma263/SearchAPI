package com.needle.innovizsion.searchapi.dto;


import com.needle.innovizsion.searchapi.model.*;

import java.util.Date;
import java.util.List;

public class NetflixData {

	private String showId;

	private Type type;

	private String title;

	private List<Director> director;

	private List<Cast> cast;

	private List<Country> country;

	private Date date;

	private String year;

	private String rating;

	private int duration;

	private String durationType;

	private List<ListedIn> listedIn;

	private String description;
	
	public String getShowId() {
		return showId;
	}

	public void setShowId(String showId) {
		this.showId = showId;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Director> getDirector() {
		return director;
	}

	public void setDirector(List<Director> director) {
		this.director = director;
	}

	public List<Cast> getCast() {
		return cast;
	}

	public void setCast(List<Cast> cast) {
		this.cast = cast;
	}

	public List<Country> getCountry() {
		return country;
	}

	public void setCountry(List<Country> country) {
		this.country = country;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDurationType() {
		return durationType;
	}

	public void setDurationType(String durationType) {
		this.durationType = durationType;
	}

	public List<ListedIn> getListed_in() {
		return listedIn;
	}

	public void setListed_in(List<ListedIn> listedIn) {
		this.listedIn = listedIn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
