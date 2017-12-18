package com.bgt.dao;

import com.bgt.entityes.guides.CompaniesGuide;
import com.bgt.entityes.guides.YearGuide;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository("companyesGuideDao")
public class CompanyDao {

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public List<CompaniesGuide> getAllCompanyesItems(){
		String sqlQuery = "SELECT ALL * FROM COMPANYES_GUIDE ORDER BY KOD_COMPANY";
		Query nativeQuery = entityManager.createNativeQuery(sqlQuery, CompaniesGuide.class);
		return nativeQuery.getResultList();
	}
	@Transactional
	public void insertCompanyItem(CompaniesGuide item){
		entityManager.persist(item);
	}

	@Transactional
	public void delCompanyItemById(int id){
		CompaniesGuide item = entityManager.find(CompaniesGuide.class, id);
		entityManager.remove(item);
	}


}
