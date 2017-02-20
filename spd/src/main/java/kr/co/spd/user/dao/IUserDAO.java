package kr.co.spd.user.dao;

import kr.co.spd.user.dto.UserDTO;

public interface IUserDAO {

	public void insert(UserDTO _userDTO);
	public void update(UserDTO _userDTO);
	public UserDTO selectOne(Integer _userId);
	public UserDTO selectOneByLgnId(String _lgnId);
	public void delete(Integer _userId);
	public UserDTO selectDataByEmail(String _email);
	public void repw(UserDTO _userDTO);
}
