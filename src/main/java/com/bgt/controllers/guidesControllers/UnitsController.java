package com.bgt.controllers.guidesControllers;

import com.bgt.entityes.guides.Units;
import com.bgt.services.UnitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.List;

@Controller
public class UnitsController {

	@Autowired
	UnitsService service;

	@RequestMapping(value = "/units", method = RequestMethod.GET)
	public String getUnitPage(Model model) {
		List<Units> listUnits = service.getAllItems();
		model.addAttribute("list", listUnits);
		model.addAttribute("unitNames",listUnits);
		return "/units";
	}

	@RequestMapping(value = "/addUnit", method = RequestMethod.POST)
	public String addUnit(@RequestParam("ParentName") String pName,
						  @RequestParam("UnitKod") String kod,
						  @RequestParam("UnitName") String name,
						  Model model) {
		String returnStr = "redirect:/units";
		try {
			Units unit = new Units(name,kod);
			Units unitParent = service.getUnitByName(pName);
			service.addItem(unit,unitParent);

		}catch (DataIntegrityViolationException e){
			e.printStackTrace();
			model.addAttribute("error","Введено уже существующее наименование подразделения или код");
			model.addAttribute("errorHelp","Вернитесь на предыдущую строку и проверьте поля КОД и НАИМЕНОВАНИЕ");
			returnStr = "/exemption";
		}
		return returnStr;
	}

	@RequestMapping(value = "/unit/del/{id}",method = RequestMethod.POST)
	public String deleteUnit(@PathVariable ("id") int id){
		service.delItemBiId(id);
		return "redirect:/units";
	}

	@RequestMapping(value = "/unit/up/{id}",method = RequestMethod.POST)
	public String deleteUnit(@PathVariable ("id") int id,
						   @RequestParam ("Name") String name,
						   @RequestParam ("fKod") String fKod) {
		service.upItem(id,name,fKod);

		return "redirect:/units";
	}

}
