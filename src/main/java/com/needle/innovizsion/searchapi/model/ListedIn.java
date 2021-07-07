package com.needle.innovizsion.searchapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ListedIn {
	@Id
	@GeneratedValue
	private Long listedId;

	private String genre;

	@ManyToMany
	private List<Netflix> netflix = new ArrayList<>();

	public Long getListedId() {
		return listedId;
	}

	public void setListedId(Long listedId) {
		this.listedId = listedId;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<Netflix> getNetflix() {
		return netflix;
	}

	public void setNetflix(List<Netflix> netflix) {
		this.netflix = netflix;
	}
}
