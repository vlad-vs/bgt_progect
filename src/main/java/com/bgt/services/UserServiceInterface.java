package com.bgt.services;

import com.bgt.entityes.User;
import com.bgt.entityes.guides.Units;

import java.util.List;

public interface UserServiceInterface {

	public void addItem(User unit);


	public void updateItem(int id, String name, String secondName,String password);


	public List<User> getAllItems();


	public User getItemByName(String name);


	public void deleteItemById(int id);

}
