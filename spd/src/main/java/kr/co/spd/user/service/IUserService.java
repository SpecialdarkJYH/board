package kr.co.spd.user.service;

import java.util.Map;

import kr.co.spd.user.dto.UserDTO;

public interface IUserService {
	
	public void write(UserDTO _userDTO);
	
	public void edit(UserDTO _userDTO);
	
	public UserDTO view(Integer _userId);
	
	public void remove(Integer userId);
	
	public String isAvailableId(String _lgnId);
	
	public String isAvailableId2(String _email);

	public void repw(UserDTO _userDTO);
	
	public String captcha(Map<String, String> paramMap);
	
	public String myinfocheck(String _lgnId, String _lgnPw);
}
