package com.bgt.entityes.guides;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "OPERATIONS")
public class OperationToPlAndCfReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_OPERATION", unique = true, nullable = false)
    private int idOperation;

    @Column(name = "KOD_OPERATION", unique = true)
    private String kodOperationItem;

    @Column(name = "FASAD_KOD_OPERATION", unique = true)
    private String fasadKodOperationItem;

    @Column(name = "ITEM_OPERATION", unique = true)
    private String operationItem;

    @Column(name = "ID_PL", unique = true)
    private int idPl;

    @Column(name = "ID_CF", unique = true)
    private int idCf;

    public OperationToPlAndCfReport() {
    }

    public OperationToPlAndCfReport(String kodOperationItem, String fasadKodOperationItem, String operationItem, int idPl, int idCf) {
        this.kodOperationItem = kodOperationItem;
        this.fasadKodOperationItem = fasadKodOperationItem;
        this.operationItem = operationItem;
        this.idPl = idPl;
        this.idCf = idCf;
    }

    public OperationToPlAndCfReport(String kodOperationItem, String operationItem, int idPl, int idCf) {
        this.kodOperationItem = kodOperationItem;
        this.operationItem = operationItem;
        this.idPl = idPl;
        this.idCf = idCf;
    }

    public int getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(int idOperation) {
        this.idOperation = idOperation;
    }

    public String getKodOperationItem() {
        return kodOperationItem;
    }

    public void setKodOperationItem(String kodOperationItem) {
        this.kodOperationItem = kodOperationItem;
    }

    public String getOperationItem() {
        return operationItem;
    }

    public void setOperationItem(String operationItem) {
        this.operationItem = operationItem;
    }

    public int getIdPl() {
        return idPl;
    }

    public void setIdPl(int idPl) {
        this.idPl = idPl;
    }

    public int getIdCf() {
        return idCf;
    }

    public void setIdCf(int idCf) {
        this.idCf = idCf;
    }

    public String getFasadKodOperationItem() {
        return fasadKodOperationItem;
    }

    public void setFasadKodOperationItem(String fasadKodOperationItem) {
        this.fasadKodOperationItem = fasadKodOperationItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationToPlAndCfReport that = (OperationToPlAndCfReport) o;
        return idOperation == that.idOperation &&
                Objects.equals(kodOperationItem, that.kodOperationItem) &&
                Objects.equals(operationItem, that.operationItem) &&
                Objects.equals(idPl, that.idPl) &&
                Objects.equals(idCf, that.idCf);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idOperation, kodOperationItem, operationItem, idPl, idCf);
    }

    @Override
    public String toString() {
        return "OperationToPlAndCfReport{" +
                "idOperation=" + idOperation +
                ", kodOperationItem='" + kodOperationItem + '\'' +
                ", operationItem='" + operationItem + '\'' +
                ", idPl='" + idPl + '\'' +
                ", idCf='" + idCf + '\'' +
                '}';
    }
}
