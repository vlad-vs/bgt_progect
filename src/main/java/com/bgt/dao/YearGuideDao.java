package com.bgt.dao;

import com.bgt.entityes.guides.YearGuide;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Transactional
@Repository("yearGuideDao")
public class YearGuideDao {

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public List<YearGuide> getAllYearItems(){
		String sqlQuery = "SELECT ALL * FROM YEARS_GUIDE ORDER BY YEAR";
		Query nativeQuery = entityManager.createNativeQuery(sqlQuery, YearGuide.class);
		return nativeQuery.getResultList();
	}

	@Transactional
	public void insertYearItem(YearGuide yearGuide){
		entityManager.persist(yearGuide);
	}

	@Transactional
	public void delYearItemById(int id){
		YearGuide yearGuide = entityManager.find(YearGuide.class, id);
		entityManager.remove(yearGuide);
	}

}
