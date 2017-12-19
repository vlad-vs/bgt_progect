package com.bgt.dao;


import com.bgt.entityes.guides.CashFlow;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository("cashFlowGuideDao")
public class CashFlowDao {


//    private NamedParameterJdbcTemplate jdbcTemplate;
//
//    private DataSource dataSource;
//
//    @Autowired
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
//    }

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public void addItem(CashFlow item) {
		entityManager.persist(item);
//		CashFlow i = entityManager.find(CashFlow.class,item.getIdCf());
//		if  (i!=null){
//			entityManager.merge(item);
//		} else {
//			entityManager.persist(item);
//		}
	}

	@Transactional
	public List<CashFlow> getAllItems() {
		String qverySql = "SELECT ALL * FROM CASH_FLOW ORDER BY KOD_CASH_FLOW";
		Query query = entityManager.createNativeQuery(qverySql, CashFlow.class);
		List items = query.getResultList();
		return items;
	}

	@Transactional
	public CashFlow deleteItemById(int id) {
		CashFlow items = entityManager.find(CashFlow.class, id);
		entityManager.remove(items);
		return items;
	}

	@Transactional
	public CashFlow updateItemById(int id, String name, String fKod, boolean level) {
		CashFlow items = entityManager.find(CashFlow.class, id);
		items.setCashFlowItem(name);
		items.setCashFlowItemLevel(level);
		items.setFasadKodCashFlowItem(fKod);
		entityManager.merge(items);
		return items;
	}

	@Transactional
	public CashFlow getItemById(int id) {
		CashFlow i = entityManager.find(CashFlow.class, id);
		return i;
	}

	@Transactional
	public CashFlow getItemByName(String name) {
		CashFlow item = null;
		String q = "SELECT * FROM CASH_FLOW WHERE CASH_FLOW=:name";
		Query query = entityManager.createNativeQuery(q, CashFlow.class);
		query.setParameter("name", name);
		List<CashFlow> list = query.getResultList();
		if (!list.isEmpty()) {
			item = list.get(0);
		}
		return item;
	}

	@Transactional
	public boolean findUnit(CashFlow item) {
		boolean b = false;
		if (!(entityManager.find(CashFlow.class, item.getIdCf()) == null)) {
			b = true;
		}
		return b;
	}

//    public Object getUserFromData(long id) {
//        Query query = entityManager.createNativeQuery("SELECT * FROM MySite.USERS WHERE USER_ID=:id",User.class);
//        query.setParameter("id",id);
//        Object user = query.getSingleResult();
//        return user;
//    }

//    public User getUserFromData(String eMail) {
//        Query query = entityManager.createNativeQuery("\n",User.class);
//        query.setParameter("email",eMail);
//        User user = (User) query.getSingleResult();
//        return user;
//    }

}
