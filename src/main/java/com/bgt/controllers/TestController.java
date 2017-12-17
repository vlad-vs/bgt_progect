package com.bgt.controllers;

import com.bgt.entityes.guides.Cfo1Guide;
import com.bgt.entityes.guides.UnitsGuide;
import com.bgt.services.GuidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.Column;
import java.util.List;

@Controller
public class TestController {

	@Autowired
	GuidesService service;

	@RequestMapping(value = "/test",method = RequestMethod.GET)
	public String getTest(){

		Cfo1Guide cfo1Guideitem = new Cfo1Guide("cfo-4","Acouting4");

		service.addCfo1Item(cfo1Guideitem);

		UnitsGuide unit = new UnitsGuide("unit-1","CompanyName1");

		UnitsGuide unit2 = (UnitsGuide) service.getUnitByKod(unit.getKodUnit());

//		unit2.getCfo1Guid().add(cfo1Guideitem);

		if (unit2!=null) {
			List <Cfo1Guide> t = unit2.getCfo1Guid();
			t.add(cfo1Guideitem);
			unit2.setCfo1Guid(t);
			service.updateUnitItem(unit2);

		} else {
			unit.getCfo1Guid().add(cfo1Guideitem);
			service.addUnitItem(unit);
		}





		return "/index";
	}
}
