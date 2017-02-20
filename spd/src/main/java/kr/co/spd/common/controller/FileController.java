package kr.co.spd.common.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.spd.board.dao.IBoardFileDAO;
import kr.co.spd.board.dto.BoardFileDTO;
import kr.co.spd.common.file.FileService;

@RequestMapping("/file")
@Controller
public class FileController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	@Autowired private FileService fileService = null;
	@Autowired private IBoardFileDAO boardFileDAOImpl = null;
	
	@RequestMapping(value="/download", method=RequestMethod.GET)
	public void download(@RequestParam("fileId")Integer fileId
			, HttpServletResponse response, HttpSession httpSession) {
		
		BoardFileDTO bfDTO = boardFileDAOImpl.selectOne(fileId);
		fileService.downloadFile(response, httpSession, bfDTO);
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void view(Model model, @RequestParam("docId")Integer docId) {
		
		List<BoardFileDTO> fList = boardFileDAOImpl.selectList(docId);
		model.addAttribute("fList", fList);
	}
}
