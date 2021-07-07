package com.needle.innovizsion.searchapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Country {
	
	@Id
	@GeneratedValue
	private Long countryId;

	private String name;

	@ManyToMany
	private List<Netflix> netflix = new ArrayList<>();

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Netflix> getNetflix() {
		return netflix;
	}

	public void setNetflix(List<Netflix> netflix) {
		this.netflix = netflix;
	}
}
