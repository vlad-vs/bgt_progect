package com.bgt.controllers.guidesControllers;


import com.bgt.dao.UsersGideDao;
import com.bgt.entityes.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
	UsersGideDao dao;

    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);


    @RequestMapping(value = "/usersGuide",method = RequestMethod.GET)
    public ModelAndView toAddUserToBase(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/usersGuide");
        List users = dao.findAllUsers();
        modelAndView.addObject("list",users);

        logger.info("============================================================>>>> end setUserToData");

        return modelAndView;
    }

//	@RequestMapping(value = "/addToBase/{itemId}/{UserName}/{iteUserFamylimId}/{UserPassword}",method = RequestMethod.GET)
	@RequestMapping(value = "/addRefreshUser",method = RequestMethod.POST)
	public String addUserToBase(@RequestParam ("UserName") String userName,
								@RequestParam ("UserSecondName") String userSecondName,
								@RequestParam ("UserPassword") String userPassword){
    	dao.insertUserToData(new User(userName,userSecondName,userPassword));
		System.out.println("hello new " + userName);

		return "redirect:/usersGuide";
	}

//	@RequestMapping(value = "/delUser}",method = RequestMethod.POST)
//	public String delUserFromBase(@RequestParam ("itemId") int itemId) {
//
//		User user = dao.delUsersById(itemId);
//		if (user == null) {
//			System.out.println("user not found");
//		}
//		else {
//			System.out.println(user.getName() + "deleyted");
//			logger.info("==============================>>>> public View delUserFromBase");
//		}
//		return "redirect:/usersGuide";
//	}

	@RequestMapping(value = "/delUser/{itemId}",method = RequestMethod.POST)
	public String delUserFromBase(@PathVariable ("itemId") int itemId) {

		User user = dao.delUsersById(itemId);
		if (user == null) {
			System.out.println("user not found");
		}
		else {
			System.out.println(user.getName() + "deleyted");
			logger.info("==============================>>>> public View delUserFromBase");
		}
		return "redirect:/usersGuide";
	}
}
