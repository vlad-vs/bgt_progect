package com.bgt.services;

import com.bgt.entityes.guides.Balance;
import com.bgt.entityes.guides.CashFlow;

import java.util.List;

public interface BalanceServiceInterface {

	void addItem(Balance item, Balance pItem);


	void updateItem(int id, String name, String kod);


	List<Balance> getAllItems();


	Balance getItemByName(String name);


	void deleteItemById(int id);
}
