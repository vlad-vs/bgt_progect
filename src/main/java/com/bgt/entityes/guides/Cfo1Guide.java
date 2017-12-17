package com.bgt.entityes.guides;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CFO1_GUIDE")
public class Cfo1Guide {

	@Id
	@Column(name = "ID_CFO1")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int idCfo1;

	@Column(name = "KOD_CFO1", unique = true, nullable = false)
	String kodCfo1;

	@Column(name = "CFO1", unique = true, nullable = false)
	String cfo1;


	public Cfo1Guide() {
	}

	public Cfo1Guide(String kodCfo1, String cfo1) {
		this.kodCfo1 = kodCfo1;
		this.cfo1 = cfo1;
	}

	public int getIdCfo1() {
		return idCfo1;
	}

	public void setIdCfo1(int idCfo1) {
		this.idCfo1 = idCfo1;
	}

	public String getKodCfo1() {
		return kodCfo1;
	}

	public void setKodCfo1(String kodCfo1) {
		this.kodCfo1 = kodCfo1;
	}

	public String getCfo1() {
		return cfo1;
	}

	public void setCfo1(String cfo1) {
		this.cfo1 = cfo1;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Cfo1Guide cfo1Guide = (Cfo1Guide) o;
		return idCfo1 == cfo1Guide.idCfo1 &&
				Objects.equals(kodCfo1, cfo1Guide.kodCfo1) &&
				Objects.equals(cfo1, cfo1Guide.cfo1);
	}

	@Override
	public int hashCode() {

		return Objects.hash(idCfo1, kodCfo1, cfo1);
	}

	@Override
	public String toString() {
		return "Cfo1Guide{" +
				"idCfo1=" + idCfo1 +
				", kodCfo1='" + kodCfo1 + '\'' +
				", cfo1='" + cfo1 + '\'' +
				'}';
	}
}
