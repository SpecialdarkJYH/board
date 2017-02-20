package kr.co.spd.user.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import kr.co.spd.user.dao.IUserDAO;
import kr.co.spd.user.dto.UserDTO;

@Repository
public class UserDAOImpl extends SqlSessionDaoSupport implements IUserDAO{

	@Override
	public void insert(UserDTO _userDTO) {
		getSqlSession().insert("User.insertData", _userDTO);
		
	}

	@Override
	public void update(UserDTO _userDTO) {
		
		getSqlSession().update("User.updateData", _userDTO);
		
	}

	@Override
	public UserDTO selectOne(Integer _userId) {
		
		return getSqlSession().selectOne("User.selectData", _userId);
	}


	@Override
	public void delete(Integer _userId) {
		
		getSqlSession().delete("User.deleteData", _userId);
		
	}

	@Override
	public UserDTO selectOneByLgnId(String _lgnId) {
		
		return getSqlSession().selectOne("User.selectDataByLgnId", _lgnId);
	}

	@Override
	public UserDTO selectDataByEmail(String _email) {
		
		return getSqlSession().selectOne("User.selectDataByEmail", _email);
	}

	@Override
	public void repw(UserDTO _userDTO) {
		
		getSqlSession().update("User.rePW", _userDTO);
		
	}

}
