package com.bgt.entityes.guides;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "PROFIT_AND_LOSS")
public class ProfitAndLoss implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PL", unique = true, nullable = false)
    private int idPl;

    @Column(name = "KOD_ITEM")
    private String kodItem;

    @Column(name = "FASAD_KOD__ITEM", unique = true)
    private String fasadKodItem;

    @Column(name = "NAME_ITEM", unique = true)
    private String nameItem;

    @Column(name = "TYPE_ITEM")
    private String typeItem;

    @Column(name = "LEVEL_ITEM")
    private boolean levelItem;

    public ProfitAndLoss() {
    }

    public ProfitAndLoss(String kodItem, String nameItem, String typeItem, boolean levelItem) {
        this.kodItem = kodItem;
        this.nameItem = nameItem;
        this.typeItem = typeItem;
        this.levelItem = levelItem;
    }

    public ProfitAndLoss(int idPl, String kodItem, String fasadKodItem, String nameItem, String typeItem, boolean levelItem) {
        this.idPl = idPl;
        this.kodItem = kodItem;
        this.fasadKodItem = fasadKodItem;
        this.nameItem = nameItem;
        this.typeItem = typeItem;
        this.levelItem = levelItem;
    }

    public ProfitAndLoss(String kodItem, String fasadKodItem, String nameItem, String typeItem, boolean levelItem) {
        this.kodItem = kodItem;
        this.fasadKodItem = fasadKodItem;
        this.nameItem = nameItem;
        this.typeItem = typeItem;
        this.levelItem = levelItem;
    }

    public int getIdPl() {
        return idPl;
    }

    public void setIdPl(int idPl) {
        this.idPl = idPl;
    }

    public String getKodItem() {
        return kodItem;
    }

    public void setKodItem(String kodItem) {
        this.kodItem = kodItem;
    }

    public String getFasadKodItem() {
        return fasadKodItem;
    }

    public void setFasadKodItem(String fasadKodItem) {
        this.fasadKodItem = fasadKodItem;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public String getTypeItem() {
        return typeItem;
    }

    public void setTypeItem(String typeItem) {
        this.typeItem = typeItem;
    }

    public boolean isLevelItem() {
        return levelItem;
    }

    public void setLevelItem(boolean levelItem) {
        this.levelItem = levelItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfitAndLoss that = (ProfitAndLoss) o;
        return idPl == that.idPl &&
                levelItem == that.levelItem &&
                Objects.equals(kodItem, that.kodItem) &&
                Objects.equals(fasadKodItem, that.fasadKodItem) &&
                Objects.equals(nameItem, that.nameItem) &&
                Objects.equals(typeItem, that.typeItem);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idPl, kodItem, fasadKodItem, nameItem, typeItem, levelItem);
    }

    @Override
    public String toString() {
        return "ProfitAndLoss{" +
                "idPl=" + idPl +
                ", kodItem='" + kodItem + '\'' +
                ", fasadKodItem='" + fasadKodItem + '\'' +
                ", nameItem='" + nameItem + '\'' +
                ", typeItem='" + typeItem + '\'' +
                ", levelItem=" + levelItem +
                '}';
    }
}
