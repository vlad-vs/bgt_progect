package com.bgt.dao;

import com.bgt.entityes.guides.CashFlow;
import com.bgt.entityes.guides.ProfitAndLoss;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("profitAndLossGuideDao")
@Transactional
public class ProfitAndLossDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void addItem(ProfitAndLoss item) {
        entityManager.persist(item);
    }

    @Transactional
    public boolean findUnit(ProfitAndLoss item) {
        boolean b = false;
        if (!(entityManager.find(CashFlow.class, item.getIdPl()) == null)) {
            b = true;
        }
        return b;
    }

    @Transactional
    public List<ProfitAndLoss> getAllItems() {
        String sqlQwery = "SELECT ALL * FROM PROFIT_AND_LOSS order by KOD_ITEM";
        Query query = entityManager.createNativeQuery(sqlQwery, ProfitAndLoss.class);
        List list = query.getResultList();
        return list;
    }

    @Transactional
    public ProfitAndLoss getItemById(int id) {
        ProfitAndLoss profitAndLossGuide = entityManager.find(ProfitAndLoss.class, id);
        return profitAndLossGuide;
    }

    @Transactional
    public void deleteItemById(int id) {
        ProfitAndLoss profitAndLossGuide = entityManager.find(ProfitAndLoss.class, id);
        entityManager.remove(profitAndLossGuide);
    }

    @Transactional
    public void updateItemById(int id,String fKod, String name, String type, boolean level) {
        ProfitAndLoss profitAndLossItem = entityManager.find(ProfitAndLoss.class, id);
        profitAndLossItem.setFasadKodItem(fKod);
        profitAndLossItem.setNameItem(name);
        profitAndLossItem.setTypeItem(type);
        profitAndLossItem.setLevelItem(level);
        entityManager.merge(profitAndLossItem);
    }

    @Transactional
    public ProfitAndLoss getItemByName(String name) {
        ProfitAndLoss item = null;
        String q = "SELECT * FROM PROFIT_AND_LOSS WHERE NAME_ITEM=:name";
        Query query = entityManager.createNativeQuery(q, ProfitAndLoss.class);
        query.setParameter("name", name);
        List<ProfitAndLoss> list = query.getResultList();
        if (!list.isEmpty()) {
            item = list.get(0);
        }
        return item;
    }
}
