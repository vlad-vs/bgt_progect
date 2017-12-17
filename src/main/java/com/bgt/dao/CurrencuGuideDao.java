package com.bgt.dao;

import com.bgt.entityes.guides.CurrencyGuide;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository("currencuGuideDao")
public class CurrencuGuideDao {

	@PersistenceContext
	EntityManager entityManager;

	public void addCurrencyItemToBase(CurrencyGuide currency){
		entityManager.persist(currency);
	}

	public List<CurrencyGuide> getAllCurrencyItems() {
		String sqlQuery = "SELECT ALL * FROM CURRENCY_GUIDE ORDER BY SHORT_CURRENCY_NAME";
		Query query = entityManager.createNativeQuery(sqlQuery,CurrencyGuide.class);
		return query.getResultList();
	}

	public void deleteCurrencyItem(int id) {
		CurrencyGuide currencyGuide = entityManager.find(CurrencyGuide.class, id);
		entityManager.remove(currencyGuide);
	}
}
