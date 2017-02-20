package kr.co.spd.board.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import kr.co.spd.board.dao.IBoardMemoDAO;
import kr.co.spd.board.dto.BoardMemoDTO;

@Repository
public class BoardMemoDAOImpl extends SqlSessionDaoSupport implements IBoardMemoDAO {

	@Override
	public void insert(BoardMemoDTO _boardMemoDTO) {

		getSqlSession().insert("BoardMemo.insertData", _boardMemoDTO);
		
	}

	@Override
	public void delete(Integer _memoId) {

		getSqlSession().delete("BoardMemo.deleteData", _memoId);
		
	}

	@Override
	public List<BoardMemoDTO> selectList(Integer _docId) {

		return getSqlSession().selectList("BoardMemo.selectList", _docId);
	}

	@Override
	public void deleteByDocId(Integer _docId) {
		
		getSqlSession().delete("BoardMemo.deleteByDocId", _docId);
		
	}

	@Override
	public List<BoardMemoDTO> newMemo() {
		
		return getSqlSession().selectList("BoardMemo.newMemo");
	}

	
}
