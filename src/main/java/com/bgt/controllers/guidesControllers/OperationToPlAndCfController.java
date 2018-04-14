package com.bgt.controllers.guidesControllers;


import com.bgt.entityes.guides.CashFlow;
import com.bgt.entityes.guides.OperationToPlAndCfReport;
import com.bgt.services.impl.CashFlowService;
import com.bgt.services.impl.OperationToPlAndCfReportService;
import com.bgt.services.impl.ProfitAndLossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OperationToPlAndCfController {

	@Autowired
	OperationToPlAndCfReportService operationService;

	@Autowired
	ProfitAndLossService plService;

	@Autowired
	CashFlowService cfService;

	@RequestMapping(value = "/operationToPlAndCf", method = RequestMethod.GET)
	public String getOperationToPlAndCfReport(Model model) {
		model.addAttribute("operationList", operationService.getAllItems());
		model.addAttribute("plList",plService.getAllItems());
		model.addAttribute("cfList",cfService.getAllItems());
		return "/operationToPlAndCf";
	}

	@RequestMapping(value = "/addOperationToPlAndCf", method = RequestMethod.POST)
	public String addOperationToPlAndCfReportItem(@RequestParam("kodItem") String kodItem,
												  @RequestParam("item") String item,
												  @RequestParam("idPl") int idPl,
												  @RequestParam("idCf") int idCf,
												  @RequestParam("fItemName") String fItemName,
												  Model model) {

		String returnStr = "redirect:/operationToPlAndCf";
		try {
			OperationToPlAndCfReport cf = new OperationToPlAndCfReport(kodItem, item, idPl,idCf);
			OperationToPlAndCfReport fCf = operationService.getItemByName(fItemName);
			operationService.addItem(cf, fCf);
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			model.addAttribute("error", "Введено уже существующее наименование подразделения или код");
			model.addAttribute("errorHelp", "Вернитесь на предыдущую строку и проверьте поля КОД и НАИМЕНОВАНИЕ");
			returnStr = "/exemption";
		}

		return returnStr;
	}

	@RequestMapping(value = "/operationToPlAndCf/del/{id}", method = RequestMethod.POST)
	public String deleteOperationToPlAndCfReportItem(@PathVariable("id") int id) {
		operationService.deleteItemById(id);
		return "redirect:/operationToPlAndCfReport";
	}

//	@RequestMapping(value = "/operationToPlAndCfReport/up/{id}", method = RequestMethod.POST)
//	public String updateOperationToPlAndCfReportItem(@PathVariable("id") int id,
//								   @RequestParam("fKod") String fKod,
//								   @RequestParam("name") String name,
//								   @RequestParam(value = "level") boolean level) {
//		operationService.updateItem(id, name, fKod, level);
//		return "redirect:/operationToPlAndCfReport";
//	}

}
