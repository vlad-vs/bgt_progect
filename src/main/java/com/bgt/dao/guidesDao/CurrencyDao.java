package com.bgt.dao.guidesDao;

import com.bgt.entityes.guides.Currency;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository("currencuGuideDao")
public class CurrencyDao {

	@PersistenceContext
	EntityManager entityManager;

	public void addCurrencyItemToBase(Currency currency){
		entityManager.persist(currency);
	}

	public List<Currency> getAllCurrencyItems() {
		String sqlQuery = "SELECT ALL * FROM CURRENCY ORDER BY SHORT_CURRENCY_NAME";
		Query query = entityManager.createNativeQuery(sqlQuery,Currency.class);
		return query.getResultList();
	}

	public void deleteCurrencyItem(int id) {
		Currency currencyGuide = entityManager.find(Currency.class, id);
		entityManager.remove(currencyGuide);
	}
}
