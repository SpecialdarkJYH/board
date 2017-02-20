package kr.co.spd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.spd.board.dao.IBoardFileDAO;
import kr.co.spd.board.dto.BoardFileDTO;
import kr.co.spd.board.dto.BoardMemoDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
  "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
  "file:src/main/webapp/WEB-INF/spring/root-context.xml"}
)
public class TestTbBoardFile {
	
	private static final Logger logger = LoggerFactory.getLogger(TestTbUser.class);

	@Autowired private IBoardFileDAO boardFileDAOImpl = null;
	
	@Test
	public void write() {
		
		BoardFileDTO bfDTO = new BoardFileDTO();
		
		bfDTO.setOrgFileNm("사진");
		bfDTO.setNewFileNm("12345");
		bfDTO.setExt("jpg");
		bfDTO.setFsize(12345);
		bfDTO.setFpath("내마음");
		bfDTO.setDocId(26);
		
		boardFileDAOImpl.insert(bfDTO);
		
	}
	
	@Test
	public void delete() {
		
		Integer fileId = 3;
		
		boardFileDAOImpl.delete(fileId);
		
		logger.debug("===>delete file  " + fileId);
		
	}

	
	
}
