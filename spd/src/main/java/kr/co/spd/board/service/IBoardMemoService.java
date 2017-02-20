package kr.co.spd.board.service;

import java.util.List;

import kr.co.spd.board.dto.BoardMemoDTO;

public interface IBoardMemoService {

	public void write(BoardMemoDTO _boardMemoDTO);
	
	public void remove(Integer _memoId); 
	
	public List<BoardMemoDTO> list(Integer _docId);
	
}
