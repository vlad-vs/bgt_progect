package com.bgt.dao.guidesDao;

import com.bgt.entityes.guides.Year;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Transactional
@Repository("yearGuideDao")
public class YearDao {

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public List<Year> getAllYearItems(){
		String sqlQuery = "SELECT ALL * FROM YEARS ORDER BY YEAR";
		Query nativeQuery = entityManager.createNativeQuery(sqlQuery, Year.class);
		return nativeQuery.getResultList();
	}

	@Transactional
	public void insertYearItem(Year year){
		entityManager.persist(year);
	}

	@Transactional
	public void delYearItemById(int id){
		Year year = entityManager.find(Year.class, id);
		entityManager.remove(year);
	}

}
