package kr.co.spd.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.spd.board.dto.BoardMemoDTO;
import kr.co.spd.board.service.IBoardMemoService;
import kr.co.spd.common.security.SecuritySession;

@RequestMapping("/board/memo")
@Controller
public class BoardMemoController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardMemoController.class);

	@Autowired private IBoardMemoService boardMemoServiceImpl = null;
	
	//댓글 쓰기
	@ResponseBody
	@RequestMapping(value="/write.json", method=RequestMethod.POST)
	public Integer write(BoardMemoDTO _boardMemoDTO/*, @RequestParam("docId") Integer docId, @RequestParam("memoContents") String memoContent*/){
		
		try {

			/*_boardMemoDTO.setDocId(docId);*/
			_boardMemoDTO.setUserId(SecuritySession.getCurrentUser().getUserId());
			/*_boardMemoDTO.setMemoContents(memoContents);*/
			
			boardMemoServiceImpl.write(_boardMemoDTO);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			logger.error("[ERROR]",e);
			return 0;
		}
		
		return 1;
		
		// Integer로 받는 이유는 ie 9 10 에서 오류가 나와서 한다 1 true , 0 false
		// RequestParam이 필요없는 이유는 form으로 전송하는 부분이 아니라서 의미가 없다.
		
	}
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public void list(Model model ,@RequestParam("docId") Integer docId) {
		
		List<BoardMemoDTO> mlist = boardMemoServiceImpl.list(docId);
		model.addAttribute("mlist", mlist);
		
		
	}
	
	/**
	 * 댓글삭제
	 * @param memoId
	 */
	@ResponseBody
	@RequestMapping(value="/delete.json", method=RequestMethod.POST)
	public Integer delete(@RequestParam("memoId") Integer memoId) {
		
		try {
			
			boardMemoServiceImpl.remove(memoId);
			return 1;
			
		} catch(Exception e) {
			
			e.printStackTrace();
			logger.error("[ERROR]",e);
			return 0;
		}
		
	}
	
	
}
