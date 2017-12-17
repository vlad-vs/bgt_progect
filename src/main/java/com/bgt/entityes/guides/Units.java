package com.bgt.entityes.guides;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "UNITS")
public class Units {

	@Id
	@Column(name = "ID_U", unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@Column(name = "NAME_U", unique = true, nullable = false)
	String name;

	@Column(name = "KOD_U", nullable = false)
	String kod;

	@Column(name = "F_KOD_U", unique = true)
	String fKod;

	public Units() {
	}

	public Units(int id, String name, String kod, String fKod) {
		this.id = id;
		this.name = name;
		this.kod = kod;
		this.fKod = fKod;
	}

	public Units(String name, String kod) {
		this.name = name;
		this.kod = kod;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKod() {
		return kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

	public String getfKod() {
		return fKod;
	}

	public void setfKod(String fKod) {
		this.fKod = fKod;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Units units = (Units) o;
		return id == units.id &&
				Objects.equals(name, units.name) &&
				Objects.equals(kod, units.kod) &&
				Objects.equals(fKod, units.fKod);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, name, kod, fKod);
	}

	@Override
	public String toString() {
		return "Units{" +
				"id=" + id +
				", name='" + name + '\'' +
				", kod='" + kod + '\'' +
				", fKod='" + fKod + '\'' +
				'}';
	}
}
