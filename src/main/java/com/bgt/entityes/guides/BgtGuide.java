package com.bgt.entityes.guides;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BGT_GUIDE")
public class BgtGuide {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_BGT")
	int idBgt;

	@Column(name = "KOD_BGT",unique = true)
	String kodBgt;

	@Column(name = "BGT_NAME",unique = true)
	String bgtName;

	public BgtGuide() {
	}

	public BgtGuide(String kodBgt, String bgtName) {
		this.kodBgt = kodBgt;
		this.bgtName = bgtName;
	}

	public int getIdBgt() {
		return idBgt;
	}

	public void setIdBgt(int idBgt) {
		this.idBgt = idBgt;
	}

	public String getKodBgt() {
		return kodBgt;
	}

	public void setKodBgt(String kodBgt) {
		this.kodBgt = kodBgt;
	}

	public String getBgtName() {
		return bgtName;
	}

	public void setBgtName(String bgtName) {
		this.bgtName = bgtName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BgtGuide bgtGuide = (BgtGuide) o;
		return idBgt == bgtGuide.idBgt &&
				Objects.equals(kodBgt, bgtGuide.kodBgt) &&
				Objects.equals(bgtName, bgtGuide.bgtName);
	}

	@Override
	public int hashCode() {

		return Objects.hash(idBgt, kodBgt, bgtName);
	}

	@Override
	public String toString() {
		return "BgtGuide{" +
				"idBgt=" + idBgt +
				", kodBgt='" + kodBgt + '\'' +
				", bgtName='" + bgtName + '\'' +
				'}';
	}
}
