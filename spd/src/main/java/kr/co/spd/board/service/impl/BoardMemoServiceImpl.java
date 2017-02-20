package kr.co.spd.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.spd.board.dao.IBoardMemoDAO;
import kr.co.spd.board.dto.BoardMemoDTO;
import kr.co.spd.board.service.IBoardMemoService;

@Service
public class BoardMemoServiceImpl implements IBoardMemoService {
	
	@Autowired private IBoardMemoDAO boardMemoDAOImpl = null;

	@Override
	public void write(BoardMemoDTO _boardMemoDTO) {
		
		boardMemoDAOImpl.insert(_boardMemoDTO);
		
	}

	@Override
	public void remove(Integer _memoId) {
		
		boardMemoDAOImpl.delete(_memoId);
		
	}


	@Override
	public List<BoardMemoDTO> list(Integer _docId) {
		
		return boardMemoDAOImpl.selectList(_docId);
	}
	
	
	

	
	

}
