package com.bgt.controllers.guidesControllers;


import com.bgt.dao.UsersDao;
import com.bgt.entityes.User;
import com.bgt.services.impl.UserService;
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
	UserService service;

    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);


    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public ModelAndView addUserToBase(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/users");
        List users = service.getAllItems();
        modelAndView.addObject("list",users);

//        logger.info("============================================================>>>> end setUserToData");

        return modelAndView;
    }

	@RequestMapping(value = "/addUser",method = RequestMethod.POST)
	public String addUserToBase(@RequestParam ("UserName") String userName,
								@RequestParam ("UserSecondName") String userSecondName,
								@RequestParam ("UserPassword") String userPassword){
		service.addItem(new User(userName,userSecondName,userPassword));
		return "redirect:/users";
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

	@RequestMapping(value = "/deleteUser/{id}",method = RequestMethod.POST)
	public String deleteUser(@PathVariable ("id") int id) {
		service.deleteItemById(id);
		return "redirect:/users";
	}
	@RequestMapping(value = "/updateUser/{id}",method = RequestMethod.POST)
	public String updateUser(@PathVariable ("id") int id,
							 @RequestParam ("name") String name,
							 @RequestParam ("secondName") String secondName,
							 @RequestParam ("password") String password) {
		service.updateItem(id,name,secondName,password);
		return "redirect:/users";
	}

}
