package com.bgt.entityes.guides;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity (name = "UNITS_GUIDE")
public class UnitsGuide {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_UNIT")
	int idUnit;

	@Column(name = "KOD_UNIT",unique = true,nullable = false)
	String kodUnit;

	@Column(name = "UNIT",unique = true,nullable = false)
	String unit;

	@OneToMany
	@JoinTable
			(
					name="UNIT_CFO1",
					joinColumns={ @JoinColumn(name="ID_UNIT", referencedColumnName="ID_UNIT") },
					inverseJoinColumns={ @JoinColumn(name="ID_CFO1", referencedColumnName="ID_CFO1") }
			)
	List<Cfo1Guide> cfo1Guid;



	public UnitsGuide() {
	}

	public UnitsGuide(String kodUnit, String unit) {
		this.kodUnit = kodUnit;
		this.unit = unit;
	}

	public List<Cfo1Guide> getCfo1Guid() {
		return cfo1Guid;
	}

	public void setCfo1Guid(List<Cfo1Guide> cfo1Guid) {
		this.cfo1Guid = cfo1Guid;
	}

	public int getIdUnit() {
		return idUnit;
	}

	public void setIdUnit(int idUnit) {
		this.idUnit = idUnit;
	}

	public String getKodUnit() {
		return kodUnit;
	}

	public void setKodUnit(String kodUnit) {
		this.kodUnit = kodUnit;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UnitsGuide that = (UnitsGuide) o;
		return idUnit == that.idUnit &&
				Objects.equals(kodUnit, that.kodUnit) &&
				Objects.equals(unit, that.unit);
	}

	@Override
	public int hashCode() {

		return Objects.hash(idUnit, kodUnit, unit);
	}

	@Override
	public String toString() {
		return "UnitsGuide{" +
				"idUnit=" + idUnit +
				", kodUnit='" + kodUnit + '\'' +
				", unit='" + unit + '\'' +
				'}';
	}
}
