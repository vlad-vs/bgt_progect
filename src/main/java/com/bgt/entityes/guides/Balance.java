package com.bgt.entityes.guides;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BALANCE")
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BL", unique = true, nullable = false)
    private int idBl;

    @Column(name = "KOD_BALANCE")
    private String kodBlItem;

    @Column(name = "FASAD_KOD_BALANCE", unique = true)
    private String fasadKodBlItem;

    @Column(name = "ITEM_BALANCE", unique = true)
    private String balanceItem;

    public Balance() {
    }


    public Balance(String kodBlItem, String balanceItem) {
        this.kodBlItem = kodBlItem;
        this.balanceItem = balanceItem;
    }

    public Balance(String kodBlItem, String fasadKodBlItem, String balanceItem) {
        this.kodBlItem = kodBlItem;
        this.fasadKodBlItem = fasadKodBlItem;
        this.balanceItem = balanceItem;
    }

    public int getIdBl() {
        return idBl;
    }

    public void setIdBl(int idBl) {
        this.idBl = idBl;
    }

    public String getKodBlItem() {
        return kodBlItem;
    }

    public void setKodBlItem(String kodBlItem) {
        this.kodBlItem = kodBlItem;
    }

    public String getFasadKodBlItem() {
        return fasadKodBlItem;
    }

    public void setFasadKodBlItem(String fasadKodBlItem) {
        this.fasadKodBlItem = fasadKodBlItem;
    }

    public String getBalanceItem() {
        return balanceItem;
    }

    public void setBalanceItem(String balanceItem) {
        this.balanceItem = balanceItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance = (Balance) o;
        return idBl == balance.idBl &&
                Objects.equals(kodBlItem, balance.kodBlItem) &&
                Objects.equals(fasadKodBlItem, balance.fasadKodBlItem) &&
                Objects.equals(balanceItem, balance.balanceItem);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idBl, kodBlItem, fasadKodBlItem, balanceItem);
    }

    @Override
    public String toString() {
        return "Balance{" +
                "idBl=" + idBl +
                ", kodBlItem='" + kodBlItem + '\'' +
                ", fasadKodBlItem='" + fasadKodBlItem + '\'' +
                ", balanceItem='" + balanceItem + '\'' +
                '}';
    }
}
