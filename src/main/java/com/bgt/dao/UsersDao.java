package com.bgt.dao;


import com.bgt.entityes.User;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import java.util.List;
import java.util.Set;

@Transactional
@Repository("userDao")
public class UsersDao {

//    private NamedParameterJdbcTemplate jdbcTemplate;
//
//    private DataSource dataSource;
//
//    @Autowired
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
//    }

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public void addItem(User user) {
		entityManager.persist(user);
	}

	@Transactional
	public List<User> findAllItems() {
		String qverySql = "SELECT ALL * FROM USERS ORDER BY USER_NAME";
		Query query = entityManager.createNativeQuery(qverySql, User.class);
		List users = query.getResultList();
		return users;
	}

	@Transactional
	public User deleteItemById(int idUser) {
		User userToDel = entityManager.find(User.class, idUser);
		entityManager.remove(userToDel);
		return userToDel;
	}

	@Transactional
	public User updateItemById(int idUser, String name, String secondName, String password) {
		User user = entityManager.find(User.class, idUser);
		user.setName(name);
		user.setPassword(password);
		user.setSecondName(secondName);
		entityManager.merge(user);
		return user;
	}

	@Transactional
	public User getItemByName(String name) {
		User user = null;
		String q = "SELECT * FROM USERS WHERE USER_NAME=:name";
		Query query = entityManager.createNativeQuery(q, User.class);
		query.setParameter("name", name);
		List<User> users = query.getResultList();
		if (!users.isEmpty()) {
			user = users.get(0);
		}
		return user;
	}
//    public Object getUserFromData(long id) {
//        Query query = entityManager.createNativeQuery("SELECT * FROM MySite.USERS WHERE USER_ID=:id",User.class);
//        query.setParameter("id",id);
//        Object user = query.getSingleResult();
//        return user;
//    }

//    public User getUserFromData(String eMail) {
//        Query query = entityManager.createNativeQuery("\n",User.class);
//        query.setParameter("email",eMail);
//        User user = (User) query.getSingleResult();
//        return user;
//    }
}
