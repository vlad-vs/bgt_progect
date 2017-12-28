package com.bgt.services.impl;

import com.bgt.dao.CashFlowDao;
import com.bgt.dao.OperationToPlAndCfReportDao;
import com.bgt.entityes.guides.CashFlow;
import com.bgt.entityes.guides.OperationToPlAndCfReport;
import com.bgt.services.CashFlowServiceInterface;
import com.bgt.services.OperationToPlAndCfReportServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationToPlAndCfReportService implements OperationToPlAndCfReportServiceInterface {

	@Autowired
	OperationToPlAndCfReportDao dao;

	@Override
	public void addItem(OperationToPlAndCfReport item, OperationToPlAndCfReport pItem) {
		if (!dao.findUnit(item)) {
			if (pItem == null) {
				item.setFasadKodOperationItem("OP." + item.getKodOperationItem() + ".");
			} else {
				item.setFasadKodOperationItem(pItem.getFasadKodOperationItem()+ item.getKodOperationItem() + ".");
			}
		}
		dao.addItem(item);
	}

	@Override
	public void updateItem(int id, String name, String fKod, int idPl,int idCf) {
		dao.updateItemById(id, name, fKod, idPl,idCf);
	}

	@Override
	public List<OperationToPlAndCfReport> getAllItems() {
		return dao.getAllItems();
	}

	@Override
	public OperationToPlAndCfReport getItemByName(String name) {
		return dao.getItemByName(name);
	}

	@Override
	public void deleteItemById(int id) {
		dao.deleteItemById(id);
	}

}
