package com.bgt.dao;

import com.bgt.entityes.guides.Cfo1Guide;
import com.bgt.entityes.guides.UnitsGuide;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository("cfo1GuideDao")
public class Cfo1GuideDao {

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public List<Cfo1Guide> getAllCfo1Items(){
		String sqlQuery = "SELECT ALL * FROM CFO1_GUIDE ORDER BY KOD_CFO1";
		Query nativeQuery = entityManager.createNativeQuery(sqlQuery, Cfo1Guide.class);
		return nativeQuery.getResultList();
	}

	@Transactional
	public void insertCfo1Item(Cfo1Guide cfo1Guide){
		entityManager.persist(cfo1Guide);
	}

	@Transactional
	public void delCfo1ById(int id){
		Cfo1Guide cfo1Guide = entityManager.find(Cfo1Guide.class, id);
		entityManager.remove(cfo1Guide);
	}

}
