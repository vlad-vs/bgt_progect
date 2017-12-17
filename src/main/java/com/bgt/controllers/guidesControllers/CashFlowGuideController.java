package com.bgt.controllers.guidesControllers;


import com.bgt.entityes.guides.CashFlowGuide;
import com.bgt.services.CashFlowService;
import com.bgt.services.GuidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CashFlowGuideController {

	@Autowired
	CashFlowService service;

	@RequestMapping(value = "/cashFlowGuide", method = RequestMethod.GET)
	public String getCashFlowGuidePage(Model model){
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

	@RequestMapping(value = "/cashFlowGuide/del/{ID_CF}", method = RequestMethod.POST)
	public String getCashFlowGuidePage(@PathVariable int ID_CF){
		service.delItemById(ID_CF);
		return "redirect:/cashFlowGuide";
	}



//	@RequestMapping(value = "/cashFlowGuide/up/{ID_CF}", method = RequestMethod.GET)
//	public String getCashFlowGuidePage(@PathVariable int ID_CF,
//									   @RequestParam ("kodItemNew") String kodItem,
//									   @RequestParam ("itemNew") String cashFlowItem,
//									   @RequestParam (value = "levelNew") boolean cashFlowItemLavel){
//		service.updateItem(new CashFlowGuide(ID_CF,kodItem,cashFlowItem,cashFlowItemLavel));
//		return "redirect:/cashFlowGuide";
//	}

	@RequestMapping(value = "/cashFlowGuide/up/{ID_CF}", method = RequestMethod.POST)
	public String getCashFlowGuidePage(@ModelAttribute ("cfModel") CashFlowGuide cfModel){
		service.updateItem(cfModel);
		return "redirect:/cashFlowGuide";
	}
}
