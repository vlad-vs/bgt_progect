package com.bgt.entityes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "idUSER")
    int id;
    @Column(name = "USER_NAME")
    String name;
    @Column(name = "USER_SECOND_NAME")
    String secondName;

    @Column(name = "USER_PASSWORD")
    String password;

    public User() {
    }

    public User(String name, String secondName) {
        this.name = name;
        this.secondName = secondName;
    }

    public User(int id, String name, String secondName, String password) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
