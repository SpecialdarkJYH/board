package kr.co.spd.main.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.spd.user.dto.UserDTO;
import kr.co.spd.user.service.IUserService;



@Controller
public class JoinController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired private IUserService userServiceImpl = null;
	
	/*
	   회원가입 페이지로 이동
	 */
	@RequestMapping(value="/join", method =RequestMethod.GET)
	public String goJoin() {
		
		
		return "main/join";
		
	}
	
	/*

	회원가입
	 */
	@RequestMapping(value="/join", method =RequestMethod.POST)
	public String doJoin(Model model, UserDTO _userDTO) {
		
		logger.debug("==>" +_userDTO);
		_userDTO.setStatus(9);			// 회원가입시 바로 승인 처리
		userServiceImpl.write(_userDTO);
		
		model.addAttribute("name", _userDTO.getName());
		
		return "main/joinok";
		
	}
	
	/*
	 * ID 체크
	 * @return "Y": 사용가능, "N" : 사용 불가능
	 */
	@ResponseBody
	@RequestMapping(value="/join/id/available", method =RequestMethod.POST)
	public String checkId(@RequestParam("lgnId") String _lgnId) {
		logger.debug("====>" + userServiceImpl.isAvailableId(_lgnId));
		return userServiceImpl.isAvailableId(_lgnId);
		
	}
	
	/*
	 * Email 체크
	 * @return "Y": 사용가능, "N" : 사용 불가능
	 */
	@ResponseBody
	@RequestMapping(value="/join/email/available", method =RequestMethod.POST)
	public String checkEmail(@RequestParam("email") String _email) {
		
		return userServiceImpl.isAvailableId2(_email);
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/join/validateRecaptcha", method = RequestMethod.POST)
	public String validateRecaptcha(@RequestParam Map<String, String> paramMap) {
	     
	  return userServiceImpl.captcha(paramMap);
	 
	}
	
}
