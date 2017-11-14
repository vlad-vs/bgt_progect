package com.bgt.controllers;


import com.bgt.dao.UserDao;
import com.bgt.entityes.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    public String toAddToBase(){

        User user = new User(132,"Vlad","Vlad","pass");
        logger.error("============================================================>>>> setUserToData");
        dao.setUserToData(user);
        logger.error("============================================================>>>> end setUserToData");

        return "addToBase";
    }
}
