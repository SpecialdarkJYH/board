package kr.co.spd.board.service;

import java.util.List;

import kr.co.spd.board.dto.BoardMapDTO;

public interface IBoardMapService {

	public void write(BoardMapDTO _boardMapDTO);
	
	public void edit(BoardMapDTO _boardMapDTO);
	
	public BoardMapDTO view(Integer _mapId);
	
	public void remove(Integer _mapId); 
	
	public List<BoardMapDTO> list();
	
}
