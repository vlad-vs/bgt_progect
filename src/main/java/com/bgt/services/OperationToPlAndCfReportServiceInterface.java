package com.bgt.services;

import com.bgt.entityes.guides.CashFlow;
import com.bgt.entityes.guides.OperationToPlAndCfReport;

import java.util.List;

public interface OperationToPlAndCfReportServiceInterface {

	void addItem(OperationToPlAndCfReport item, OperationToPlAndCfReport pItem);


	void updateItem(int id, String name, String kod, int idPl, int idCf);


	List<OperationToPlAndCfReport> getAllItems();


	OperationToPlAndCfReport getItemByName(String name);


	void deleteItemById(int id);
}
