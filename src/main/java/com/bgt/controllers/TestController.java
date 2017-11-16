package com.bgt.controllers;


import com.bgt.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    UserDao dao;

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String test(){
        logger.info("==============================>>>> public View test");
        return "index";
    }

    @RequestMapping(value = "/addToBase",method = RequestMethod.GET)
    public ModelAndView toAddUserToBase(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        List users = dao.findAllUsers();
        modelAndView.addObject("list",users);

        logger.info("============================================================>>>> end setUserToData");

        return modelAndView;
    }

//	@RequestMapping(value = "/addToBase/{itemId}/{UserName}/{iteUserFamylimId}/{UserPassword}",method = RequestMethod.GET)
	@RequestMapping(value = "/addUser",method = RequestMethod.GET)
	public String addUserToBase(@RequestParam ("itemId") Integer itemId,
								@RequestParam ("UserName") String UserName,
								@RequestParam ("iteUserFamylimId") String UserFamyli,
								@RequestParam ("UserPassword") String UserPassword){

		logger.info("==============================>>>> public View addUserToBase +++ " + itemId + UserName);

		return "index";
	}

	@RequestMapping(value = "/delUser",method = RequestMethod.POST)
	public String delUserFromBase(){
		logger.info("==============================>>>> public View delUserFromBase");

		return "index";
	}
}
