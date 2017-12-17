package com.bgt.dao;

import com.bgt.entityes.guides.Units;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class UnitDao {

	@PersistenceContext
	EntityManager entityManager;


	@Transactional
	public void addItem(Units unit) {
		entityManager.persist(unit);
	}

	@Transactional
	public void delItemById(int id) {
		Units units = getUnitById(id);
		entityManager.remove(units);
	}

	@Transactional
	public void updateUnit(Units unit) {
		entityManager.merge(unit);
	}

	@Transactional
	public Units getUnitById(int id) {
		Units units = entityManager.find(Units.class, id);
		return units;
	}

	@Transactional
	public Units getUnitByName(String name) {
		Units units = null;
		if (!name.equals("")) {
			String q = "SELECT * FROM UNITS WHERE NAME_U=:name";
			Query query = entityManager.createNativeQuery(q, Units.class);
			query.setParameter("name", name);
			List<Units> list= query.getResultList();
			if (!list.isEmpty()) {
				units = list.get(0);
			}

		}
		return units;
	}

	@Transactional
	public List<Units> getAllUnits() {
		String q = "SELECT * FROM UNITS ORDER BY F_KOD_U";
		Query query = entityManager.createNativeQuery(q, Units.class);
		return query.getResultList();
	}

	public boolean findUnit(Units unit){
		boolean b;
		Units unitFinded = entityManager.find(Units.class,unit.getId());
		if (unitFinded==null) {
			b = false;
		} else b = true;
		return b;
	}

}
