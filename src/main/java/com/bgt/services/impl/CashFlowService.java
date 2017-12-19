package com.bgt.services.impl;

import com.bgt.dao.CashFlowDao;
import com.bgt.entityes.guides.CashFlow;
import com.bgt.services.CashFlowServiceInterface;
import com.bgt.services.GuideServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashFlowService implements CashFlowServiceInterface {

	@Autowired
	CashFlowDao dao;

	@Override
	public void addItem(CashFlow item, CashFlow pItem) {
		if (!dao.findUnit(item)) {
			if (pItem == null) {
				item.setFasadKodCashFlowItem("CF." + item.getKodCashFlowItem() + ".");
			} else {
				item.setFasadKodCashFlowItem(pItem.getFasadKodCashFlowItem() + item.getKodCashFlowItem() + ".");
			}
		}
		dao.addItem(item);
	}

	@Override
	public void updateItem(int id, String name, String fKod, boolean level) {
		dao.updateItemById(id, name, fKod, level);
	}

	@Override
	public List<CashFlow> getAllItems() {
		return dao.getAllItems();
	}

	@Override
	public CashFlow getItemByName(String name) {
		return dao.getItemByName(name);
	}

	@Override
	public void deleteItemById(int id) {
		dao.deleteItemById(id);
	}

}
