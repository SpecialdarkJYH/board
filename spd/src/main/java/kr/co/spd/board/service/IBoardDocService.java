package kr.co.spd.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.spd.board.dto.BoardDocDTO;
import kr.co.spd.board.dto.BoardSearchDTO;

public interface IBoardDocService {

	public void write(BoardDocDTO _boardDocDTO, HttpSession httpSession);
	
	public void edit(BoardDocDTO _boardDocDTO, HttpSession httpSession);
	
	public BoardDocDTO view(Integer _docId);
	
	public void remove(BoardDocDTO _boardDocDTO); 
	
	public List<BoardDocDTO> list(BoardSearchDTO search);
	
}
