package com.needle.innovizsion.searchapi.dao;


import com.needle.innovizsion.searchapi.dto.NetflixData;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

@Repository
public class NetflixDaoImpl implements NetflixCustomDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	final static String AND = "AND";
	final static String WHERE = "WHERE";
	
//	public NetflixDaoImpl(EntityManager e) {
//		entityManager = e;
//	}

	@Override
	public List<Object[]> getAll(NetflixData Netflix, int pageNo) {
		StringBuilder queryBuilder =  new StringBuilder("select * from netflix n ");
		StringBuilder postfix = new StringBuilder();
		
		if(Objects.nonNull(Netflix.getDirector())){
			queryBuilder.append(", Director d ");
			postfix.append(" d.name = '" + Netflix.getDirector().get(0).getName()+"'");
		}
		if(Objects.nonNull(Netflix.getCast())){
			queryBuilder.append(", Cast c ");
			if(postfix.length() != 0)
				postfix.append(AND);
			postfix.append(" c.cast = '" + Netflix.getCast()+"'");
		}
		if(Objects.nonNull(Netflix.getCountry())){
			queryBuilder.append(", Country cn ");
			if(postfix.length() != 0)
				postfix.append(AND);
			postfix.append(" cn.country = '" + Netflix.getCountry()+"'");
		}
		if(Objects.nonNull(Netflix.getListed_in())){
			queryBuilder.append(", ListedIn l ");
			if(postfix.length() != 0)
				postfix.append(AND);
			postfix.append(" n.listed_in = '" + Netflix.getListed_in()+"'");
		}
		if(Objects.nonNull(Netflix.getType())) {
			if(postfix.length() != 0)
				postfix.append(AND);
			postfix.append(" n.type = '" + Netflix.getType()+"'");
		}
		if(Objects.nonNull(Netflix.getTitle())) {
			if(postfix.length() != 0)
				postfix.append(AND);
			postfix.append(" n.title = '" + Netflix.getTitle()+"'");
		}
		if(Objects.nonNull(Netflix.getDate())) {
			if(postfix.length() != 0)
				postfix.append(AND);
			postfix.append(" n.date = '" + Netflix.getDate()+"'");
		}
		if(Objects.nonNull(Netflix.getYear())) {
			if(postfix.length() != 0)
				postfix.append(AND);
			postfix.append(" n.year = '" + Netflix.getYear()+"'");
		}
		if(Objects.nonNull(Netflix.getRating())) {
			if(postfix.length() != 0)
				postfix.append(AND);
			postfix.append(" n.rating = '" + Netflix.getRating()+"'");
		}
		if(Objects.nonNull(Netflix.getDuration()) && Netflix.getDuration()>0) {
			if(postfix.length() != 0)
				postfix.append(AND);
			postfix.append(" n.duration = '" + Netflix.getDuration()+"'");
		}
		if(Objects.nonNull(Netflix.getDurationType())) {
			if(postfix.length() != 0)
				postfix.append(AND);
			postfix.append(" durationType = '" + Netflix.getDurationType()+"'");
		}
//		if(postfix.length() != 0)
//			postfix.append(AND);
		//postfix.append(" n.show_id = '" + Netflix.getShowId() +"'"; 
		queryBuilder.append(WHERE).append(postfix);
		Query query = entityManager.createNativeQuery(queryBuilder.toString());
		int pageNumber = pageNo;
		int pageSize = 10;
		query.setFirstResult((pageNumber-1) * pageSize); 
		query.setMaxResults(pageSize);
		return query.getResultList().size() == 0 ? null : query.getResultList() ;
	}


}
