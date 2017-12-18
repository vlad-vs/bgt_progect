package com.bgt.services;

import com.bgt.dao.CashFlowDao;
import com.bgt.entityes.guides.CashFlowGuide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashFlowService implements GuideServiceInterface {

	@Autowired
	CashFlowDao cfDao;


	@Override
	public void addItem(CashFlowGuide item){
		cfDao.addUpdateItem(item);
	}

	@Override
	public void delItemById(int id){
		cfDao.delItemById(id);
	}

	@Override
	public void updateItem(CashFlowGuide item) {
		cfDao.addUpdateItem(item);
	}

	@Override
	public List<CashFlowGuide> getAllItems() {
		return cfDao.findAllItems();
	}

}
