package com.bgt.dao;

import com.bgt.entityes.guides.Balance;
import com.bgt.entityes.guides.CashFlow;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BalanceDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void addItem(Balance item) {
        entityManager.persist(item);
    }

    @Transactional
    public List<Balance> getAllItems() {
        String qverySql = "SELECT ALL * FROM balance ORDER BY KOD_BALANCE";
        Query query = entityManager.createNativeQuery(qverySql, Balance.class);
        List items = query.getResultList();
        return items;
    }

    @Transactional
    public void deleteItemById(int id) {
        Balance items = entityManager.find(Balance.class, id);
        entityManager.remove(items);
    }

    @Transactional
    public void updateItemById(int id,String fKod,String name ) {
        Balance items = entityManager.find(Balance.class, id);
        items.setFasadKodBlItem(fKod);
        items.setBalanceItem(name);
        entityManager.merge(items);
    }

    @Transactional
    public Balance getItemById(int id) {
        Balance i = entityManager.find(Balance.class, id);
        return i;
    }

    @Transactional
    public Balance getItemByName(String name) {
        Balance item = null;
        String q = "SELECT * FROM balance WHERE ITEM_BALANCE=:name";
        Query query = entityManager.createNativeQuery(q, Balance.class);
        query.setParameter("name", name);
        List<Balance> list = query.getResultList();
        if (!list.isEmpty()) {
            item = list.get(0);
        }
        return item;
    }

    @Transactional
    public boolean findUnit(Balance item) {
        boolean b = false;
        if (!(entityManager.find(Balance.class, item.getIdBl()) == null)) {
            b = true;
        }
        return b;
    }

}
