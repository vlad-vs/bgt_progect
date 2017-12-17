package com.bgt.services;

import com.bgt.entityes.guides.CashFlowGuide;

import java.io.Serializable;
import java.util.List;

public interface GuideServiceInterface {

	void addItem(CashFlowGuide item);
	void delItemById(int id);
	void updateItem(CashFlowGuide item);
	List<CashFlowGuide> getAllItems();

}
