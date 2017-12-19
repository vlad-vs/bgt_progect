package com.bgt.controllers.bgtControllers;

import com.bgt.services.GuidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StandartBgtController {

	@Autowired
	GuidesService service;

	@RequestMapping(value = "/standartBgt",method = RequestMethod.GET)
	public String getStandartBgtPage(Model m){
		m.addAttribute("listYears",service.getAllYearItems());
		m.addAttribute("bgtNames",service.getAllBtgItems());
		return "/standartBgt";
	}

}
