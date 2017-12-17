package com.bgt.entityes;


import org.hibernate.annotations.NamedQuery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "USERS")
//@NamedQuery(name = "User.getAll", query = "SELECT c from USERS c")
public class User {

    @Id
    @Column(name = "ID_USER")
    int idUser;

    @Column(name = "USER_NAME")
    String name;

    @Column(name = "USER_SECOND_NAME")
    String secondName;

    @Column(name = "USER_PASSWORD")
    String password;

    public User () {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String secondName) {
        this.name = name;
        this.secondName = secondName;
    }

    public User(String name, String secondName, String password) {
        this.name = name;
        this.secondName = secondName;
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return idUser == user.idUser &&
                Objects.equals(name, user.name) &&
                Objects.equals(secondName, user.secondName) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUser, name, secondName, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
