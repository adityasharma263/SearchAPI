package com.needle.innovizsion.searchapi.dao;


import com.needle.innovizsion.searchapi.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryDao extends JpaRepository<Country, Long> {
	List<Country> findByName(String name);
}
