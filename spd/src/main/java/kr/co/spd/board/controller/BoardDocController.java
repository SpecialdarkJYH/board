package kr.co.spd.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.multipart.MultipartFile;

import kr.co.spd.board.dao.IBoardDocDAO;
import kr.co.spd.board.dao.IBoardFileDAO;
import kr.co.spd.board.dto.BoardDocDTO;
import kr.co.spd.board.dto.BoardFileDTO;
import kr.co.spd.board.dto.BoardMapDTO;
import kr.co.spd.board.dto.BoardMemoDTO;
import kr.co.spd.board.dto.BoardSearchDTO;
import kr.co.spd.board.service.IBoardDocService;
import kr.co.spd.board.service.IBoardMapService;
import kr.co.spd.board.service.IBoardMemoService;
import kr.co.spd.common.dto.ErrorDTO;
import kr.co.spd.common.security.SecuritySession;
import kr.co.spd.user.dto.UserDTO;

@RequestMapping("/board/doc")
@Controller
public class BoardDocController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDocController.class);

	@Autowired private IBoardDocService boardDocServiceImpl = null;
	@Autowired private IBoardMapService boardMapServiceImpl = null;
	@Autowired private IBoardMemoService boardMemoServiceImpl = null;
	
	@Autowired private IBoardFileDAO boardFileDAOImpl = null;
	@Autowired private IBoardDocDAO boardDocDAOImpl = null;
	
	//게시판 글 목록
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public void list(Model model, @ModelAttribute("search") BoardSearchDTO search
			/*@RequestParam("mapId") Integer mapId*/) {
		
		List<BoardDocDTO> list = boardDocServiceImpl.list(search);
		model.addAttribute("list", list);
			
		/*String title = boardMapServiceImpl.view(mapId).getMapNm();
		model.addAttribute("title", title);*/
			
		BoardMapDTO bmDTO = boardMapServiceImpl.view(search.getMapId());
		model.addAttribute("title2",bmDTO);
		
		/*model.addAttribute("search", search); 같은거다 위에거랑*/
		
		logger.debug("===> board/doc/list" +list);
		logger.debug("===> board/doc/list/////search" +search);
		
	}
	
	//게시판 글쓰기 페이지
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public void goWrite(Model model, @RequestParam("mapId") Integer mapId) throws Exception {
		
		BoardMapDTO bmDTO = boardMapServiceImpl.view(mapId);
		model.addAttribute("title2",bmDTO);
		
		
		
	}
	
	//게시판 글쓰기
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String doWrite(Model model, /*@RequestParam("mapId") Integer mapId,*/ BoardDocDTO _boardDocDTO
			, HttpSession httpSession/*,HttpSession session*/) {

		/*UserDTO userDTO = (UserDTO)session.getAttribute("user");*/
		
		/*BoardMapDTO bmDTO = boardMapServiceImpl.view(mapId);
		model.addAttribute("title2",bmDTO);*/
		
		/*UserDTO userDTO = SecuritySession.getCurrentUser();*/
		
		for(MultipartFile file : _boardDocDTO.getFiles()) {
			
			logger.debug("====>  filename  " +file.getOriginalFilename() + ", file size ===> " + file.getSize());
		}
		
		_boardDocDTO.setUserId(SecuritySession.getCurrentUser().getUserId());
		_boardDocDTO.setHit(0);
		boardDocServiceImpl.write(_boardDocDTO, httpSession);
		
		return "redirect:./view2?docId=" + _boardDocDTO.getDocId();
				
		/*list(model, _boardDocDTO.getMapId());*/
		/*return "/board/doc/list";*/ 
		
		/*"board/doc/writeok";*/
		
	}
	
	//게시판 보기
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public void view(Model model, @RequestParam("docId") Integer docId) {
		
		BoardDocDTO bdDTO = boardDocServiceImpl.view(docId);
		model.addAttribute("list", bdDTO);
		
		BoardMapDTO bmDTO = boardMapServiceImpl.view(bdDTO.getMapId());
		model.addAttribute("title2",bmDTO);
		
		List<BoardMemoDTO> mlist = boardMemoServiceImpl.list(docId);
		model.addAttribute("mlist",mlist);
		
	}
	
	//게시판 보기 2 ajax로 refresh
	@RequestMapping(value="/view2", method=RequestMethod.GET)
	public void view2(Model model, @RequestParam("docId") Integer docId) {
		
		BoardDocDTO bdDTO = boardDocServiceImpl.view(docId);
		model.addAttribute("list", bdDTO);
		
		BoardMapDTO bmDTO = boardMapServiceImpl.view(bdDTO.getMapId());
		model.addAttribute("title2",bmDTO);
		
	}
	
	//게시판 수정 페이지
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public void goEdit(Model model, @RequestParam("docId") Integer docId) {
		
		//1. 게시물 정보
		BoardDocDTO bdDTO = boardDocServiceImpl.view(docId);
		model.addAttribute("list", bdDTO);
		
		//2. 맵정보
		BoardMapDTO bmDTO = boardMapServiceImpl.view(bdDTO.getMapId());
		model.addAttribute("title2",bmDTO);
		
		//3. 권한체크
		UserDTO user = SecuritySession.getCurrentUser();
		
		ErrorDTO errorDTO =new ErrorDTO();
		
		if(user.getUserId().intValue() != bdDTO.getUserId().intValue()) {
			
			errorDTO.setCode(-1);
			errorDTO.setMsg("당신은 수정 할 권한이 없습니다. 확인바랍니다.");
			model.addAttribute("error", errorDTO);
		}
	}
	
	//게시판 수정
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String doEdit(Model model, BoardDocDTO _boardDocDTO, @RequestParam("docId") Integer docId, HttpSession httpSession) {
		
		//2. 게시물 정보
		BoardDocDTO bdDTO = boardDocServiceImpl.view(docId);
		model.addAttribute("list", bdDTO);
		
		//1. 맵정보
		BoardMapDTO bmDTO = boardMapServiceImpl.view(bdDTO.getMapId());
		model.addAttribute("title2",bmDTO);
		
		_boardDocDTO.setUserId(SecuritySession.getCurrentUser().getUserId());
		_boardDocDTO.setDocId(docId);
		boardDocServiceImpl.edit(_boardDocDTO, httpSession);
		
		/*list(model, bdDTO.getMapId());
		
		return "/board/doc/list";*/
		
		return "redirect:./view2?docId=" + _boardDocDTO.getDocId();
	}
	
	//게시글 삭제 로그인 확인 페이지
	@RequestMapping(value="/chkdelete", method=RequestMethod.GET)
	public void chkDelete(Model model, @RequestParam("docId") Integer docId) {
		
		BoardDocDTO bdDTO = boardDocServiceImpl.view(docId);
		model.addAttribute("list", bdDTO);
		
		BoardMapDTO bmDTO = boardMapServiceImpl.view(bdDTO.getMapId());
		model.addAttribute("title2",bmDTO);
		
	}
	
	//게시글 삭제 확인 페이지
	@RequestMapping(value="/chkdelete", method=RequestMethod.POST)
	public String goDelete(Model model, @RequestParam("docId") Integer docId) {
		
		BoardDocDTO bdDTO = boardDocServiceImpl.view(docId);
		model.addAttribute("list", bdDTO);
		
		BoardMapDTO bmDTO = boardMapServiceImpl.view(bdDTO.getMapId());
		model.addAttribute("title2",bmDTO);
		
		return "board/doc/delete";
	}
	
	//게시글 삭제 
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String doDelete(Model model, BoardDocDTO _boardDocDTO, @RequestParam("docId") Integer docId
			, @ModelAttribute("search") BoardSearchDTO search) {
		
		logger.debug("====> delete 삭제됐다");
		
		BoardDocDTO bdDTO = boardDocServiceImpl.view(docId);
		model.addAttribute("list", bdDTO);
		
		BoardMapDTO bmDTO = boardMapServiceImpl.view(bdDTO.getMapId());
		model.addAttribute("title2",bmDTO);
		
		_boardDocDTO.setUserId(SecuritySession.getCurrentUser().getUserId());
		boardDocServiceImpl.remove(_boardDocDTO);
		
		logger.debug("====> delete 삭제됐다"+_boardDocDTO);

		//list가 POST라 redirect로는 안될것 같다.
		
		list(model,search);
		
		return "/board/doc/list";
		
	}
	
	/**
	 * 게시글 삭제
	 * @param docId
	 */
	@ResponseBody
	@RequestMapping(value="/remove.json", method=RequestMethod.POST)
	public Integer delete(BoardDocDTO _boardDocDTO) {
		
		try {
			
			_boardDocDTO.setUserId(SecuritySession.getCurrentUser().getUserId());
			boardDocServiceImpl.remove(_boardDocDTO);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			logger.error("[ERROR]",e);
			return 0;
		}
		return 1;
	}
	
	
	// 모든글 보기
	@RequestMapping(value="/allview" , method=RequestMethod.GET)
	public List<BoardDocDTO> allView(Model model, @ModelAttribute("search") BoardSearchDTO search) {
		
		// 1. 전체 게시물 갯수 가져오기
		int cnt = boardDocDAOImpl.selectCount(search);
		search.setTotal(cnt);
		
		List<BoardDocDTO> list = boardDocDAOImpl.allView(search);
		model.addAttribute("list", list);
		
		//첨부파일 가져오기
		for(BoardDocDTO _boardDocDTO : list) {
			
			List<BoardFileDTO> fList = boardFileDAOImpl.selectList(_boardDocDTO.getDocId());
			_boardDocDTO.setfList(fList);
			
		}
				
		return list;
		
		
	}
	
	
	//주간인기글
	@RequestMapping(value="/hitlist", method=RequestMethod.GET)
	public List<BoardDocDTO> hitList(Model model, @ModelAttribute("search") BoardSearchDTO search) {
		
		// 1. 전체 게시물 갯수 가져오기
		int cnt = boardDocDAOImpl.selectCount(search);
		search.setTotal(cnt);
		
		List<BoardDocDTO> list = boardDocDAOImpl.hitList(search);
		model.addAttribute("list", list);
		
		//첨부파일 가져오기
		for(BoardDocDTO _boardDocDTO : list) {
			
			List<BoardFileDTO> fList = boardFileDAOImpl.selectList(_boardDocDTO.getDocId());
			_boardDocDTO.setfList(fList);
			
		}
				
		return list;
		
	}
	
	
}
