package kr.co.spd.common.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import nl.captcha.Captcha;
import nl.captcha.servlet.CaptchaServletUtil;

@RequestMapping("/captcha")
@Controller
public class CaptchaController {
	
	private static final Logger logger = LoggerFactory.getLogger(CaptchaController.class);
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public void index(HttpServletResponse response, HttpSession session) {
		
		Captcha captcha = new Captcha.Builder(148, 48)
				.addText() 				// default: 5개의 숫자 + 문자
				.addNoise().addNoise() 	// 시야 방해 라인 2개
				.addBackground()		// 기본 하얀색 배경
				.build();
		
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Max-Age", 0);
		response.setContentType("image/png");
		CaptchaServletUtil.writeImage(response, captcha.getImage()); 	//이미지 그리기
		session.setAttribute("captcha", captcha.getAnswer());			// 값 저장		
		
	}
	

	@ResponseBody
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public String validateRecaptcha(@RequestParam("captcha") String captcha, HttpSession session) {
		
		String answer = (String)session.getAttribute("captcha");
		
		if(answer.equals(captcha)) {
			
			return "Y";
			
		} 
			return "N";
		
	 
	}
	
}
