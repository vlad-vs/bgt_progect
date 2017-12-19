package com.bgt.entityes.guides;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CASH_FLOW")
public class CashFlow {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@NotNull
	@Column(name = "ID_CF",unique = true)
	int idCf;

	@Column(name = "KOD_CASH_FLOW")
	String kodCashFlowItem;

	@Column(name = "FASAD_KOD_CASH_FLOW",unique = true)
	String fasadKodCashFlowItem;

	@Column(name = "CASH_FLOW",unique = true)
	String cashFlowItem;

	@Column(name = "CASH_FLOW_LEVEL")
	boolean cashFlowItemLevel;

	public CashFlow() {
	}

	public CashFlow(String kodCashFlowItem, String fasadKodCashFlowItem, String cashFlowItem, boolean cashFlowItemLevel) {
		this.kodCashFlowItem = kodCashFlowItem;
		this.fasadKodCashFlowItem = fasadKodCashFlowItem;
		this.cashFlowItem = cashFlowItem;
		this.cashFlowItemLevel = cashFlowItemLevel;
	}

	public CashFlow(String kodCashFlowItem, String cashFlowItem, boolean cashFlowItemLevel) {
		this.kodCashFlowItem = kodCashFlowItem;
		this.cashFlowItem = cashFlowItem;
		this.cashFlowItemLevel = cashFlowItemLevel;
	}

	public int getIdCf() {
		return idCf;
	}

	public void setIdCf(int idCf) {
		this.idCf = idCf;
	}

	public String getKodCashFlowItem() {
		return kodCashFlowItem;
	}

	public void setKodCashFlowItem(String kodCashFlowItem) {
		this.kodCashFlowItem = kodCashFlowItem;
	}

	public String getFasadKodCashFlowItem() {
		return fasadKodCashFlowItem;
	}

	public void setFasadKodCashFlowItem(String fasadKodCashFlowItem) {
		this.fasadKodCashFlowItem = fasadKodCashFlowItem;
	}

	public String getCashFlowItem() {
		return cashFlowItem;
	}

	public void setCashFlowItem(String cashFlowItem) {
		this.cashFlowItem = cashFlowItem;
	}

	public boolean isCashFlowItemLevel() {
		return cashFlowItemLevel;
	}

	public void setCashFlowItemLevel(boolean cashFlowItemLevel) {
		this.cashFlowItemLevel = cashFlowItemLevel;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CashFlow cashFlow = (CashFlow) o;
		return idCf == cashFlow.idCf &&
				cashFlowItemLevel == cashFlow.cashFlowItemLevel &&
				Objects.equals(kodCashFlowItem, cashFlow.kodCashFlowItem) &&
				Objects.equals(fasadKodCashFlowItem, cashFlow.fasadKodCashFlowItem) &&
				Objects.equals(cashFlowItem, cashFlow.cashFlowItem);
	}

	@Override
	public int hashCode() {

		return Objects.hash(idCf, kodCashFlowItem, fasadKodCashFlowItem, cashFlowItem, cashFlowItemLevel);
	}

	@Override
	public String toString() {
		return "CashFlow{" +
				"idCf=" + idCf +
				", kodCashFlowItem='" + kodCashFlowItem + '\'' +
				", fasadKodCashFlowItem='" + fasadKodCashFlowItem + '\'' +
				", cashFlowItem='" + cashFlowItem + '\'' +
				", cashFlowItemLevel=" + cashFlowItemLevel +
				'}';
	}
}
