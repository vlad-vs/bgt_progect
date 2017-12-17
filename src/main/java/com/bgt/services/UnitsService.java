package com.bgt.services;

import com.bgt.dao.UnitDao;
import com.bgt.entityes.guides.Units;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitsService {

	@Autowired
	UnitDao dao;

	public void addItem(Units unit, Units pUnit) {
		if (!dao.findUnit(unit)) {
			if (pUnit==null){
				unit.setfKod("U." + unit.getKod() + ".");
			} else {
				unit.setfKod(pUnit.getfKod() + unit.getKod() + ".");
			}
		}
		dao.addItem(unit);
	}

	public void upItem(int id, String name, String kod) {
		Units unit = dao.getUnitById(id);
		unit.setfKod(kod);
		unit.setName(name);
		dao.updateUnit(unit);
	}

	public List<Units> getAllItems() {
		return dao.getAllUnits();
	}

	public Units getUnitByName(String name) {
		return dao.getUnitByName(name);
	}

	public void delItemBiId(int id){
		dao.delItemById(id);
	}
}
