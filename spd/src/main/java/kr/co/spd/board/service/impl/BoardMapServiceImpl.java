package kr.co.spd.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.spd.board.dao.IBoardMapDAO;
import kr.co.spd.board.dto.BoardMapDTO;
import kr.co.spd.board.service.IBoardMapService;

@Service
public class BoardMapServiceImpl implements IBoardMapService {
	
	@Autowired private IBoardMapDAO boardMapDAOImpl = null;
	
	@Override
	public void write(BoardMapDTO _boardMapDTO) {
		
		boardMapDAOImpl.insert(_boardMapDTO);
		
	}

	@Override
	public void edit(BoardMapDTO _boardMapDTO) {
		
		boardMapDAOImpl.update(_boardMapDTO);
		
	}

	@Override
	public BoardMapDTO view(Integer _mapId) {
		
		return boardMapDAOImpl.selectOne(_mapId);
	}

	@Override
	public void remove(Integer _mapId) {
		
		boardMapDAOImpl.delete(_mapId);
		
	}

	@Override
	public List<BoardMapDTO> list() {
		
		return boardMapDAOImpl.selectList();
	}

	

	
	

}
