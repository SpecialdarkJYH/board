package kr.co.spd.board.dao;

import java.util.List;

import kr.co.spd.board.dto.BoardFileDTO;

public interface IBoardFileDAO {

	public void insert(BoardFileDTO _BoardFileDTO);
	
	public void delete(Integer _fileId);

	public void deleteByDocId(Integer _docId);
	
	public List<BoardFileDTO> selectList(Integer _docId);
	
	public BoardFileDTO selectOne(Integer _fileId);
}
