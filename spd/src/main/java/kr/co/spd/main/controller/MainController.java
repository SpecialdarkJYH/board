package kr.co.spd.main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.spd.board.dao.IBoardDocDAO;
import kr.co.spd.board.dao.IBoardFileDAO;
import kr.co.spd.board.dao.IBoardMemoDAO;
import kr.co.spd.board.dto.BoardDocDTO;
import kr.co.spd.board.dto.BoardFileDTO;
import kr.co.spd.board.dto.BoardMemoDTO;
import kr.co.spd.board.dto.BoardSearchDTO;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired private IBoardDocDAO boardDocDAOImpl = null;
	@Autowired private IBoardMemoDAO boardMemoDAOImpl = null;
	@Autowired private IBoardFileDAO boardFileDAOImpl = null;
	
	@RequestMapping(value="/main/index", method=RequestMethod.GET)
	public String main() {
		
		return "main/main";
	}
	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String admin() {
		
		return "main/admin";
	}
	
	// 최신글순
	@RequestMapping(value = "/main/newdoc.json", method = RequestMethod.POST)
	public void newDoc(Model model) {
		
		logger.debug("==> 최신글을 보자");
		
		List<BoardDocDTO> list = boardDocDAOImpl.newDoc();
		model.addAttribute("list", list);
		
		//첨부파일 가져오기
		for(BoardDocDTO _boardDocDTO : list) {
			
			List<BoardFileDTO> fList = boardFileDAOImpl.selectList(_boardDocDTO.getDocId());
			_boardDocDTO.setfList(fList);
			
		}
		
		
	}
	
	// 최신댓글순
	@RequestMapping(value = "/main/newmemo.json", method = RequestMethod.POST)
	public void newMemo(Model model) {
		
		logger.debug("==> 최신메모을 보자");
		
		List<BoardMemoDTO> list = boardMemoDAOImpl.newMemo();
		model.addAttribute("list", list);
		
	}
	
	
	
	
	//메인리스트 만든거, 메뉴에는 없다// 임시용
	@RequestMapping(value="/mainlist", method=RequestMethod.GET)
	public String mainlist(Model model, @ModelAttribute("search") BoardSearchDTO search) throws Exception {
		
		// 1. 전체 게시물 갯수 가져오기
		int cnt = boardDocDAOImpl.selectCount(search);
		search.setTotal(cnt);
		
		List<BoardDocDTO> list = boardDocDAOImpl.allView(search);
		model.addAttribute("list", list);
		
		
		return "main/mainlist";
		
	}
	
	
	
	
}
