package com.bgt.services.impl;

import com.bgt.dao.BalanceDao;
import com.bgt.dao.CashFlowDao;
import com.bgt.entityes.guides.Balance;
import com.bgt.entityes.guides.CashFlow;
import com.bgt.services.BalanceServiceInterface;
import com.bgt.services.CashFlowServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceService implements BalanceServiceInterface {

	@Autowired
	BalanceDao dao;

	@Override
	public void addItem(Balance item, Balance pItem) {
		if (!dao.findUnit(item)) {
			if (pItem == null) {
				item.setFasadKodBlItem("BL." + item.getKodBlItem() + ".");
			} else {
				item.setFasadKodBlItem(pItem.getFasadKodBlItem() + item.getKodBlItem() + ".");
			}
		}
		dao.addItem(item);
	}

	@Override
	public void updateItem(int id, String fKod, String name) {
		dao.updateItemById(id, fKod, name);
	}

	@Override
	public List<Balance> getAllItems() {
		return dao.getAllItems();
	}

	@Override
	public Balance getItemByName(String name) {
		return dao.getItemByName(name);
	}

	@Override
	public void deleteItemById(int id) {
		dao.deleteItemById(id);
	}

}
