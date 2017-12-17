package com.bgt.dao;

import com.bgt.entityes.guides.BgtGuide;
import com.bgt.entityes.guides.YearGuide;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository("bgtGuideDao")
public class BgtGuideDao {

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public List<BgtGuide> getAllBgtItems(){
		String sqlQuery = "SELECT ALL * FROM BGT_GUIDE ORDER BY KOD_BGT";
		Query nativeQuery = entityManager.createNativeQuery(sqlQuery, BgtGuide.class);
		return nativeQuery.getResultList();
	}
	@Transactional
	public void insertBgtItem(BgtGuide bgtGuide){
		entityManager.persist(bgtGuide);
	}

	@Transactional
	public void delBgtById(int id){
		BgtGuide bgtGuide = entityManager.find(BgtGuide.class, id);
		entityManager.remove(bgtGuide);
	}


}
