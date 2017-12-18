package com.bgt.services;

import com.bgt.entityes.guides.CashFlow;
import com.bgt.entityes.guides.Units;

import java.util.List;

public interface CashFlowServiceInterface {

	void addItem(CashFlow item, CashFlow pItem);


	void updateItem(int id, String name, String kod, boolean l);


	List<CashFlow> getAllItems();


	CashFlow getItemByName(String name);


	void deleteItemById(int id);
}
