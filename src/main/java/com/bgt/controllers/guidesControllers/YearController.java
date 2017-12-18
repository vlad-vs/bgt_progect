package com.bgt.controllers.guidesControllers;

import com.bgt.entityes.guides.Year;
import com.bgt.services.GuidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class YearController {

	@Autowired
	GuidesService service;

	@RequestMapping(value = "/yearGuide",method = RequestMethod.GET)
	public String getYearGuide(Model model){
		model.addAttribute("list",service.getAllYearItems());
		return "/yearGuide";
	}

	@RequestMapping(value = "addYearGuideItem",method = RequestMethod.POST)
	public String addYearGuideItem(@RequestParam ("item") int item) {
		service.addYearItem(new Year(item));

		return "redirect:/yearGuide";
	}
	@RequestMapping(value = "/yearGuide/del/{id}")
	public String deleteYearItem(@PathVariable int id){
		service.delYearItem(id);
		return "redirect:/yearGuide";

	}
}

