package com.bgt.controllers.guidesControllers;

import com.bgt.entityes.guides.CashFlow;
import com.bgt.entityes.guides.ProfitAndLoss;
import com.bgt.services.GuidesService;
import com.bgt.services.impl.ProfitAndLossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProfitAndLossController {


	@Autowired
	ProfitAndLossService service;

	@RequestMapping(value = "/profitAndLoss", method = RequestMethod.GET)
	public String profitAndLossGuide(Model model) {
		List <ProfitAndLoss> list = service.getAllItems();
		model.addAttribute("list", list);
		return "/profitAndLoss";
	}

	@RequestMapping(value = "/profitAndLoss/del/{id}")
	public String deleteprofitAndLossItemById(@PathVariable int id){
		service.deleteItemById(id);
		return "redirect:/profitAndLoss";
	}

	@RequestMapping(value = "/addProfitAndLossItem", method = RequestMethod.POST)
	public String addProfitAndLossItem(@RequestParam ("kodItem") String kod,
									   @RequestParam ("fItemName") String fKodName,
									   @RequestParam ("item") String item,
									   @RequestParam ("type") String type,
									   @RequestParam (value = "level", defaultValue = "false") Boolean level,
									   Model model){
		String returnStr = "redirect:/profitAndLoss";
		try {
			ProfitAndLoss cf = new ProfitAndLoss(kod,item,type,level);
			ProfitAndLoss fCf = service.getItemByName(fKodName);
			service.addItem(cf, fCf);
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			model.addAttribute("error", "Введено уже существующее наименование подразделения или код");
			model.addAttribute("errorHelp", "Вернитесь на предыдущую строку и проверьте поля КОД и НАИМЕНОВАНИЕ");
			returnStr = "/exemption";
		}
		return returnStr;
	}

	@RequestMapping(value = "/profitAndLoss/up/{id}", method = RequestMethod.POST)
	public String updateProfitAndLossItem(@PathVariable int id,
										  @RequestParam ("fkodn") String fkod,
										  @RequestParam ("itemn")  String item,
										  @RequestParam ("typen")  String type,
										  @RequestParam ("leveln")  boolean level){
		service.updateItem(id,fkod,item,type,level);
		return "redirect:/profitAndLoss";
	}
}
