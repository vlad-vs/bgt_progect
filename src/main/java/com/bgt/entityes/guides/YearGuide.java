package com.bgt.entityes.guides;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "YEARS_GUIDE")
public class YearGuide {

	@Id
	@Column (name = "ID_YEAR")
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	int idYear;

	@Column(name = "YEAR",unique = true)
	int year;

	public YearGuide() {
	}

	public YearGuide(int year) {
		this.year = year;
	}

	public int getIdYear() {
		return idYear;
	}

	public void setIdYear(int idYear) {
		this.idYear = idYear;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		YearGuide yearGuide = (YearGuide) o;
		return idYear == yearGuide.idYear &&
				year == yearGuide.year;
	}

	@Override
	public int hashCode() {

		return Objects.hash(idYear, year);
	}

	@Override
	public String toString() {
		return "YearGuide{" +
				"idYear=" + idYear +
				", year=" + year +
				'}';
	}
}
