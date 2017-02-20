package kr.co.spd;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.spd.board.dto.BoardDocDTO;
import kr.co.spd.board.dto.BoardSearchDTO;
import kr.co.spd.board.service.IBoardDocService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
  "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
  "file:src/main/webapp/WEB-INF/spring/root-context.xml"}
)
public class TestTbBoardDoc {
	
	private static final Logger logger = LoggerFactory.getLogger(TestTbUser.class);

	@Autowired private IBoardDocService boardDocServiceImpl = null;
	
	@Test
	public void write() {

		BoardDocDTO bdDTO = new BoardDocDTO();
		
		bdDTO.setMapId(56);
		bdDTO.setUserId(65);
		bdDTO.setTitle("3타이틀");
		bdDTO.setHit(0);
		bdDTO.setDocContents("3컨텐츠");
		
		/*boardDocServiceImpl.write(bdDTO);*/
		
	}
	
	/*@Test
	public void edit() {
		
		BoardDocDTO bdDTO = new BoardDocDTO();
		
		bdDTO.setMapId(56);
		bdDTO.setUserId(65);
		bdDTO.setTitle("1타이틀수정");
		bdDTO.setHit(1);
		bdDTO.setDocContents("1컨텐츠");

		bdDTO.setDocId(2);
		
		boardDocServiceImpl.edit(bdDTO,Httpsession);
	}*/
	
	@Test
	public void view() {
		
		Integer docId = 3;
		BoardDocDTO bdDTO = boardDocServiceImpl.view(docId);
		logger.debug("===>view   " + docId );
		logger.debug("===>view   " + bdDTO );
		
	}
	
	@Test
	public void delete() {
		
		BoardDocDTO bdDTO = new BoardDocDTO();
		bdDTO.setDocId(1);
		bdDTO.setUserId(65);
		
		boardDocServiceImpl.remove(bdDTO);
		
		logger.debug("===>delete bdDTO  " + bdDTO );
		
	}

	@Test
	public void list() {
		
		BoardSearchDTO search = new BoardSearchDTO();
		search.setMapId(1);
		
		List<BoardDocDTO> list = boardDocServiceImpl.list(search);
		
		for (BoardDocDTO obj : list) {
			
			logger.debug("===>list" + obj);
		}
		
	}
	
	
}
