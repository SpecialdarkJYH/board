package kr.co.spd.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.spd.board.dto.BoardMapDTO;
import kr.co.spd.board.service.IBoardMapService;

@RequestMapping("/board/map")
@Controller
public class BoardMapController {

	@Autowired private IBoardMapService boardServiceImpl = null;
	
	@ResponseBody
	@RequestMapping(value="/list.json", method=RequestMethod.POST)
	public List<BoardMapDTO> list(){
		
		List<BoardMapDTO> list = boardServiceImpl.list();
		
		return list;
	}
	
}
