package com.bgt.controllers.guidesControllers;


import com.bgt.entityes.guides.Balance;
import com.bgt.entityes.guides.CashFlow;
import com.bgt.services.impl.BalanceService;
import com.bgt.services.impl.CashFlowService;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BalanceController {

	@Autowired
	BalanceService service;

	@RequestMapping(value = "/balance", method = RequestMethod.GET)
	public String getCashFlowGuide(Model model) {
		model.addAttribute("list", service.getAllItems());
		return "/balance";
	}

	@RequestMapping(value = "/addBalance", method = RequestMethod.POST)
	public String addCashFlowItem(@RequestParam("kodItem") String kodItem,
								  @RequestParam("item") String item,
								  @RequestParam("fItemName") String fItemName,
								  Model model) {

		String returnStr = "redirect:/balance";
		try {
			Balance bl = new Balance(kodItem, item );
			Balance fBl = service.getItemByName(fItemName);
			service.addItem(bl, fBl);
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			model.addAttribute("error", "Введено уже существующее наименование подразделения или код");
			model.addAttribute("errorHelp", "Вернитесь на предыдущую строку и проверьте поля КОД и НАИМЕНОВАНИЕ");
			returnStr = "/exemption";
		}
		return returnStr;
	}

	@RequestMapping(value = "/balance/del/{id}", method = RequestMethod.POST)
	public String deleteCashFlowItem(@PathVariable("id") int id) {
		service.deleteItemById(id);
		return "redirect:/balance";
	}

	@RequestMapping(value = "/balance/up/{id}", method = RequestMethod.POST)
	public String updateCashFlowItem(@PathVariable("id") int id,
								   @RequestParam("fKod") String fKod,
								   @RequestParam("name") String name) {
		service.updateItem(id, fKod, name);
		return "redirect:/balance";
	}

}
