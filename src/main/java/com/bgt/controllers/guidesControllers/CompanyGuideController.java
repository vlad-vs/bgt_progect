package com.bgt.controllers.guidesControllers;

import com.bgt.entityes.guides.CompaniesGuide;
import com.bgt.entityes.guides.YearGuide;
import com.bgt.services.GuidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Column;

@Controller
public class CompanyGuideController {

	@Autowired
	GuidesService service;

	@RequestMapping(value = "/companyGuide", method = RequestMethod.GET)
	public String getAllCompanyGuideItems(Model model){
		model.addAttribute("list",service.getAllCompanyItems());
		return "/companyGuide";
	}

	@RequestMapping(value = "/addCompanyGuideItem",method = RequestMethod.POST)
	public String addCompanyGuideItem(@RequestParam("kodItem") String kodItem,
								   @RequestParam ("item") String item) {
		service.addCompanyItem(new CompaniesGuide(kodItem,item));

		return "redirect:/companyGuide";
	}
	@RequestMapping(value = "/companyGuide/del/{id}")
	public String deleteCompanyItem(@PathVariable int id){
		service.delCompanyItem(id);
		return "redirect:/companyGuide";

	}
}
