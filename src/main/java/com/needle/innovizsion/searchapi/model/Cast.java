package com.needle.innovizsion.searchapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Cast {
	@Id
	@GeneratedValue
	private Long castId;

	private String name;

	@ManyToMany
	private List<Netflix> netflix = new ArrayList<>();

	public Long getCastId() {
		return castId;
	}

	public void setCastId(Long castId) {
		this.castId = castId;
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
