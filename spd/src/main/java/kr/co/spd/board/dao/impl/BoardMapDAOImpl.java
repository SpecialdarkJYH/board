package kr.co.spd.board.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import kr.co.spd.board.dao.IBoardMapDAO;
import kr.co.spd.board.dto.BoardMapDTO;

@Repository
public class BoardMapDAOImpl extends SqlSessionDaoSupport implements IBoardMapDAO {

	@Override
	public void insert(BoardMapDTO _boardMapDTO) {
		
		getSqlSession().insert("BoardMap.insertData", _boardMapDTO);
		
	}

	@Override
	public void update(BoardMapDTO _boardMapDTO) {
		
		getSqlSession().update("BoardMap.updateData", _boardMapDTO);
		
	}

	@Override
	public BoardMapDTO selectOne(Integer _mapId) {
		
		return getSqlSession().selectOne("BoardMap.selectData", _mapId);
	}

	@Override
	public void delete(Integer _mapId) {
		
		getSqlSession().delete("BoardMap.deleteData", _mapId);
		
	}

	@Override
	public List<BoardMapDTO> selectList() {
		
		return getSqlSession().selectList("BoardMap.selectList");
	}

	
}
