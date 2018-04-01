package com.bgt.controllers.guidesControllers;


import com.alibaba.fastjson.JSON;
import com.bgt.entityes.guides.CashFlow;
import com.bgt.services.impl.CashFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CashFlowController {

	@Autowired
	CashFlowService service;

	@RequestMapping(value = "/cashFlow", method = RequestMethod.GET)
	public String getCashFlowGuide(Model model) {
		List list = service.getAllItems();
		String jsonString = JSON.toJSONString(list);

		System.err.println(list.get(0));
		System.out.println(list.get(0));

		model.addAttribute("jsonString", jsonString);


		model.addAttribute("list", list);
		return "/cashFlow";
	}

	@RequestMapping(value = "/addCashFlowItem", method = RequestMethod.POST)
	public String addCashFlowItem(@RequestParam("kodItem") String kodItem,
								  @RequestParam("item") String cashFlowItem,
								  @RequestParam(value = "level", defaultValue = "false") boolean cashFlowItemLavel,
								  @RequestParam("fItemName") String fItemName,
								  Model model) {

		String returnStr = "redirect:/cashFlow";
		try {
			CashFlow cf = new CashFlow(kodItem, cashFlowItem, cashFlowItemLavel);
			CashFlow fCf = service.getItemByName(fItemName);
			service.addItem(cf, fCf);
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			model.addAttribute("error", "Введено уже существующее наименование подразделения или код");
			model.addAttribute("errorHelp", "Вернитесь на предыдущую строку и проверьте поля КОД и НАИМЕНОВАНИЕ");
			returnStr = "/exemption";
		}

		return returnStr;
	}

	@RequestMapping(value = "/cashFlow/del/{id}", method = RequestMethod.POST)
	public String deleteCashFlowItem(@PathVariable("id") int id) {
		service.deleteItemById(id);
		return "redirect:/cashFlow";
	}

	@RequestMapping(value = "/cashFlow/up/{id}", method = RequestMethod.POST)
	public String updateCashFlowItem(@PathVariable("id") int id,
								   @RequestParam("fKod") String fKod,
								   @RequestParam("name") String name,
								   @RequestParam(value = "level") boolean level) {
		service.updateItem(id, name, fKod, level);
		return "redirect:/cashFlow";
	}


//	@RequestMapping(value = "/cashFlowGuide/up/{id}", method = RequestMethod.POST)
//	public String getCashFlowGuidePage(@PathVariable ("id") CashFlow id,
//									   @RequestParam ("nameCf") String nameCf,
//									   @RequestParam ("fKodCf") String fKodCf){
//		service.updateItem(id,nameCf,fKodCf);
//		return "redirect:/cashFlowGuide";
//	}
}
