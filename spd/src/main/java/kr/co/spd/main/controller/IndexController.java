package kr.co.spd.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.spd.user.service.IUserService;

/*
 * Index
 * 
 * */

@Controller
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired private IUserService userServiceImpl = null;
	
	
	@RequestMapping(value="/", method =RequestMethod.GET)
	public String index() {
		
		
		return "main/index";
		
	}
}
