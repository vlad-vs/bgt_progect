package com.bgt.services;

import com.bgt.entityes.guides.Units;

import java.util.List;

public interface UnitServiceInterface {

	public void addItem(Units unit, Units pUnit);


	public void updateItem(int id, String name, String kod);


	public List<Units> getAllItems();


	public Units getItemByName(String name);


	public void deleteItemById(int id);

}
