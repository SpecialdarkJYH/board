package kr.co.spd.user.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.spd.user.dao.IUserDAO;
import kr.co.spd.user.dto.UserDTO;
import kr.co.spd.user.service.IUserService;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired private IUserDAO userDAOImpl = null;
	
	@Override
	public void write(UserDTO _userDTO) {
		
		userDAOImpl.insert(_userDTO);
		
	}

	@Override
	public void edit(UserDTO _userDTO) {
		
		userDAOImpl.update(_userDTO);
		
	}

	@Override
	public UserDTO view(Integer _userId) {
		
		UserDTO userDTO = userDAOImpl.selectOne(_userId);
		
		return userDTO;
	}


	@Override
	public void remove(Integer _userId) {
		
		userDAOImpl.delete(_userId);
		
	}

	@Override
	public String isAvailableId(String _lgnId) {
		
		UserDTO userDTO = userDAOImpl.selectOneByLgnId(_lgnId);
		
		if(userDTO == null) {
			
			return "Y";
			
		} else {
			
			return "N";
		}
		
	}

	@Override
	public String isAvailableId2(String _email) {

		UserDTO userDTO = userDAOImpl.selectDataByEmail(_email);
		
		if(userDTO == null) {
			
			return "Y";
			
		} else {
			
			return "N";
		}
	}

	@Override
	public void repw(UserDTO _userDTO) {
		
		userDAOImpl.repw(_userDTO);
		
	}

	@Override
	public String captcha(Map<String, String> paramMap) {
		
		String check = "Y";
	     
	    ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
	    reCaptcha.setPrivateKey("6Le49xIUAAAAAESbMlfK7FU6XSFmz2if9OQBoQUM");//Secret key
	 
	    String host = paramMap.get("host");
	    String challenge = paramMap.get("challenge");
	    String res = paramMap.get("response");
	     
	    ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(host, challenge, res);
	 
	    if (reCaptchaResponse.isValid()) {
	        
	    	System.out.println("true");
	    	check = "Y";
	    	
	    } else {
	        
	    	System.out.println("false");
	        check = "N";
	    }
	     
	    return check;
	}


	@Override
	public String myinfocheck(String _lgnId, String _lgnPw) {
		
		UserDTO userDTO = userDAOImpl.selectOneByLgnId(_lgnId);
		
		if (_lgnPw.equals(userDTO.getLgnPw())) {				
			
			return "Y";
			
		} else {
			
			return "N";
		}
	}

	
	
}
