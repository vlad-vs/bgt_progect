package com.bgt.entityes.guides;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "YEARS")
public class Year {

	@Id
	@Column (name = "ID_YEAR")
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	int idYear;

	@Column(name = "YEAR",unique = true)
	int year;

	public Year() {
	}

	public Year(int year) {
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
		Year year = (Year) o;
		return idYear == year.idYear &&
				this.year == year.year;
	}

	@Override
	public int hashCode() {

		return Objects.hash(idYear, year);
	}

	@Override
	public String toString() {
		return "Year{" +
				"idYear=" + idYear +
				", year=" + year +
				'}';
	}
}
