package com.bgt.entityes.guides;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "COMPANYES_GUIDE")
public class CompaniesGuide {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "ID_COMPANY")
	int idCompany;

	@Column(name = "KOD_COMPANY",unique = true)
	String kodCompany;

	@Column(name = "NAME_COMPANY",unique = true)
	String nameCompany;

	public CompaniesGuide(String kodCompany, String nameCompany) {
		this.kodCompany = kodCompany;
		this.nameCompany = nameCompany;
	}

	public CompaniesGuide() {
	}

	public int getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}

	public String getKodCompany() {
		return kodCompany;
	}

	public void setKodCompany(String kodCompany) {
		this.kodCompany = kodCompany;
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CompaniesGuide that = (CompaniesGuide) o;
		return idCompany == that.idCompany &&
				Objects.equals(kodCompany, that.kodCompany) &&
				Objects.equals(nameCompany, that.nameCompany);
	}

	@Override
	public int hashCode() {

		return Objects.hash(idCompany, kodCompany, nameCompany);
	}

	@Override
	public String toString() {
		return "CompaniesGuide{" +
				"idCompany=" + idCompany +
				", kodCompany='" + kodCompany + '\'' +
				", nameCompany='" + nameCompany + '\'' +
				'}';
	}
}
