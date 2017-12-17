package com.bgt.controllers.guidesControllers;

import com.bgt.dao.ProfitAndLossGuideDao;
import com.bgt.entityes.guides.ProfitAndLossGuide;
import com.bgt.services.GuidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProfitAndLossGuideController {


	@Autowired
	GuidesService service;

	@RequestMapping(value = "/profitAndLossGuide", method = RequestMethod.GET)
	public String profitAndLossGuide(Model model){
		List <ProfitAndLossGuide> list = service.getAllPlItems();
		model.addAttribute("listPlItems", list);

		return "/profitAndLossGuide";
	}

	@RequestMapping(value = "/profitAndLossGuide/del/{id}")
	public String deleteprofitAndLossItemById(@PathVariable int id){
		service.delPlItem(id);
		return "redirect:/profitAndLossGuide";
	}

	@RequestMapping(value = "/addProfitAndLossItem", method = RequestMethod.POST)
	public String addProfitAndLossItem(@RequestParam ("kodItem") String kod,
									   @RequestParam ("item") String item,
									   @RequestParam ("type") String type,
									   @RequestParam (value = "level", defaultValue = "false") Boolean level){
		service.addPlItem(new ProfitAndLossGuide(kod,item,type,level));
		return "redirect:/profitAndLossGuide";
	}

	@RequestMapping(value = "/profitAndLossGuide/update/{id}:{item}:{type}:{kod}:{level}", method = RequestMethod.POST)
	public String updateProfitAndLossItem(@PathVariable int id,
										@PathVariable String kod,
									   @PathVariable String item,
									   @PathVariable String type,
									   @PathVariable boolean level){
		service.updatePlItem(new ProfitAndLossGuide(id,kod,item,type,level));
		return "redirect:/profitAndLossGuide";
	}
}
