package kr.co.spd.board.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import kr.co.spd.board.dao.IBoardFileDAO;
import kr.co.spd.board.dto.BoardFileDTO;

@Repository
public class BoardFileDAOImpl extends SqlSessionDaoSupport implements IBoardFileDAO {

	@Override
	public void insert(BoardFileDTO _boardFileDTO) {

		getSqlSession().insert("BoardFile.insertData", _boardFileDTO);
		
	}

	@Override
	public void delete(Integer _fileId) {

		getSqlSession().delete("BoardFile.deleteData", _fileId);
		
	}
	
	@Override
	public void deleteByDocId(Integer _docId) {
		
		getSqlSession().delete("BoardFile.deleteDataByDocId", _docId);
		
	}

	@Override
	public List<BoardFileDTO> selectList(Integer _docId) {
		
		return getSqlSession().selectList("BoardFile.selectList", _docId);
	}

	@Override
	public BoardFileDTO selectOne(Integer _fileId) {
		
		return getSqlSession().selectOne("BoardFile.selectOne", _fileId);
	}
	
}
