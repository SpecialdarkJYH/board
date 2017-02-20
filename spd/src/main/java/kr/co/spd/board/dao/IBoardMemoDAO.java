package kr.co.spd.board.dao;

import java.util.List;

import kr.co.spd.board.dto.BoardMemoDTO;

public interface IBoardMemoDAO {

	public void insert(BoardMemoDTO _boardMemoDTO);
	
	public void delete(Integer _memoId);
	
	public void deleteByDocId(Integer _docId);
	
	public List<BoardMemoDTO> selectList(Integer _docId);
	
	public List<BoardMemoDTO> newMemo();
	
}
