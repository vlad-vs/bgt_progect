package com.bgt.services.impl;

import com.bgt.dao.UnitDao;
import com.bgt.entityes.guides.Units;
import com.bgt.services.UnitServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitsService implements UnitServiceInterface {

	@Autowired
	UnitDao dao;

	@Override
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

	@Override
	public void updateItem(int id, String name, String kod) {
		Units unit = dao.getUnitById(id);
		unit.setfKod(kod);
		unit.setName(name);
		dao.updateUnit(unit);
	}

	@Override
	public List<Units> getAllItems() {
		return dao.getAllUnits();
	}

	@Override
	public Units getItemByName(String name) {
		return dao.getUnitByName(name);
	}

	@Override
	public void deleteItemById(int id){
		dao.delItemById(id);
	}

}
