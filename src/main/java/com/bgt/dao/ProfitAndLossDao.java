package com.bgt.dao;

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
	public List<ProfitAndLoss> getAllItems(){
		String sqlQwery = "SELECT ALL * FROM PROFIT_AND_LOSS_GUIDE order by KOD_PROFIT_AND_LOSS_ITEM";
		Query query = entityManager.createNativeQuery(sqlQwery,ProfitAndLoss.class);
		List list = query.getResultList();
		return list;
	}

	@Transactional
	public ProfitAndLoss getProfitAndLossGuideItemById(int id){
		ProfitAndLoss profitAndLossGuide = entityManager.find(ProfitAndLoss.class, id);
		return profitAndLossGuide;
	}

	@Transactional
	public void deleteProfitAndLossItemById(int id){
		ProfitAndLoss profitAndLossGuide = entityManager.find(ProfitAndLoss.class, id);
		entityManager.remove(profitAndLossGuide);
	}

	@Transactional
	public void insertProfitAndLossItem(ProfitAndLoss item){
		entityManager.persist(item);
	}

	@Transactional
	public void updateProfitAndLossItem(ProfitAndLoss item){
		ProfitAndLoss profitAndLossItem = entityManager.find(ProfitAndLoss.class, item.getIdPl());
		profitAndLossItem.setKodProfitAndLossItem(item.getKodProfitAndLossItem());
		profitAndLossItem.setProfitAndLossItem(item.getProfitAndLossItem());
		profitAndLossItem.setProfitAndLossItemType(item.getProfitAndLossItemType());
		profitAndLossItem.setProfitAndLossLevel(item.isProfitAndLossLevel());
//		entityManager.flush();
		entityManager.merge(profitAndLossItem);
	}

}
