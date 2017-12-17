package com.bgt.controllers.guidesControllers;

import com.bgt.dao.CurrencuGuideDao;
import com.bgt.entityes.guides.CurrencyGuide;
import com.bgt.services.GuidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyGuideController {

	@Autowired
	GuidesService service;

	@RequestMapping(value = "/currencyGuide",method = RequestMethod.GET)
	public String getCurrencyGuide(Model model){
		model.addAttribute("list",service.getAllCurrencyItems());
		return "/currencyGuide";
	}

	@RequestMapping(value = "/addCurrencyGuideItem",method = RequestMethod.POST)
	public String getCurrencyGuide(@RequestParam("shortItem") String shortName,
									@RequestParam ("fullItem")  String fullName){
		service.addCurrencyItem(new CurrencyGuide(shortName,fullName));
		return "redirect:/currencyGuide";
	}


}

