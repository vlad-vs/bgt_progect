package com.bgt.entityes.guides;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CASH_FLOW_GUIDE")
public class CashFlowGuide {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@NotNull
	@Column(name = "ID_CF")
	int idCf;

	@Column(name = "KOD_CASH_FLOW_ITEM",unique = true)
	String kodCashFlowItem;

	@Column(name = "CASH_FLOW_ITEM")
	String cashFlowItem;

	@Column(name = "CASH_FLOW_ITEM_LEVEL")
	boolean cashFlowItemLevel;

	public CashFlowGuide() {
	}

	public CashFlowGuide(String kodCashFlowItem, String cashFlowItem, boolean cashFlowItemLevel) {
		this.kodCashFlowItem = kodCashFlowItem;
		this.cashFlowItem = cashFlowItem;
		this.cashFlowItemLevel = cashFlowItemLevel;
	}

	public CashFlowGuide(int idCf, String kodCashFlowItem, String cashFlowItem, boolean cashFlowItemLevel) {
		this.idCf = idCf;
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
		CashFlowGuide that = (CashFlowGuide) o;
		return idCf == that.idCf &&
				cashFlowItemLevel == that.cashFlowItemLevel &&
				Objects.equals(kodCashFlowItem, that.kodCashFlowItem) &&
				Objects.equals(cashFlowItem, that.cashFlowItem);
	}

	@Override
	public int hashCode() {

		return Objects.hash(idCf, kodCashFlowItem, cashFlowItem, cashFlowItemLevel);
	}

	@Override
	public String toString() {
		return "CashFlowGuide{" +
				"idCf=" + idCf +
				", kodCashFlowItem='" + kodCashFlowItem + '\'' +
				", cashFlowItem='" + cashFlowItem + '\'' +
				", cashFlowItemLevel=" + cashFlowItemLevel +
				'}';
	}
}
