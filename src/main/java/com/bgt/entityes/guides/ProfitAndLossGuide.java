package com.bgt.entityes.guides;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PROFIT_AND_LOSS_GUIDE")
public class ProfitAndLossGuide {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	@Column(name = "ID_PL")
	int idPl;

	@Column(name = "KOD_PROFIT_AND_LOSS_ITEM",unique = true)
	String kodProfitAndLossItem;

	@Column(name = "PROFIT_AND_LOSS_ITEM")
	String profitAndLossItem;

	@Column(name = "PROFIT_AND_LOSS_ITEM_TYPE")
	String profitAndLossItemType;

	@Column(name = "PROFIT_AND_LOSS_LEVEL")
	boolean profitAndLossLevel;

	public ProfitAndLossGuide() {
	}

	public ProfitAndLossGuide(String kodProfitAndLossItem, String profitAndLossItem, String profitAndLossItemType, boolean profitAndLossLevel) {
		this.kodProfitAndLossItem = kodProfitAndLossItem;
		this.profitAndLossItem = profitAndLossItem;
		this.profitAndLossItemType = profitAndLossItemType;
		this.profitAndLossLevel = profitAndLossLevel;
	}

	public ProfitAndLossGuide(int idPl,String kodProfitAndLossItem, String profitAndLossItem, String profitAndLossItemType, boolean profitAndLossLevel) {
		this.idPl = idPl;
		this.kodProfitAndLossItem = kodProfitAndLossItem;
		this.profitAndLossItem = profitAndLossItem;
		this.profitAndLossItemType = profitAndLossItemType;
		this.profitAndLossLevel = profitAndLossLevel;
	}

	public int getIdPl() {
		return idPl;
	}

	public void setIdPl(int idPl) {
		this.idPl = idPl;
	}

	public String getKodProfitAndLossItem() {
		return kodProfitAndLossItem;
	}

	public void setKodProfitAndLossItem(String kodProfitAndLossItem) {
		this.kodProfitAndLossItem = kodProfitAndLossItem;
	}

	public String getProfitAndLossItem() {
		return profitAndLossItem;
	}

	public void setProfitAndLossItem(String profitAndLossItem) {
		this.profitAndLossItem = profitAndLossItem;
	}

	public String getProfitAndLossItemType() {
		return profitAndLossItemType;
	}

	public void setProfitAndLossItemType(String profitAndLossItemType) {
		this.profitAndLossItemType = profitAndLossItemType;
	}

	public boolean isProfitAndLossLevel() {
		return profitAndLossLevel;
	}

	public void setProfitAndLossLevel(boolean profitAndLossLevel) {
		this.profitAndLossLevel = profitAndLossLevel;
	}

	@Override
	public String toString() {
		return "ProfitAndLossGuide{" +
				"idPl=" + idPl +
				", kodProfitAndLossItem='" + kodProfitAndLossItem + '\'' +
				", profitAndLossItem='" + profitAndLossItem + '\'' +
				", profitAndLossItemType='" + profitAndLossItemType + '\'' +
				", profitAndLossLevel=" + profitAndLossLevel +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProfitAndLossGuide that = (ProfitAndLossGuide) o;
		return idPl == that.idPl &&
				profitAndLossLevel == that.profitAndLossLevel &&
				Objects.equals(kodProfitAndLossItem, that.kodProfitAndLossItem) &&
				Objects.equals(profitAndLossItem, that.profitAndLossItem) &&
				Objects.equals(profitAndLossItemType, that.profitAndLossItemType);
	}

	@Override
	public int hashCode() {

		return Objects.hash(idPl, kodProfitAndLossItem, profitAndLossItem, profitAndLossItemType, profitAndLossLevel);
	}
}
