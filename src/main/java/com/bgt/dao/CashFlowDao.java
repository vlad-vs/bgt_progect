package com.bgt.dao;


import com.bgt.entityes.guides.CashFlowGuide;
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
	public void addUpdateItem(CashFlowGuide item) {
//		entityManager.persist(item);
		CashFlowGuide i = entityManager.find(CashFlowGuide.class,item.getIdCf());
		if  (i!=null){
			entityManager.merge(item);
		} else {
			entityManager.persist(item);
		}
	}

	@Transactional
	public List<CashFlowGuide> findAllItems() {
		String qverySql = "SELECT ALL * FROM CASH_FLOW_GUIDE ORDER BY KOD_CASH_FLOW_ITEM";
		Query query = entityManager.createNativeQuery(qverySql,CashFlowGuide.class);
		List items = query.getResultList();
		return items;
	}

	@Transactional
	public CashFlowGuide delItemById(int id) {
		CashFlowGuide items = entityManager.find(CashFlowGuide.class,id);
		entityManager.remove(items);
		return items;
	}

	public CashFlowGuide getItemById(int id){
		CashFlowGuide i = entityManager.find(CashFlowGuide.class,id);
		return i;
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
