package com.bgt.controllers.guidesControllers;


import com.bgt.entityes.guides.CashFlowGuide;
import com.bgt.services.CashFlowService;
import com.bgt.services.GuidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CashFlowController {

	@Autowired
	CashFlowService service;

	@RequestMapping(value = "/cashFlowGuide", method = RequestMethod.GET)
	public String getCashFlowGuide(Model model){
		model.addAttribute("list",service.getAllItems());
		return "/cashFlowGuide";
	}

	@RequestMapping(value = "/addCashFlowItem", method = RequestMethod.POST)
	public String addCashFlowItem(@RequestParam ("kodItem") String kodItem,
										@RequestParam ("item") String cashFlowItem,
										@RequestParam (value = "level", defaultValue = "false") Boolean cashFlowItemLavel) {
		service.addItem(new CashFlowGuide(kodItem,cashFlowItem,cashFlowItemLavel));
		return "redirect:/cashFlowGuide";
	}

	@RequestMapping(value = "/cashFlowGuide/del/{id}", method = RequestMethod.POST)
	public String getCashFlowGuide(@PathVariable ("id") int id){
		service.delItemById(id);
		return "redirect:/cashFlowGuide";
	}

//	@RequestMapping(value = "/cashFlowGuide/up/{id}", method = RequestMethod.POST)
//	public String getCashFlowGuidePage(@PathVariable ("id") CashFlowGuide id,
//									   @RequestParam ("nameCf") String nameCf,
//									   @RequestParam ("fKodCf") String fKodCf){
//		service.updateItem(id,nameCf,fKodCf);
//		return "redirect:/cashFlowGuide";
//	}
}
