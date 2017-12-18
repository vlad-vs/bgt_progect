package com.bgt.controllers;

import com.bgt.entityes.guides.CashFlow;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexPageController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndexPage(){
		return "/index";
	}


	@RequestMapping(value="/cfItem", method=RequestMethod.POST)
	public String greetingSubmit(@ModelAttribute ("cfItem") CashFlow cfItem, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("bnError========================================================");
		} else model.addAttribute("cfItem", cfItem);
		return "/index";
	}

}
