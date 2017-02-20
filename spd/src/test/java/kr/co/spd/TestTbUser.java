package kr.co.spd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.spd.user.dto.UserDTO;
import kr.co.spd.user.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
  "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
  "file:src/main/webapp/WEB-INF/spring/root-context.xml"}
)

public class TestTbUser {

	@Autowired private IUserService userServiceImpl = null;
	
	private static final Logger logger = LoggerFactory.getLogger(TestTbUser.class);
	
	@Test
	public void write() {

		UserDTO userDTO = new UserDTO();
		
		userDTO.setLgnId("1lgnid");
		userDTO.setLgnPw("1lgnpw");
		userDTO.setEmail("1email");
		userDTO.setPhone("1phone");
		userDTO.setName("1name");
		userDTO.setStatus(9);
		
		userServiceImpl.write(userDTO);
		
	}
	
	@Test
	public void edit() {
		
		UserDTO userDTO = new UserDTO();
		
		userDTO.setLgnPw("qwer1234");
		userDTO.setEmail("email");
		userDTO.setPhone("phone");
		userDTO.setName("name");
		userDTO.setStatus(9);
		
		userDTO.setUserId(65);
		
		userServiceImpl.edit(userDTO);
	}
	
	@Test
	public void view() {
		
		Integer userId = 100000;
		UserDTO userDTO = userServiceImpl.view(userId);
		logger.debug("===>view   " + userDTO );
		
	}
	
	@Test
	public void delete() {
		
		Integer userId = 100000;
		userServiceImpl.remove(userId);
		logger.debug("===>delete lgn_id  " + userId );
		
	}
	
	@Test
	public void edit2() {
		
		UserDTO userDTO = new UserDTO();
		
		userDTO.setLgnPw("qwer1234");
		
		userDTO.setLgnId("qwer1234");
		
		userServiceImpl.repw(userDTO);
	}
	
}
