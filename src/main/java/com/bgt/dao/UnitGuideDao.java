package com.bgt.dao;

import com.bgt.entityes.guides.UnitsGuide;
import com.bgt.entityes.guides.YearGuide;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository("unitGuideDao")
public class UnitGuideDao {

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public List<UnitsGuide> getAllUnitItems(){
		String sqlQuery = "SELECT ALL * FROM UNITS_GUIDE ORDER BY KOD_UNIT";
		Query nativeQuery = entityManager.createNativeQuery(sqlQuery, UnitsGuide.class);
		return nativeQuery.getResultList();
	}

	@Transactional
	public Object getUnitItemByKod(String kod){
		String sqlQuery = "SELECT * FROM UNITS_GUIDE WHERE KOD_UNIT=:kod";
		Query nativeQuery = entityManager.createNativeQuery(sqlQuery, UnitsGuide.class);
		nativeQuery.setParameter("kod",kod);
		Object item = null;
		try {
			item = nativeQuery.getSingleResult();
		} catch (Exception ex){
			return item;
		}

		return item;
	}

	@Transactional
	public void insertUnitItem(UnitsGuide unitsGuide){
		entityManager.persist(unitsGuide);
	}

	@Transactional
	public void delUnitItemById(int id){
		UnitsGuide unitGuide = entityManager.find(UnitsGuide.class, id);
		entityManager.remove(unitGuide);
	}

	@Transactional
	public void updateUnitItem(UnitsGuide unit){
		entityManager.merge(unit);
	}

}
