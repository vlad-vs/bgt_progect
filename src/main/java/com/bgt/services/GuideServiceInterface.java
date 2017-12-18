package com.bgt.services;

import com.bgt.entityes.guides.CashFlow;

import java.util.List;

public interface GuideServiceInterface {

	void addItem(CashFlow item);

	void deleteItemById(int id);

	void updateItem(CashFlow item);

	List<CashFlow> getAllItems();


}
