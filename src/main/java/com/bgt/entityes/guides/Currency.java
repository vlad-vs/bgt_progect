package com.bgt.entityes.guides;



import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CURRENCY")
public class Currency {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "ID_CURRENCY")
	int idCurrency;

	@Column(name = "SHORT_CURRENCY_NAME",unique = true)
	String shortCurrencyName;

	@Column(name = "CURRENCY_NAME")
	String currencyName;

	public Currency() {

	}

	public Currency(String shortCurrencyName, String currencyName) {
		this.shortCurrencyName = shortCurrencyName;
		this.currencyName = currencyName;
	}

	public int getIdCurrency() {
		return idCurrency;
	}

	public void setIdCurrency(int idCurrency) {
		this.idCurrency = idCurrency;
	}

	public String getShortCurrencyName() {
		return shortCurrencyName;
	}

	public void setShortCurrencyName(String shortCurrencyName) {
		this.shortCurrencyName = shortCurrencyName;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Currency that = (Currency) o;
		return idCurrency == that.idCurrency &&
				Objects.equals(shortCurrencyName, that.shortCurrencyName) &&
				Objects.equals(currencyName, that.currencyName);
	}

	@Override
	public int hashCode() {

		return Objects.hash(idCurrency, shortCurrencyName, currencyName);
	}

	@Override
	public String toString() {
		return "Currency{" +
				"idCurrency=" + idCurrency +
				", shortCurrencyName='" + shortCurrencyName + '\'' +
				", currencyName='" + currencyName + '\'' +
				'}';
	}
}
