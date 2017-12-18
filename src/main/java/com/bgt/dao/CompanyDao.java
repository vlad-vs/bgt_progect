package com.bgt.dao;

import com.bgt.entityes.guides.Company;
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
	public List<Company> getAllCompanyesItems(){
		String sqlQuery = "SELECT ALL * FROM COMPANYES_GUIDE ORDER BY KOD_COMPANY";
		Query nativeQuery = entityManager.createNativeQuery(sqlQuery, Company.class);
		return nativeQuery.getResultList();
	}
	@Transactional
	public void insertCompanyItem(Company item){
		entityManager.persist(item);
	}

	@Transactional
	public void delCompanyItemById(int id){
		Company item = entityManager.find(Company.class, id);
		entityManager.remove(item);
	}


}
