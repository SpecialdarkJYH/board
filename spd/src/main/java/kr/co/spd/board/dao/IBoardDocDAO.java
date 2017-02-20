package kr.co.spd.board.dao;

import java.util.List;

import kr.co.spd.board.dto.BoardDocDTO;
import kr.co.spd.board.dto.BoardSearchDTO;

public interface IBoardDocDAO {

	public void insert(BoardDocDTO _boardDocDTO);
	
	public void update(BoardDocDTO _boardDocDTO);
	
	public BoardDocDTO selectOne(Integer _docId);
	
	public void delete(BoardDocDTO _boardDocDTO);
	
	public List<BoardDocDTO> selectList(BoardSearchDTO _search);
	
	public void cntHit(Integer _docId);
	
	public List<BoardDocDTO> mywrite(BoardSearchDTO _search);

	public int selectCount(BoardSearchDTO _search);
	
	public List<BoardDocDTO> allView(BoardSearchDTO _search);
	
	public List<BoardDocDTO> hitList(BoardSearchDTO _search);
	
	public List<BoardDocDTO> newDoc();
}
