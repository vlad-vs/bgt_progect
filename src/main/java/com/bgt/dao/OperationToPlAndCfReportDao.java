package com.bgt.dao;

import com.bgt.entityes.guides.CashFlow;
import com.bgt.entityes.guides.OperationToPlAndCfReport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository
public class OperationToPlAndCfReportDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void addItem(OperationToPlAndCfReport item) {
        entityManager.persist(item);
    }

    @Transactional
    public List<OperationToPlAndCfReport> getAllItems() {
        String qverySql = "SELECT ALL * FROM OPERATIONS ORDER BY KOD_OPERATION";
        Query query = entityManager.createNativeQuery(qverySql, OperationToPlAndCfReport.class);
        return query.getResultList();
    }

    @Transactional
    public void deleteItemById(int id) {
        OperationToPlAndCfReport items = entityManager.find(OperationToPlAndCfReport.class, id);
        entityManager.remove(items);
    }

    @Transactional
    public void updateItemById(int id, String kod, String name, int idPl, int idCF) {
        OperationToPlAndCfReport items = entityManager.find(OperationToPlAndCfReport.class, id);
        items.setKodOperationItem(kod);
        items.setIdPl(idPl);
        items.setIdCf(idCF);
        entityManager.merge(items);
    }

    @Transactional
    public OperationToPlAndCfReport getItemById(int id) {
        OperationToPlAndCfReport i = entityManager.find(OperationToPlAndCfReport.class, id);
        return i;
    }

    @Transactional
    public OperationToPlAndCfReport getItemByName(String name) {
        OperationToPlAndCfReport item = null;
        String q = "SELECT * FROM OPERATIONS WHERE ITEM_OPERATION=:name";
        Query query = entityManager.createNativeQuery(q, OperationToPlAndCfReport.class);
        query.setParameter("name", name);
        List<OperationToPlAndCfReport> list = query.getResultList();
        if (!list.isEmpty()) {
            item = list.get(0);
        }
        return item;
    }

    @Transactional
    public boolean findUnit(OperationToPlAndCfReport item) {
        boolean b = false;
        if (!(entityManager.find(CashFlow.class, item.getIdOperation()) == null)) {
            b = true;
        }
        return b;
    }
}
