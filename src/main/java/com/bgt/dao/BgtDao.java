package com.bgt.dao;

import com.bgt.entityes.guides.Bgt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository("bgtGuideDao")
public class BgtDao {

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public List<Bgt> getAllBgtItems(){
		String sqlQuery = "SELECT ALL * FROM BGT_GUIDE ORDER BY KOD_BGT";
		Query nativeQuery = entityManager.createNativeQuery(sqlQuery, Bgt.class);
		return nativeQuery.getResultList();
	}
	@Transactional
	public void insertBgtItem(Bgt bgtGuide){
		entityManager.persist(bgtGuide);
	}

	@Transactional
	public void delBgtById(int id){
		Bgt bgtGuide = entityManager.find(Bgt.class, id);
		entityManager.remove(bgtGuide);
	}


}
