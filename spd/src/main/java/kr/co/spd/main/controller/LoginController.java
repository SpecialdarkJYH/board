package kr.co.spd.main.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nl.captcha.Captcha;

/*
 * Login
 * 
 * */

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	/*
	 * 로그인페이지로 이동
	 * @return
	 * 
	 * */
	
	@RequestMapping(value="/login", method =RequestMethod.GET)
	public String login() {
		return "main/login";
		
	}
}
