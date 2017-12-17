package com.bgt.controllers.guidesControllers;

import com.bgt.entityes.guides.BgtGuide;
import com.bgt.entityes.guides.YearGuide;
import com.bgt.services.GuidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BgtGuideController {

	@Autowired
	GuidesService service;

	@RequestMapping(value = "/bgtGuide",method = RequestMethod.GET)
	public String getBgtGuide(Model model){
		model.addAttribute("list",service.getAllBtgItems());
		return "/bgtGuide";
	}

	@RequestMapping(value = "/addBgtGuideItem",method = RequestMethod.POST)
	public String addBgtGuideItem(@RequestParam ("kodItemBgt") String item,
								  @RequestParam ("bgtName") String bgtName) {
		service.addBgtItem(new BgtGuide(item,bgtName));
		return "redirect:/bgtGuide";
	}
	@RequestMapping(value = "/bgtGuide/del/{id}")
	public String deleteBgtItem(@PathVariable int id){
		service.delYearItem(id);
		return "redirect:/bgtGuide";

	}
}

