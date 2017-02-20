package kr.co.spd.board.dao;

import java.util.List;

import kr.co.spd.board.dto.BoardMapDTO;

public interface IBoardMapDAO {

	public void insert(BoardMapDTO _boardMapDTO);
	
	public void update(BoardMapDTO _boardMapDTO);
	
	public BoardMapDTO selectOne(Integer _mapId);
	
	public void delete(Integer _mapId);
	
	public List<BoardMapDTO> selectList();
}
