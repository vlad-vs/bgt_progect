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

@Transactional
@Repository("userDao")
public class UserDao {

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
    public void setUserToData(User user) {
//        String sql = "INSERT INTO users (idUSER, USER_NAME, USER_SECOND_NAME, USER_PASSWORD) VALUES (:idUSER, :USER_NAME, :USER_SECOND_NAME, :USER_PASSWORD)";
        User b = entityManager.find(User.class,user.getId());
        if  (b!=null){
            System.out.println("contains = " + b);
        } else {
            System.out.println("contains = " + b);
            entityManager.persist(user);
        }
    }

    @Transactional
    public List<User> findAllUsers() {
        String qverySql = "SELECT ALL * FROM USERS";
        Query query = entityManager.createNativeQuery(qverySql,User.class);
        List users = query.getResultList();
        return users;
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
