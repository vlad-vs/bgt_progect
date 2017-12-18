package com.bgt.services.impl;

import com.bgt.dao.UsersDao;
import com.bgt.entityes.User;
import com.bgt.services.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {

	@Autowired
	UsersDao dao;

	@Override
	public void addItem(User unit) {
		dao.addItem(unit);
	}

	@Override
	public void updateItem(int id, String name, String secondName,String password) {
		dao.updateItemById(id,name,secondName,password);
	}

	@Override
	public List<User> getAllItems() {
		return dao.findAllItems();
	}

	@Override
	public User getItemByName(String name) {
		return dao.getItemByName(name);
	}

	@Override
	public void deleteItemById(int id) {
		dao.deleteItemById(id);
	}
}
