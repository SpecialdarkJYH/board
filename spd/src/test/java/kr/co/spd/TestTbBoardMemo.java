package kr.co.spd;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.spd.board.dto.BoardMemoDTO;
import kr.co.spd.board.service.IBoardMemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
  "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
  "file:src/main/webapp/WEB-INF/spring/root-context.xml"}
)
public class TestTbBoardMemo {
	
	private static final Logger logger = LoggerFactory.getLogger(TestTbUser.class);

	@Autowired private IBoardMemoService boardMemoServiceImpl = null;
	
	@Test
	public void write() {

		BoardMemoDTO bmeDTO = new BoardMemoDTO();
		
		bmeDTO.setDocId(26);
		bmeDTO.setMemoContents("공지사항 메모3");
		bmeDTO.setUserId(65);
		
		boardMemoServiceImpl.write(bmeDTO);
		
	}
	
	@Test
	public void delete() {
		
		/*BoardDocDTO bdDTO = new BoardDocDTO();
		bdDTO.setDocId(1);
		bdDTO.setUserId(65);*/
		
		Integer memoId = 1;
		
		boardMemoServiceImpl.remove(memoId);
		
		logger.debug("===>delete memo  " + memoId);
		
	}

	@Test
	public void list() {
		
		Integer docId = 26;
		
		List<BoardMemoDTO> list = boardMemoServiceImpl.list(docId);
		
		for (BoardMemoDTO obj : list) {
			
			logger.debug("===>list" + obj);
		}
		
	}
	
	
}
