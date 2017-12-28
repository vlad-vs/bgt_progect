package com.bgt.services;

import com.bgt.entityes.guides.CashFlow;
import com.bgt.entityes.guides.ProfitAndLoss;

import java.util.List;

public interface ProfitAndLossServiceInterface {

	void addItem(ProfitAndLoss item, ProfitAndLoss pItem);


	void updateItem(int id, String fKod, String name, String type, boolean level);


	List<ProfitAndLoss> getAllItems();


	ProfitAndLoss getItemByName(String name);


	void deleteItemById(int id);

}
