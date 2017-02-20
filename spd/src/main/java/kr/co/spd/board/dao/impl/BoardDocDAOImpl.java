package kr.co.spd.board.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import kr.co.spd.board.dao.IBoardDocDAO;
import kr.co.spd.board.dto.BoardDocDTO;
import kr.co.spd.board.dto.BoardSearchDTO;

@Repository
public class BoardDocDAOImpl extends SqlSessionDaoSupport implements IBoardDocDAO {

	@Override
	public void insert(BoardDocDTO _boardDocDTO) {
		
		getSqlSession().insert("BoardDoc.insertData", _boardDocDTO);
		
	}

	@Override
	public void update(BoardDocDTO _boardDocDTO) {
		
		getSqlSession().update("BoardDoc.updateData", _boardDocDTO);
		
	}

	@Override
	public BoardDocDTO selectOne(Integer _docId) {
		
		return getSqlSession().selectOne("BoardDoc.selectData", _docId);
	}

	@Override
	public void delete(BoardDocDTO _boardDocDTO) {
		
		getSqlSession().delete("BoardDoc.deleteData", _boardDocDTO);
		
	}

	@Override
	public List<BoardDocDTO> selectList(BoardSearchDTO _search) {
		
		return getSqlSession().selectList("BoardDoc.selectList", _search);
	}
	
	@Override
	public int selectCount(BoardSearchDTO _search) {
		
		return getSqlSession().selectOne("BoardDoc.selectCount", _search);
	}

	@Override
	public void cntHit(Integer _docId) {
		
		getSqlSession().update("BoardDoc.cntHit", _docId);
		
	}

	@Override
	public List<BoardDocDTO> mywrite(BoardSearchDTO _search) {

		return getSqlSession().selectList("BoardDoc.mywrite", _search);
	}
	
	@Override
	public List<BoardDocDTO> allView(BoardSearchDTO _search) {
		
		return getSqlSession().selectList("BoardDoc.allView", _search);
	}

	@Override
	public List<BoardDocDTO> hitList(BoardSearchDTO _search) {
		
		return getSqlSession().selectList("BoardDoc.hitList", _search);
	}

	@Override
	public List<BoardDocDTO> newDoc() {
		
		return getSqlSession().selectList("BoardDoc.newDoc");
	}


	

}
