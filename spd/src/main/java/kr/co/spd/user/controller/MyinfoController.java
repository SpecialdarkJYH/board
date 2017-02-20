package kr.co.spd.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.spd.board.dao.IBoardDocDAO;
import kr.co.spd.board.dto.BoardDocDTO;
import kr.co.spd.board.dto.BoardSearchDTO;
import kr.co.spd.common.security.SecuritySession;
import kr.co.spd.user.dto.UserDTO;
import kr.co.spd.user.service.IUserService;

@Controller
public class MyinfoController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyinfoController.class);
	
	@Autowired private IUserService userServiceImpl = null;
	@Autowired private IBoardDocDAO boardDocDAOImpl = null;
	
	/*
	   비밀번호 확인 뒤 회원정보 페이지로 이동
	 */
	@RequestMapping(value="/myinfocheck", method=RequestMethod.GET)
	public String gomyinfocheck() {
		
		return "main/myinfocheck";
	}
	
	/*
	   비밀번호 확인
	 */
	@ResponseBody
	@RequestMapping(value="/login/myinfocheck", method=RequestMethod.POST)
	public String domyinfocheck(@RequestParam("lgnId") String lgnId, @RequestParam("lgnPw") String lgnPw) {
		
		return userServiceImpl.myinfocheck(lgnId, lgnPw);
	}
	
	/*
	   비밀번호 확인하고 회원정보 페이지로 이동
	 */
	@RequestMapping(value="/myinfocheck", method=RequestMethod.POST)
	public String gomyinfo() {
		
		return "main/info";
	}
	
	/*
	   회원정보 
	 */
	@RequestMapping(value="/info", method=RequestMethod.GET)
	public String info() {
		
		return "main/info";
	}
	
	/*
	   회원정보 수정 페이지로 이동
	 */
	@RequestMapping(value="/myinfo", method=RequestMethod.GET)
	public String myinfo() {
		
		return "main/myinfo";
	}
	
	/*
		회원수정
	 */
	@RequestMapping(value="/myinfo", method =RequestMethod.POST)
	public String domyinfo(Model model, UserDTO _userDTO) {
		
		logger.debug("==>" +_userDTO);
		
		_userDTO.setStatus(9);
		userServiceImpl.edit(_userDTO);
		
		model.addAttribute("name", _userDTO.getName());
		
		return "main/myinfook";
		
	}
	
	/*
		비밀번호수정 페이지로 이동
	*/
	@RequestMapping(value="/relgnpw", method=RequestMethod.GET)
	public String relgnpw() {
		
		return "main/relgnpw";
	}
	
	/*
		비밀번호수정
	*/
	@RequestMapping(value="/relgnpw", method =RequestMethod.POST)
	public String dorelgnpw(Model model, UserDTO _userDTO) {
		
		userServiceImpl.repw(_userDTO);
		logger.debug("======>relgnpw" +_userDTO);
		
		model.addAttribute("name", _userDTO.getName());
		
		return "main/relgnpwok";
		
	}
	
	
	//내글보기
	@RequestMapping(value="/mywrite" , method=RequestMethod.GET)
	public String myWrite(Model model, @ModelAttribute("search") BoardSearchDTO search) {
		
		// 1. 전체 게시물 갯수 가져오기
		int cnt = boardDocDAOImpl.selectCount(search);
		search.setTotal(cnt);
		
		search.setUserId(SecuritySession.getCurrentUser().getUserId());
		
		List<BoardDocDTO> list = boardDocDAOImpl.mywrite(search);
		model.addAttribute("mywrite", list);
		
		return "main/mywrite";
	}
	
}
